#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define MAX 101
using namespace std;
int N,M;
int cnt=0;
int maze[MAX][MAX];
int dist[MAX][MAX];
bool visited[MAX][MAX];
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};
queue<pair<int,int>> q;

void bfs(int a, int b){
    q.push(make_pair(a,b));
    visited[a][b]=true;
    dist[a][b]++;
    
    while(!q.empty()){
        int x=q.front().first;
        int y=q.front().second;
        q.pop();
        for(int i=0;i<4;i++){//상하좌우
            int new_x=x+dx[i];
            int new_y=y+dy[i];
            if(new_x>=0&&new_x<N&&new_y>=0&&new_y<M&&visited[new_x][new_y]==false
                &&maze[new_x][new_y]==1){
                q.push(make_pair(new_x,new_y));
                visited[new_x][new_y]=true;
                /*
                    이게 핵심(값이 새로 씌워지지 않고 전칸에서 1을 더하니까 항상 최솟값)
                */
                dist[new_x][new_y]=dist[x][y]+1;
            }
        }
    }

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
            maze[i][j]=s[j]-'0';
        }
    }
    bfs(0,0);
    cout<<dist[N-1][M-1]<<'\n';
                
    return 0;
}