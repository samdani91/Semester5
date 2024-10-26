#include<bits/stdc++.h>
using namespace std;

const int SIZE = 10;

vector<int>graph[SIZE];
vector<int>parent;
vector<int>color;
int cycleStart,cycleEnd;
vector<vector<pair<int, pair<string,string>>>> inputData;
// vector<int>inDegree;
map <int, int> inDegree;
vector<string>serial;

pair<string, string> splitString(const string& input);
int searchForDependency(int transactionNumber, int time, string variable, vector<string> operation);
bool dfs(int v);
void printGraph();
void countInDegree();
void findSerial();

int main(){
    string line;
    ifstream file("input.txt");


    if (!file.is_open()) {
        cerr << "Error opening file!" << endl;
        return 1;
    }

    while (getline(file, line)) {
        stringstream ss(line);
        string value;
        vector<string> values;
        getline(ss, value, ',');
        vector<pair<int, pair<string, string>>> vec;
        int time = 1;
        while (getline(ss, value, ',')) {
            if(value == "COM") break;
            else if(value == "-"){
                vec.push_back({time++, {value, value}});
            }
            else{
                vec.push_back({time++, splitString(value)});
            }
        }
        inputData.push_back(vec);
        vec.clear();
    }
    file.close();

    for(int i=0; i<inputData.size(); i++){
        for(int j=0; j<inputData[i].size(); j++){
            auto currentPair = inputData[i][j];
            if(currentPair.second.first == "-") continue;
            else if(currentPair.second.first == "R"){
                int dependency = searchForDependency(i, currentPair.first, currentPair.second.second, {"W"});
                if(dependency != -1){
                    if(find(graph[i+1].begin(), graph[i+1].end(), dependency+1) == graph[i+1].end()){
                        graph[i+1].push_back(dependency+1);
                    }
                }
            }
            else{
                int dependency = searchForDependency(i, currentPair.first, currentPair.second.second, {"W", "R"});
                if(dependency != -1){
                    if(find(graph[i+1].begin(), graph[i+1].end(), dependency+1) == graph[i+1].end()){
                        graph[i+1].push_back(dependency+1);
                    }
                }
            }
        }
    }

    printGraph();

    color.assign(SIZE,0);
    parent.assign(SIZE,-1);
    cycleStart=-1;

    for(int i=1; i<=SIZE; i++){
    	if(color[i] == 0 and dfs(i)) break;
    }

    if(cycleStart==-1){
    	cout<<"Cycle Not Found!"<<endl;
        cout<<"The Schedule is Conflict Serializable"<<endl<<endl;
        cout<<"Serial:";
        findSerial();
    }else{
    	vector<int>cycle;

    	cycle.push_back(cycleStart);
    	for(int v=cycleEnd;v!=cycleStart;v=parent[v]){
    		cycle.push_back(v);
    	}
    	cycle.push_back(cycleStart);
    	reverse(cycle.begin(),cycle.end());

    	cout<<"Cycle Found:"<<endl;
    	for(auto it:cycle) cout<<it<<" ";
        cout<<"The Schedule is not Conflict Serializable"<<endl;
    }

    

    // for(auto d: inputData){
    //     for(auto p: d){
    //         cout << p.first << " " << p.second.first << " " << p.second.second << endl;
    //     }
    // }


    return 0;
}

void printGraph(){
    cout<<"\nGraph:"<<endl;
    for(int i=0; i<SIZE; i++){
        if(!graph[i].empty()){
            cout << i << " -> ";
            for(auto d: graph[i]){
                cout << d << " ";
            }
            cout << endl;
        }
    }
    cout<<endl;
}

void countInDegree(){
    for(int i=0; i<SIZE; i++){
        if(!graph[i].empty()){
            if(!inDegree[i]){
                inDegree[i] = 0;
            }
            for(int d: graph[i]){
                inDegree[d]++;
            }
        }
    }
}

void findSerial(){
    countInDegree();
    while(!inDegree.empty()){
        int current = -1;
        for(auto id: inDegree){
            if(id.second == 0){
                serial.push_back("T" + to_string(id.first));
                for(auto g: graph[id.first]){
                    inDegree[g]--;
                }
                current = id.first;
                break;
            }
        }
        inDegree.erase(current);
    }
    for(auto s: serial){
        cout << s << " ";
    }
    cout << endl;
}

pair<string, string> splitString(const string& input) {
    size_t start = input.find('(');
    size_t end = input.find(')');

    if (start != string::npos && end != string::npos) {
        string part1 = input.substr(0, start);
        string part2 = input.substr(start + 1, end - start - 1);
        return {part1, part2};
    }

    return {"", ""};
}

int searchForDependency(int transactionNumber, int time, string variable, vector<string> operation){
    for(int i=0; i<inputData.size(); i++){
        if(i == transactionNumber) continue;
        for(int j=0; j<inputData[i].size(); j++){
            if(inputData[i][j].first < time) continue;
            if(variable == inputData[i][j].second.second){
                if(find(operation.begin(), operation.end(), inputData[i][j].second.first) != operation.end()){
                    return i;
                }
            }
        }
    }
    return -1;
}

bool dfs(int v){
	color[v] = 1;
	for(int u: graph[v]){
		if(color[u] == 0){
			parent[u] = v;
			if(dfs(u)) return true;
		}else if(color[u] == 1){
			cycleStart = u;
			cycleEnd = v;
			return true;
		}
	}
	color[v] = 2;
	return false;
}