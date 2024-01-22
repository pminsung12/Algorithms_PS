#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <climits>

using namespace std;

int n, m, c1, c2;
vector<int> cows;

int binarySearch(int horse_z){
    // cows는 오름차순으로 정렬된 상태
    // horse_z좌표와 가장 가까운 소 z좌표 찾기
    int left=0, right=n-1;
    int mid=(left+right)/2;
    
    if(cows[left]>horse_z){ 
        return 0;
    }
    
    if(cows[right]<horse_z){
        return n-1;
    }
    
    while(left<=right){
        mid = (left+right)/2;
        int cow_z = cows[mid];
        if(cow_z==horse_z)
            return mid;
        else if(cow_z < horse_z)
            left = mid + 1;
        else
            right = mid - 1;
    }
    
    if(cows[mid] < horse_z){
        mid+=1;
    }
    
    return mid;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    scanf("%d", &T);

    for (int t = 1; t <= T; t++) {
        scanf("%d %d", &n, &m);
        scanf("%d %d", &c1, &c2);
        
        int dx = abs(c1-c2);
        int min_dist = INT_MAX;
        int cnt=0;
        
        for(int i=0; i<n; i++){
            int cow_z;
            scanf("%d", &cow_z);
            cows.emplace_back(cow_z);
        }
        
        sort(cows.begin(), cows.end());
        
        for(int i=0; i<m; i++){
            int horse_z;
            scanf("%d", &horse_z);
            
            int min_cow_idx = binarySearch(horse_z);
            int dist = abs(horse_z - cows[min_cow_idx]);
            
            
            if (min_dist > dist) {
                min_dist = dist;
                cnt = 1;
            }
            else if (min_dist == dist) {
                cnt += 1;
            }
            
      		// min_cow_idx가 0일 때는 그 아래 idx는 볼 필요 없으므로 조건 추가
            // 나머지 경우에는 horse_z 기준으로 cow_z와 같이 다를 때 큰쪽에서 가장 가까운 경우를 확인해봤으니, 
            // 작은 쪽에서 가장 가까운 경우도 확인해봐야 한다.
            if (min_cow_idx != 0 && cows[min_cow_idx] != horse_z) {
                int _dist = abs(horse_z - cows[min_cow_idx - 1]);
      
                if (min_dist > _dist) {
                    min_dist = _dist;
                    cnt = 1;
                }
                else if (min_dist == _dist) {
                    cnt += 1;
                }
            }
        }

        printf("#%d %d %d\n", t, dx + min_dist, cnt);
        
        cows.clear();
    }

    return 0;
}
