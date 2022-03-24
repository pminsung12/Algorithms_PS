#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define MAX 100001
int N;
bool visited[MAX];
vector<int> graph[MAX];
int parent[MAX];
//vector<pair<int,int>> res;

void bfs(){
    queue<int> q;
    q.push(1);
    visited[1]=true;
    while(!q.empty()){
        int cur=q.front();
        q.pop();
        for(int i=0;i<graph[cur].size();i++){
            int next=graph[cur][i];
            if(!visited[next]){
                q.push(next);
                visited[next]=true;
                //res.push_back({next, cur});
                parent[next]=cur;
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>N;
    for(int i=0;i<N-1;i++){
        int u,v;
        cin>>u>>v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    bfs();
    
    // for(auto iter=res.begin();iter!=res.end();iter++){
    //     cout<<iter->second<<'\n';
    // }
    for(int i=2;i<=N;i++){
        cout<<parent[i]<<'\n';
    }

    return 0;
}