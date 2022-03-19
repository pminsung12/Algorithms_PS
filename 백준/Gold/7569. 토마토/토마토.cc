#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <tuple>
#define MAX 101
using namespace std;

int M,N,H;
int dx[6]={0,0,-1,1,0,0};
int dy[6]={1,-1,0,0,0,0};
int dz[6]={0,0,0,0,-1,1};
int tmt[MAX][MAX][MAX];
queue<tuple<int,int,int>> q;

bool isValid(int a, int b, int c){
    return a>=0&&a<H&&b>=0&&b<N&&c>=0&&c<M&&tmt[a][b][c]==0;
}

void bfs(){
    while(!q.empty()){
        int x=get<0>(q.front());
        int y=get<1>(q.front());
        int z=get<2>(q.front());
        q.pop();
        for(int u=0;u<6;u++){
            int nx=x+dx[u];
            int ny=y+dy[u];
            int nz=z+dz[u];
            if(isValid(nx,ny,nz)){
                tmt[nx][ny][nz]=tmt[x][y][z]+1;
                q.push(make_tuple(nx,ny,nz));
            }
        }
    }
    return;
}


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>M>>N>>H;
    for(int i=0;i<H;i++){
        for(int j=0;j<N;j++){
            for(int k=0;k<M;k++){
                cin>>tmt[i][j][k];
                if(tmt[i][j][k]==1){
                    q.push(make_tuple(i,j,k));
                }
            }
        }
    }
    bfs();
    int max=0;
    for(int i=0;i<H;i++){
        for(int j=0;j<N;j++){
            for(int k=0;k<M;k++){
                if(tmt[i][j][k]==0){
                    cout<<"-1"<<'\n';
                    return 0;
                }
                if(max<tmt[i][j][k]) max=tmt[i][j][k];
            }
        }
    }
    cout<<max-1<<'\n';
    return 0;
}