#include <vector>
#include <queue>
#include <cstring>
using namespace std;

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    
    queue<pair<int,int>> q;
    int pic[m][n];
    bool visited[m][n];
    memset(visited,false,m*n);
    int dx[4]={0,0,-1,1};
    int dy[4]={1,-1,0,0};
    int size=0,flag=0;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            pic[i][j]=picture[i][j];
        }
    }
    
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(!visited[i][j]&&pic[i][j]!=0){
                flag=pic[i][j];
                visited[i][j]=true;
                size=0;
                size++;
                number_of_area++;
                
                q.push({i,j});
                while(!q.empty()){
                    auto cur=q.front();
                    q.pop();
                    for(int k=0;k<4;k++){
                        int nx=cur.first+dx[k];
                        int ny=cur.second+dy[k];
                        if(nx<0||nx>=m||ny<0||ny>=m) continue;
                        if(pic[nx][ny]==flag&&!visited[nx][ny]){
                            size++;
                            visited[nx][ny]=true;
                            q.push({nx,ny});
                        }
                    }
                }
                if(size>max_size_of_one_area) max_size_of_one_area=size;
            }
            
        }
    }
    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}