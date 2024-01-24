#include <iostream>
#include <vector>
#include <unordered_set>
#include <string>
#include <algorithm>
#define MAX 51
using namespace std;

int n, m;
unordered_set<string> words;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    cin >> T;

    for (int testCase = 1; testCase <= T; testCase++) {
        cin >> n >> m;
        
        int cnt=0;
        string word;
        
        for(int i=0; i<n; i++){
            cin >> word;
            words.emplace(word);
        }
        
        for(int j=0; j<m; j++){
            cin >> word;
            if(words.find(word)!=words.end()) 
                cnt++;
        }
        cout << '#' << testCase << ' ' << cnt << endl;
        words.clear();
    }

    return 0;
}
