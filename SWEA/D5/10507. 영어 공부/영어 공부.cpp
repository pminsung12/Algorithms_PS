#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <climits>

using namespace std;

int n, p;
vector<int> days;
vector<int> blanks;

int getMaxPeriod(){
    int maxPeriod = 0;
    for(int i=0; i<n; i++){
        int left=0, right=n-1, mid;
        int ans=0;
        while(left<=right){
            int mid=(left+right)/2;
            // i에서 mid 사이의 공부 안한 날 총 개수
            int didntStudyCnt = blanks[mid] - blanks[i];
            
            // remainP는 남아있는 P의 개수
            int remainP = (p - didntStudyCnt) ? p-didntStudyCnt : 0;
            if(p < didntStudyCnt){
                right = mid-1;
            }else{
                ans = days[mid]-days[i]+1+remainP;
                left = mid+1;
            }
        }
        if(maxPeriod<ans){
            maxPeriod=ans;
        }
    }
    return maxPeriod;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    scanf("%d", &T);

    for (int t = 1; t <= T; t++) {
        scanf("%d %d", &n, &p);

        for(int i=0; i<n; i++){
            int day;
            scanf("%d", &day);
            days.emplace_back(day);
        }
        
        int blankCount=0;
        blanks.clear();
        blanks.emplace_back(0);
        
        // blanks는 첫 날짜부터 j까지의 안 푼날 합산 값 저장한 벡터
        for(int i=0; i<n; i++){
            blankCount += days[i+1] - days[i] - 1;
            blanks.emplace_back(blankCount);
        }
        
        int ans = getMaxPeriod();
        printf("#%d %d\n", t, ans);
        days.clear();
    }

    return 0;
}
