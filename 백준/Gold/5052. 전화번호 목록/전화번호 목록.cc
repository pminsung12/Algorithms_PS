#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;
    cin >> T;
    
    string num[10001];
    int n;
    
    while(T--) {
        bool isValid = true;
        cin >> n;
        
        for (int i = 0; i < n; i++) {
            cin >> num[i];
        }
 
        sort(num, num+n);
 
        for (int k = 0; k <= n-2; k++) {
            int current = num[k].length();
            int next = num[k+1].length();
 
            if (current >= next) continue;
            if (num[k + 1].substr(0, current)== num[k]) {
                isValid = false;
                cout << "NO" << '\n';
                break;
            }
        }
 
        if (isValid) cout << "YES" << '\n';
    }
    return 0;
}
