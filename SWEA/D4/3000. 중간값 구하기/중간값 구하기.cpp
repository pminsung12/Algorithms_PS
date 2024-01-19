#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    ll T;
    cin >> T;

    for (ll t = 1; t <= T; t++) {
        ll n, m;
        cin >> n >> m;
        
        priority_queue<ll> max_heap; // 최대 힙
        priority_queue<ll, vector<ll>, greater<ll>> min_heap; // 최소 힙
        max_heap.push(m);
        min_heap.push(m);
        
        ll ans=0;
        for (ll i = 1; i <= n; i++) {
            ll x, y;
            cin >> x >> y;
            
            if(max_heap.top() > x) 
                max_heap.push(x);
            else
                min_heap.push(x);
            
            if(max_heap.top() > y)
                max_heap.push(y);
            else
                min_heap.push(y);
                
            if(max_heap.size() == min_heap.size()){
                ans+=(max_heap.top() % 20171109);
                continue;
            }
            else if(max_heap.size() > min_heap.size()){
                max_heap.pop();
                min_heap.push(max_heap.top());
            }
            else{
                min_heap.pop();
                max_heap.push(min_heap.top());
            }
            ans += (max_heap.top() % 20171109);
        }
        
        cout << '#' << t << ' ' << ans % 20171109 << endl;
    }

    return 0;
}
