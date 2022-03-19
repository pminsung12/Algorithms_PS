#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
#define MAX 301

int length,m,n,u,v;
int chess[MAX][MAX];
bool visited[MAX][MAX];
int dx[8]={1,2,2,1,-1,-2,-2,-1};
int dy[8]={2,1,-1,-2,-2,-1,1,2};


bool isValid(int x, int y){
    return x>=0&&x<length&&y>=0&&y<length&&!visited[x][y];
}

int bfs(){
    chess[n][m]=0;
    queue<pair<int,int>> q;
    q.push(make_pair(n,m));
    visited[n][m]=true;
    while(!q.empty()){
        int x=q.front().first;
        int y=q.front().second;
        if(x==v&&y==u){
            return chess[x][y];
        }
        q.pop();
        for(int i=0;i<8;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(isValid(nx,ny)){
                chess[nx][ny]=chess[x][y]+1;
                q.push(make_pair(nx,ny));
                visited[nx][ny]=true;
            }
        }
    }
    return 0;

}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;
    cin>>T;
    for(int i=0;i<T;i++){
        memset(chess,0,sizeof(chess));
        memset(visited,false,sizeof(visited));
        cin>>length>>m>>n>>u>>v;
        int res=bfs();
        cout<<res<<'\n';
    }    
    return 0;
}