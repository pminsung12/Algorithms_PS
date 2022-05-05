#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    long long int dp[91];
    dp[1]=1;
    dp[2]=1;
    dp[3]=2;
    cin>>n;
    for(int i=3;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
    }
    cout<<dp[n]<<'\n';

    return 0;
}
// 1
// 10
// 100 101
// 1000 1010 1001
// 10000 10010 10001 10100 10101 
// 100000 /100010 100001 101000 101001 /101010 /100100 100101