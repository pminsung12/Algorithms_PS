#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t,n;
    long long int dp[101];
    dp[1]=1;
    dp[2]=1;
    dp[3]=1;
    dp[4]=2;
    dp[5]=2;
    cin>>t;
    while(t--){
        cin>>n;
        for(int i=6;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-5];
        }
        cout<<dp[n]<<'\n';
    }
    return 0;
}

// 1
// 1
// 1
// 2   1   1
// 2   2
// 3   2   1   dp[i-1]+dp[i-5]
// 4   3   1
// 5   4   1
// 7   5   2
// 9   7   2
// 12  9   3
// 16  12  4
// 21  16  5
