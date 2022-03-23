#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
#define MAX 101
int M,N,K;
int rect[MAX][MAX];
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};
bool visited[MAX][MAX];
int res,max_val,cnt;
vector<int> v;

bool ifValid(int x, int y){
    return x>=0&&x<M&&y>=0&&y<N&&visited[x][y]==false&&rect[x][y]==0;
}

void bfs(){
    queue<pair<int,int>> q;
    for(int i=0;i<M;i++){
        for(int j=0;j<N;j++){
            if(rect[i][j]==0&&!visited[i][j]){
                max_val=0;
                cnt=1;
                q.push({i,j});
                visited[i][j]=true;
                res++;
                while(!q.empty()){
                    int x=q.front().first;
                    int y=q.front().second;
                    q.pop();
                    for(int i=0;i<4;i++){
                        int nx=x+dx[i];
                        int ny=y+dy[i];
                        //맵 안에 있고
                        if(ifValid(nx,ny)){
                            q.push({nx,ny});
                            cnt++;
                            visited[nx][ny]=true;
                        }
                    }
                }
                v.push_back(cnt);
            }
        }
    }
    sort(v.begin(),v.end());
    return;
}

void fillRect(int a,int b,int c,int d){
    for(int i=M-d;i<=M-b-1;i++){ 
        for(int j=a;j<=c-1;j++){ 
            rect[i][j]=1;
        }
    }
}

// M-d  M-b-1
// a    c-1


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>M>>N>>K;
    int s,t,u,w;
    for(int i=0;i<K;i++){
        cin>>s>>t>>u>>w;
        fillRect(s,t,u,w);
    }
    bfs();
    cout<<res<<'\n';
    for(int i=0;i<v.size()-1;i++){
        cout<<v[i]<<' ';
    }
    cout<<v[v.size()-1]<<'\n';
    return 0;
}
