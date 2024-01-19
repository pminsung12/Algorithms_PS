#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<int> a;
    
    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        int n, k;
        cin >> n;
        
        int a[n+1];
        for (int i = 1; i <= n; i++) {
            int tmp;
            cin >> tmp;
            a[i]=tmp;
        }
        
        cin >> k;
        
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int, int>>> pq;
        pq.push(make_pair(0,k));
        while(pq.top().second){
            pair<int,int> cur = pq.top();
            pq.pop();
            
            pq.push(make_pair(cur.first + cur.second, 0));
            for(int i=1;i<=n;i++){
                pq.push(make_pair(cur.first + cur.second%a[i], cur.second/a[i]));
            }
        }
        
        cout << '#' << t << ' ' << pq.top().first << endl;
    }

    return 0;
}
