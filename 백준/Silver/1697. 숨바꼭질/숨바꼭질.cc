#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define MAX 100001
using namespace std;

int N,K;
bool visited[MAX];
queue<int> q;
int cnt[MAX];

int bfs(){
    q.push(N);
    visited[N]=true;
    while(!q.empty()){
        int x=q.front();
        
        //cout<<x<<'\n';
        q.pop();
        if(x==K){
            return cnt[x]; 
        }
        else{
                if(x-1>=0&&!visited[x-1]){
                    visited[x-1]=true;
                    q.push(x-1);
                    cnt[x-1]=cnt[x]+1;
                    
                }
                if(x+1<MAX&&!visited[x+1]){
                    visited[x+1]=true;
                    q.push(x+1);
                    cnt[x+1]=cnt[x]+1;
                }
                if(x*2<MAX&&!visited[x*2]){
                    visited[x*2]=true;
                    q.push(x*2);
                    cnt[x*2]=cnt[x]+1;
                }
        }
    }
    return 0;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>N>>K;
    int res=bfs();
    cout<<res<<'\n';
    return 0;
}