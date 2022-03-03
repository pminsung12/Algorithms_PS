#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T,n;
    cin>>T;
    int dp[101];
    dp[1]=1;
    dp[2]=2;
    dp[3]=4;
    for(int i=0;i<T;i++){
        cin>>n;
        for(int j=4;j<=n;j++){
            dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
        }
        cout<<dp[n]<<'\n';
    }
    return 0;
}
    
   