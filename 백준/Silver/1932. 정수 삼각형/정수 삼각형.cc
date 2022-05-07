#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n,temp;
    int res=0;
    int dp[501][500]={0,};
    cin>>n;
    int v[501][500]={0,};


    for(int i=1;i<=n;i++){
        for(int j=0;j<i;j++){
            cin>>v[i][j];
        }
    }
    dp[1][0]=v[1][0];

    for(int i=2;i<=n;i++){
        for(int j=0;j<i;j++){
            if(j==0){
                dp[i][j]=dp[i-1][j]+v[i][j];
            }
            else if(j==i-1){
                dp[i][j]=dp[i-1][j-1]+v[i][j];
            }
            else{
                dp[i][j]=max(dp[i-1][j-1],dp[i-1][j])+v[i][j];
            }
        }
    }

    for(int i=0;i<n;i++){
        res=max(res,dp[n][i]);
    }
    cout<<res<<'\n';

    return 0;
}

//       1
//      2 3
//     4 5 6
//    7 8 9 10
//   11 12 13 14
// 15 16 17 18 19


