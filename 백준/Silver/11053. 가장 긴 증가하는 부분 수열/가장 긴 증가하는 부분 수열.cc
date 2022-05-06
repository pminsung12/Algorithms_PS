#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n,max_val=0;
    int dp[1001];
    dp[1]=1;

    cin>>n;
    int arr[n+1];
    for(int i=1;i<=n;i++){
        cin>>arr[i];
        for(int j=1;j<i;j++){
            if(arr[i]>arr[j]){
                max_val=max(max_val,dp[j]);
            }
        }
        dp[i]=max_val+1;
        max_val=0;
    }
    for(int i=1;i<=n;i++){
        max_val=max(max_val, dp[i]);
    }
    cout<<max_val<<'\n';
    
    return 0;
}