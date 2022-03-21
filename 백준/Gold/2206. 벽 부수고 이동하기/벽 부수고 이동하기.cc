#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
#define MAX 1001

int N,M;
int map[MAX][MAX];
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};
int visited[MAX][MAX][2];

bool ifValid(int x, int y){
    return x>=0&&x<N&&y>=0&&y<M;
}

int bfs(){
    queue<pair<pair<int,int>,int>> q;
    q.push({{0,0},1});
    visited[0][0][1]=1;
    while(!q.empty()){
        int x=q.front().first.first;
        int y=q.front().first.second;
        int block=q.front().second;
        if(x==N-1&&y==M-1){
            return visited[x][y][block];
        }
        q.pop();
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            //맵 안에 있고
            if(ifValid(nx,ny)){
                //벽이고, 뚫을 수 있을 때
                if(map[nx][ny]==1&&block){
                    visited[nx][ny][block-1]=visited[x][y][block]+1;
                    q.push({{nx,ny},block-1});
                }
                //벽 아니고, 방문 안한곳이라면
                if(visited[nx][ny][block]==0&&map[nx][ny]==0){
                    visited[nx][ny][block]=visited[x][y][block]+1;
                    q.push({{nx,ny},block});
                }
            }
        }
    }
    return -1;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>N>>M;
    string s;
    for(int i=0;i<N;i++){
        cin>>s;
        for(int j=0;j<M;j++){
            map[i][j]=s[j]-'0';
        }
    }
    cout<<bfs()<<'\n';
    
    return 0;
}