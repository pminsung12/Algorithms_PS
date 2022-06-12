#include <string>
#include <vector>
#define MAX 101
using namespace std;

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    int n=1;
    int x, y, xx, yy, tmp, min_val;
    int arr[MAX][MAX];
    for(int i=0;i<rows;i++){
        for(int j=0;j<columns;j++){
            arr[i][j]=n++;
        }
    }
    for (int i=0;i<queries.size();i++){
        x=queries[i][0]-1;
        y=queries[i][1]-1;
        xx=queries[i][2]-1;
        yy=queries[i][3]-1;
        tmp=arr[x][y];
        min_val=tmp;
        for(int j=x;j<xx;j++){//왼쪽변
            arr[j][y]=arr[j+1][y];
            min_val=min(min_val,arr[j][y]);
        }
        for(int j=y;j<yy;j++){//밑변
            arr[xx][j]=arr[xx][j+1];
            min_val=min(min_val,arr[xx][j]);
        }
        for(int j=xx-1;j>=x;j--){//밑변
            arr[j+1][yy]=arr[j][yy];
            min_val=min(min_val,arr[j+1][yy]);
        }
        for(int j=yy-1;j>y;j--){//밑변
            arr[x][j+1]=arr[x][j];
            min_val=min(min_val,arr[x][j+1]);
        }
        arr[x][y+1]=tmp;
        answer.emplace_back(min_val);
        
    }
    return answer;
}