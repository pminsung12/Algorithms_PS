#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

int V,E;
vector<int> graph[200001];
int red[20001];
int res;

void dfs(int x, int chk){ 
    if(red[x] == chk) {
        res=1;
        return;
    }
    if(chk) red[x]=0; 
    else red[x]=1;
    //cout<<"red[x]="<<red[x]<<'\n';
    for(int i=0;i<graph[x].size();i++){
        int nx=graph[x][i];
        //cout<<"nx: "<<nx<<'\n';
        if(red[nx]==red[x]){
            res=1;
            return;
        } 
        if(red[nx]==-1) dfs(nx,red[x]);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int K;
    cin>>K;
    while(K--){
        cin>>V>>E;
        for(int j=1;j<=V;j++){
            graph[j].clear();
        }
        int u,v;
        for(int i=0;i<E;i++){
            cin>>u>>v;
            graph[u].push_back(v);
            graph[v].push_back(u);
        }
        
        memset(red,-1,sizeof(red));
        for(int j=0;j<V;j++){
            if(red[j]==-1){
                red[j]=1;
                dfs(j,0);
            }
        }
        if(res) cout<<"NO"<<'\n';
        else cout<<"YES"<<'\n';
        res=0;
    }
    
    
    return 0;
}