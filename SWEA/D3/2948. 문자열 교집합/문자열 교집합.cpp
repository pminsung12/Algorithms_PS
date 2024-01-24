#include <iostream>
#include <vector>
#include <unordered_set>
#include <string>
#include <algorithm>
#define MAX 51
using namespace std;

int n, m;

int main() {
    int T;
    scanf("%d", &T);

    for (int testCase = 1; testCase <= T; testCase++) {
        scanf("%d %d", &n, &m);
        
        unordered_set<string> words;
        int cnt=0;
        string word;
        
        for(int i=0; i<n; i++){
            cin >> word;
            words.emplace(word);
        }
        
        for(int i=0; i<m; i++){
            cin >> word;
            if(words.find(word)!=words.end()) 
                cnt++;
        }
        
        printf("#%d %d\n", testCase, cnt);
    }

    return 0;
}
