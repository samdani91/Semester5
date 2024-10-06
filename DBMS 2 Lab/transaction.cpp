#include<bits/stdc++.h>
#include<fstream>
using namespace std;

int main(){
    string filename = "log.txt", line, word;
    set<pair<string, string>> attributes;
    vector<pair<string,pair<int, int>>> transactions;
    vector<string> stillRunning;
    vector<string> undo;
    vector<string> redo;
    vector<string> lines;
    int lineNumber = 0;




    ifstream file(filename);
    if (!file.is_open()) {
        cerr << "Error opening file: " << filename << endl;
        return 1;
    }


    while (getline(file, line)) {
        istringstream iss(line);
        lines.push_back(line);
        lineNumber++;

        if(line.find("START") != string::npos){
            iss >> word;
            iss >> word;
            iss >> word;
            transactions.push_back({word, {lineNumber, -1}});
        }
        if(line.find("COMMIT") != string::npos){
            iss >> word;
            iss >> word;
            iss >> word;
            for(auto &t: transactions){
                if(t.first == word){
                    t.second.second = lineNumber;
                }
            }
        }
        else if(line.find("CKPT") != string::npos){
            for(int i=0; line[i] != '>';){
                if(line[i] == '(' or line[i] == ','){
                    i++;
                    string val;
                    while(line[i] != ',' and line[i] != ')') val.push_back(line[i++]);
                    stillRunning.push_back(val);
                }
                else i++;
            }
        }
    }

    file.close();

    int lineStart = INT_MAX;

    for(auto s: stillRunning){
        for(auto p: transactions){
            if(s == p.first){
                if(p.second.first < lineStart) lineStart = p.second.first;
            }
        }
    }

    for(auto t: transactions){
        if(t.second.first >= lineStart){
            if(t.second.second != -1) redo.push_back(t.first);
            else undo.push_back(t.first);
        }
    }

    for(auto u: undo){
        for(auto start: transactions){
            if(start.first == u){
                int i = start.second.first;
                while(i < lines.size()){
                    if(lines[i].find(start.first) != string::npos and lines[i].find("CKPT") == string::npos and lines[i].find("START") == string::npos and lines[i].find("COMMIT") == string::npos){
                        istringstream stream(lines[i]);
                        stream >> word;
                        stream >> word;
                        string name, value;
                        stream >> name;
                        stream >> value;
                        attributes.insert({name, value});
                    }
                    i++;
                }
            }
        }
    }

    for(auto u: redo){
        for(auto start: transactions){
            if(start.first == u){
                int i = start.second.first;
                while(i < lines.size()){
                    if(lines[i].find(start.first) != string::npos and lines[i].find("CKPT") == string::npos and lines[i].find("START") == string::npos and lines[i].find("COMMIT") == string::npos){
                        istringstream stream(lines[i]);
                        stream >> word;
                        stream >> word;
                        string name, value;
                        stream >> name;
                        stream >> word;
                        stream >> value;
                        attributes.insert({name, value});
                    }
                    i++;
                }
            }
        }
    }

    cout << "List of attributes that need to be redone: ";
    for(auto r: redo) cout << r << " ";
    cout << endl << endl;

    cout << "List of attributes that need to be undone: ";
    for(auto u: undo) cout << u << " ";
    cout << endl << endl;

    cout << "Final values of the attributes: " << endl;
    for(auto a: attributes){
        cout << a.first << " " << a.second << endl;   
    }


    return 0;
}