#include <iostream>
#include <cstring>
using namespace std;
#define MAX 301

int N,M;
int arr[MAX][MAX];
bool visit[MAX][MAX];
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};

void DFS(int x, int y){
    visit[x][y]=true;
    for(int i=0;i<4;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];
        if(nx>=1&&nx<N-1&&ny>=1&&ny<M-1&&arr[nx][ny]!=0&&!visit[nx][ny]){
            DFS(nx,ny);
        }
    }
}

void melt_ice(){
    int copy_arr[MAX][MAX];
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            copy_arr[i][j]=arr[i][j];
        }
    }
    for(int i=1;i<N-1;i++){
        for(int j=1;j<M-1;j++){
            int cnt=0;
            if(copy_arr[i][j]>0){
                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(copy_arr[nx][ny]==0) cnt++;
                }
                arr[i][j]-=cnt;
                if(arr[i][j]<0) arr[i][j]=0;
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>N>>M;
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin>>arr[i][j];
        }
    }
    int year=0;
    while(1){
        int island_cnt=0;
        bool chk=false;
        memset(visit,false,sizeof(visit));
        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                if(arr[i][j]>0 && !visit[i][j]){
                    island_cnt++;
                    if(island_cnt==2){
                        chk=true;
                        break;
                    }
                    DFS(i,j);
                }
                
            }
        }
        if(chk) break;
        if(island_cnt==0){
            cout<<'0'<<'\n';
            return 0;
        }
        melt_ice();
        year++;
    }
    cout<<year<<'\n';
    return 0;
}