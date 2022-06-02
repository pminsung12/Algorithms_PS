#include <string>
#include <vector>
#include <cstring>

using namespace std;

bool visited[8];


void dfs(int cnt, char arr[], vector<string> data,string friends,int& answer){
    if(cnt==8){
        for(int i=0;i<data.size();i++){
            char a=data[i][0];
            char b=data[i][2];
            char sign=data[i][3];
            int dist=data[i][4]-'0';//문자를 정수로 변환
            dist++;//ex 사이에 두 칸있으면 실제로는 세 칸 떨어진 거
            
            int aindex=-1,bindex=-1;
            for(int j=0;j<8;j++){
                if(a==arr[j]) aindex=j;
                if(b==arr[j]) bindex=j;
                if(aindex != -1&&bindex!=-1)break;
            }
            if(sign=='='&&abs(aindex-bindex)!=dist) return;
            if(sign=='<'&&abs(aindex-bindex)>=dist) return;
            if(sign=='>'&&abs(aindex-bindex)<=dist) return;
        }
        answer++;
        return;
    }
    for(int i=0;i<8;i++){
        if(visited[i]==true) continue;
        visited[i]=true;
        arr[cnt]=friends[i];
        dfs(cnt+1,arr,data,friends,answer);
        visited[i]=false;
    }
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
    char arr[8]={0,};
    int answer = 0;
    // memset(visited, false, 8);
    string friends="ACFJMNRT";
    dfs(0,arr,data,friends,answer);
    
    return answer;
}