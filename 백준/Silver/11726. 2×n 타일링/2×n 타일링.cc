#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    int dp[1001];
    int k[1001];
    dp[1]=1;
    dp[2]=2;
    cin>>n;

    for(int i=3;i<=n;i++){
        dp[i]=(dp[i-1]+dp[i-2])%10007;
    }
    cout<<dp[n]<<'\n';
    return 0;
}