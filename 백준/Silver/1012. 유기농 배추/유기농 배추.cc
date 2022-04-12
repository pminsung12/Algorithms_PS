#include <iostream>
#include <cstring>
using namespace std;
#define MAX 51

int N,M;
int cab[MAX][MAX];
bool visited[MAX][MAX];
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};

void dfs(int x,int y){
    if(x<0||x>=50||y<0||y>=100) return;
    visited[x][y]=true;
    for(int i=0;i<4;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];
        if(cab[nx][ny]&&!visited[nx][ny]){
            dfs(nx,ny);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T,K,u,v,cnt=0;
    cin>>T;
    while(T--){
        cin>>N>>M>>K;
        for(int i=0;i<K;i++){
            cin>>u>>v;
            cab[u][v]=1;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(cab[i][j]==1&&!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        cout<<cnt<<'\n';
        cnt=0;
        memset(visited,false,sizeof(visited));
        memset(cab,0,sizeof(cab));
    }

    return 0;
}