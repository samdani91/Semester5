#include <iostream>
#include <iomanip> 
#include <fstream>
#include <vector>
#include <unordered_map>
#include <omp.h>
using namespace std;

const int N = 1000000;

struct Match
{
    int col1_index;
    int col2_index;
    int value;
    int core;
};

void loadData(const string &filename, vector<int> &col1, vector<int> &col2)
{
    ifstream file(filename);
    if (!file.is_open())
    {
        cerr << "Error opening file!" << endl;
        return;
    }

    int col1_value, col2_value;
    for (int i = 0; i < N; ++i)
    {
        file >> col1_value;
        col1.push_back(col1_value);
    }
    for (int i = 0; i < 500; ++i)
    {
        file >> col2_value;
        col2.push_back(col2_value);
    }
    file.close();
}

int main()
{
    vector<int> col1, col2;
    loadData("data.txt", col1, col2);

    int col1_size = col1.size();
    int col2_size = col2.size();

    vector<Match> results;

    int num_threads = 4;
    omp_set_num_threads(num_threads);

#pragma omp parallel
    {
        int thread_num = omp_get_thread_num();
        int start = thread_num * (col1_size / num_threads);
        int end = (thread_num == num_threads - 1) ? col1_size : start + (col1_size / num_threads);

        vector<Match> thread_results;

        unordered_map<int, int> col2_map;
        for (int i = 0; i < col2_size; ++i)
        {
            col2_map[col2[i]] = i;
        }

        for (int i = start; i < end; ++i)
        {
            int value = col1[i];
            if (col2_map.find(value) != col2_map.end())
            {
                int col2_index = col2_map[value];
                thread_results.push_back({i, col2_index, value, thread_num + 1});
            }
        }

#pragma omp critical
        results.insert(results.end(), thread_results.begin(), thread_results.end());
    }

    cout<<setw(9)<<"Colum 1"<<setw(9)<<"Column 2"<<setw(9)<<"Value"<<setw(9)<<"Core"<<endl<<endl;

    for (const auto &match : results)
    {
        cout << setw(9) <<  match.col1_index
             << setw(9) <<  match.col2_index
             << setw(10) <<  match.value
             << setw(10) <<  match.core << endl;
    }

    return 0;
}