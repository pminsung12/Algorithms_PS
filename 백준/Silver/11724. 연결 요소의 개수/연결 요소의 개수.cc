#include <iostream>
#include <vector>
using namespace std;
#define MAX 1001
int N,M;
bool visited[MAX];
vector<int> graph[MAX];

void dfs(int x){
    visited[x]=true;
    for(int i=0;i<graph[x].size();i++){
        int nx=graph[x][i];
        if(!visited[nx]) dfs(nx);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>N>>M;
    int u,v;
    for(int i=0;i<M;i++){
        cin>>u>>v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    int cnt=0;
    for(int i=1;i<=N;i++){
        if(!visited[i]) {
            dfs(i);
            //cout<<i<<'\n';
            cnt++;
        }
    }
    cout<<cnt<<'\n';

    return 0;
}