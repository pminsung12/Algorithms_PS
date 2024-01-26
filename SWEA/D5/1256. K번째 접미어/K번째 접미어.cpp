#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 401

int k;
string word;
vector<string> trie;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int T;
    cin >> T;
    
    for (int testCase = 1; testCase <= T; testCase++) {
        
        cin >> k >> word;
        if(word.length() < k){
            cout << '#' << testCase << ' ' << "none" << endl;
            continue;
        }
        
        for(int i=0; i<word.length(); i++){
            trie.emplace_back(word.substr(i));
        }
        
        sort(trie.begin(), trie.end());
        
        cout << '#' << testCase << ' ' << trie[k-1] << endl;
        
        trie.clear();
    }

    return 0;
}
