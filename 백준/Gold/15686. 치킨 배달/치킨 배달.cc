#include <iostream>
#include <string>
#include <climits>
#include <vector>
#include <algorithm>


using namespace std;

int n, m;
vector<pair<int, int>> chicken;
vector<pair<int, int>> home;
vector<pair<int, int>> picked;
bool selected[13];
int ans=INT_MAX;

// 두 점 사이 거리 구하기
int getDistance(pair<int,int> a, pair<int, int> b){
    return abs(a.first - b.first) + abs(a.second - b.second);
}

// m개의 치킨 집과 집 사이의 최소 거리인 도시의 치킨 거리 구하기
void getMinDistance(){
    int res=0;
    for(auto i=0;i<home.size();i++){
        int min_dist = INT_MAX;
        for(auto j=0;j<picked.size();j++){
            min_dist = min(min_dist, getDistance(home[i], picked[j]));
        }
        res += min_dist;
    }
    // 최소의 도시 치킨 거리값 최신화
    ans = min(ans, res);
}

// m개의 치킨집 조합 구하기 - 백트래킹
void getCombinations(int x, int k){
    if(k==m){
        getMinDistance();
    }
    
    for(auto i=x;i<chicken.size();i++){
        if(selected[i]==true){
            continue;
        }
        picked.emplace_back(chicken[i]);
        selected[i]=true;
        getCombinations(i,k+1);
        selected[i]=false;
        picked.pop_back();
    }
}


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
   
    cin >> n >> m;

    for(auto i=0;i<n;i++){
        for(auto j=0;j<n;j++){
            int k;
            cin >> k;
            if (k==1) 
                home.emplace_back(i,j);
            else if(k==2)
                chicken.emplace_back(i,j);
        }
    }
    
    getCombinations(0,0);
    cout << ans << endl;
    
    return 0;
}
