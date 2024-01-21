#include <iostream>
#include <cmath>

using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    scanf("%d", &T);

    for (int t = 1; t <= T; t++) {
        ll n;
        scanf("%lld", &n);
        ll k = sqrt(n*2);
        if(k*(k+1) == n*2)
            printf("#%d %lld\n", t, k);
        else
            printf("#%d -1\n", t);
    }

    return 0;
}
