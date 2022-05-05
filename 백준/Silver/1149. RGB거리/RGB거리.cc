#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin>>n;

    int cnt[1001][3]={0,};
    int rgb[4];
    for(int i=1;i<=n;i++){
        cin>>rgb[0]>>rgb[1]>>rgb[2];
        cnt[i][0]=min(cnt[i-1][1],cnt[i-1][2])+rgb[0];
        cnt[i][1]=min(cnt[i-1][0],cnt[i-1][2])+rgb[1];
        cnt[i][2]=min(cnt[i-1][0],cnt[i-1][1])+rgb[2];
    }
    cout<<min(cnt[n][0],min(cnt[n][1],cnt[n][2]));
    
    return 0;
}