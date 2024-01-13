#include <iostream>
#include <string>
#include <algorithm>
#define MAX 1001

using namespace std;

string strA, strB;
int dp[MAX][MAX]; //이전 단계까지의 최적의 해

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    cin >> strA >> strB;
    
    int a_size = strA.length();
    int b_size = strB.length();
    
    for(auto i=1; i<=a_size; i++){
        for(auto j=1; j<=b_size; j++){
            if(strA[i-1]==strB[j-1]){
                dp[i][j]=dp[i-1][j-1]+1;
                continue;
            }
            // 같지 않을 때는, 하나만 포함된 것 중 큰 값 선정
            dp[i][j]=max(dp[i-1][j], dp[i][j-1]);
        }
    }
    cout << dp[a_size][b_size];
    return 0;
}
