#include <iostream>
#include <set>
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
        
        multiset<ll> ms;
        ms.insert(m);
        
        multiset<ll>::iterator it = ms.begin();
        
        ll ans=0;
        for (ll i = 1; i <= n; i++) {
            ll x, y;
            cin >> x >> y;
            ms.insert(x);
            ms.insert(y);
            
            int mid = *it;
            
            if(x>=mid && y>=mid) it++;
            else if(x<=mid && y<=mid) it--;
            
            ans += *it % 20171109;
        }
        
        cout << '#' << t << ' ' << ans % 20171109 << endl;
    }

    return 0;
}
