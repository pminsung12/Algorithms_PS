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
        
        for(int i=0; i<word.length(); i++){
            for(int j=1; j<=word.length()-i; j++){
                trie.emplace_back(word.substr(i, j));
            }
        }

        
        sort(trie.begin(), trie.end());
        // unique 함수는 연속적인 중복값을 끝부분에 모아놓음.
        // 그리고 끝부분(쓰레기값의 처음) iterator를 반환
        // erase(s,e) 함수는 [s,e) 까지 지움.
        trie.erase(unique(trie.begin(), trie.end()), trie.end());
        
        if(trie.size() < k){
            cout << '#' << testCase << ' ' << "none" << endl;
            continue;
        }
        
        cout << '#' << testCase << ' ' << trie[k-1] << endl;
        
        trie.clear();
    }

    return 0;
}
