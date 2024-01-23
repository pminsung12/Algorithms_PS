#include <iostream>
#include <string>
#include <queue>
#include <cstring>
#define MAX 101
using namespace std;

int n;
int map[MAX][MAX];
int visited[MAX][MAX];
int dx[4]={-1,0,1,0};
int dy[4]={0,1,0,-1};

struct Node{
    int x;
    int y;
};

bool ifOutOfZone(int x, int y){
    if(x<0 || x>=n || y<0 || y>=n){
        return true;
    }
    return false;
}

void bfs(){
    queue<Node> q;
    visited[0][0]=1; // 원래는 0이지만 방문했다는 표시로 1, 마지막에 결과값에서 -1 해주자.
    q.push({0,0});
    
    while(!q.empty()){
        Node cur = q.front();
        q.pop();
        
        for(int i=0; i<4; i++){
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
            
            if(ifOutOfZone(nx,ny)) continue;
            int cost = visited[cur.x][cur.y] + map[nx][ny];
            if(visited[nx][ny] && cost >= visited[nx][ny]) continue;
            
            visited[nx][ny]=cost;
            q.push({nx,ny});
        }
    }
    
}

int main() {
    int T;
    scanf("%d", &T);

    for (int testCase = 1; testCase <= T; testCase++) {
        scanf("%d", &n);

        for(int i=0; i<n; i++){
            char row[MAX];
            scanf("%s", row);
            for(int j=0; j<n; j++){
                map[i][j]=(int)(row[j]-'0');
            }
        }
        
        bfs();
        printf("#%d %d\n", testCase, visited[n-1][n-1]-1);
        memset(visited, 0, sizeof(visited));
        memset(map, 0, sizeof(map));
    }

    return 0;
}
