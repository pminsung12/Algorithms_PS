#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <climits>
#include <algorithm>
#define MAX 50001
using namespace std;

int n, m, x;
vector<pair<int, int>> graph[MAX];
vector<pair<int, int>> graph_reverse[MAX];
int res[MAX]; // 편도값 + 반대 방향 편도값

void dijkstra(int start, const vector<pair<int, int>> graph[]){
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int,int>>> pq; // 최소힙
    int dist[MAX]; // 편도 다익스트라
    fill(dist, dist + n + 1, INT_MAX); // 배열 초기화

    pq.push({0,start});
    dist[start]=0;
    
    while(!pq.empty()){
        
        int _dist = pq.top().first;
        int cur = pq.top().second;
        pq.pop();
        
        if (dist[cur] < _dist) continue;
        
        for(int i=0; i<graph[cur].size(); i++){
            int next = graph[cur][i].first;
            int cost = _dist + graph[cur][i].second;
            
            if(cost < dist[next]){
                dist[next]=cost;
                pq.push({cost, next});
            }
        }
    }
    
    for(int i=1; i<=n; i++){
        res[i]+=dist[i];
    }
}

int findMaxCost(const vector<pair<int, int>> graph[], const vector<pair<int, int>> graph_reverse[]){
    fill(res, res + n + 1, 0); 
    
    // x->i 즉, 간담회 장소에서 개인 강의실로 돌아오는 최단 경로
    dijkstra(x, graph);
     
    // i->x 즉, 개인 강의실에서 간담회 장소까지 가는 최소 경로, 하지만 이 경우를 경로를 뒤집어서 생각
    // 모든 지점에서 x로 오는 최소값을 구하려면, n번의 다익스트라를 돌려야하지만,
    // 입력받을 때 경로를 뒤집어 x에서 다른 모든 지점으로 다익스트라 돌려서 최소값 만드는 건 한번만 하면 됨.
    dijkstra(x, graph_reverse);
    
    int max_cost = *max_element(res + 1, res + n + 1);
    return max_cost;
}

int main() {
    int T;
    scanf("%d", &T);

    for (int testCase = 1; testCase <= T; testCase++) {
        scanf("%d %d %d", &n, &m, &x);
        
        for(int i=0; i<m; i++){
            int p, q, val;
            scanf("%d %d %d", &p, &q, &val);
            // i -> x
            graph[p].emplace_back(q,val);
            
            // x -> i
            graph_reverse[q].emplace_back(p,val);
        }
        
        int ans = findMaxCost(graph, graph_reverse);
        printf("#%d %d\n", testCase, ans);
        
        for(int i=1; i<=n; i++){
    		graph[i].clear();
    		graph_reverse[i].clear();
    	}
    }
	
    return 0;
}
