#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
typedef long long ll;

vector<ll> candies;

ll binarySearch(ll m, ll max_val){
    ll start = 1, end= max_val, ans=0;
    while(start<=end){
        ll mid = (start+end)/2;
        ll cnt = 0;
        
        for(auto& i: candies){
            cnt += i/mid;
        }
        
        if(cnt < m){
            end=mid-1;
        }
        else{
            ans = mid;
            start = mid+1;
        }
    }
    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    scanf("%d", &T);

    for (int t = 1; t <= T; t++) {
        int n;
        ll m;
        scanf("%d %lld", &n, &m);
        
        ll max_val = 0;
        for(int i=0; i<n; i++){
            ll num;
            scanf("%lld", &num);
            candies.emplace_back(num);
            if(max_val<num)
                max_val = num;
        }
        
        ll ans = binarySearch(m, max_val);
        printf("#%d %lld\n", t, ans);
        candies.clear();
    }

    return 0;
}
