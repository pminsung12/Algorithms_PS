#include <iostream>
#include <vector>
#define MAX 101
 
using namespace std;
 
void dfs(vector<int> graph[], int x, bool visited[]){
    visited[x]=true;
    for(int i=0; i<graph[x].size(); i++){
        int nx = graph[x][i];
        if(visited[nx]==false){
            dfs(graph, nx, visited);
        }
    }
}
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
     
    int T;
    cin >> T;
 
    for (int t = 1; t <= T; t++) {
        int n, m;
        cin >> n >> m;
 
        vector<int> graph[n+1];
        bool visited[n+1]={false,};
        for (int i = 1; i <= m; i++) {
            int v1, v2;
            cin >> v1 >> v2;
            graph[v1].emplace_back(v2);
            graph[v2].emplace_back(v1);           
        }
         
        if(m==0){
            cout << '#' << t << ' ' << n << endl;
            continue;
        }
         
        int cnt = 0;
        for(int j=1; j<=n; j++){
            if(visited[j]==false){
                dfs(graph, j, visited);
                cnt++;
            }
        }
         
        cout << '#' << t << ' ' << cnt << endl;
    }
 
    return 0;
}
