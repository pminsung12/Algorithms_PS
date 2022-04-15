//DFS + DP
#include <iostream>
using namespace std;
#define MAX 501

int N,M;
int map[MAX][MAX];
bool visited[MAX][MAX];
int dp[MAX][MAX];
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};
int cnt=0;

bool isValid(int a, int b){
    if(a>=0&&a<N&&b>=0&&b<M) return true;
    return false;
}

int dfs(int x, int y){
    if(x==N-1&&y==M-1){
        return 1;
    }
    if(dp[x][y]!=-1) return dp[x][y];
    dp[x][y]=0;
    for(int i=0;i<4;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];
        if(isValid(nx,ny)){
            if(map[nx][ny]<map[x][y]){
                dp[x][y]+=dfs(nx,ny);
            }
        }
    }
    return dp[x][y];
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>N>>M;
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin>>map[i][j];
            dp[i][j]=-1;
        }
    }
    cout<<dfs(0,0)<<'\n';
    return 0;
}