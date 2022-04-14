#include <iostream>
using namespace std;
#define MAX 21

int R,C;
char board[MAX][MAX];
//bool visited[MAX][MAX];
int alpha[25]={0,};//0~25번째 인덱스까지 A~Z, 'Z'-65 = 25
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};
int max_val=0;

bool isValid(int a, int b){
    if(a>=0&&a<R&&b>=0&&b<C) return true;
    return false;
}

void dfs(int a, int b, int cnt){
    max_val=max(max_val, cnt);
    for(int i=0;i<4;i++){
        int nx=a+dx[i];
        int ny=b+dy[i];
        if(isValid(nx,ny)){
            if(!alpha[(int)board[nx][ny]-65]){
                alpha[(int)board[nx][ny]-65]++;
                dfs(nx,ny,cnt+1);
                alpha[(int)board[nx][ny]-65]--;
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>R>>C;
    string s;
    for(int i=0;i<R;i++){
        cin>>s;
        for(int j=0;j<C;j++){
            board[i][j]=s[j];
        }
    }
    alpha[(int)board[0][0]-65]++;
    dfs(0,0,1);
    cout<<max_val<<'\n';
    return 0;
}