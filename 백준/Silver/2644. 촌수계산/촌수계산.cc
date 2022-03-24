#include <iostream>
#include <queue>
#include <vector>
using namespace std;
#define MAX 101

int n,a,b,m;
bool visited[MAX];
vector<int> graph[MAX];
int cnt[MAX];

int bfs(){
    queue<int> q;
    q.push(a);
    visited[a]=true;
    while(!q.empty()){
        int cur=q.front();
        if(cur==b){
            return cnt[b];
        }
        q.pop();
        for(int i=0;i<graph[cur].size();i++){
            int next=graph[cur][i];
            if(!visited[next]){
                q.push(next);
                visited[next]=true;
                //res.push_back({next, cur});
                //parent[next]=cur;
                cnt[next]=cnt[cur]+1;
            }
        }
    }
    return -1;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin>>n>>a>>b>>m;
    for(int i=0;i<m;i++){
        int u,v;
        cin>>u>>v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    cout<<bfs()<<'\n';

    return 0;
}