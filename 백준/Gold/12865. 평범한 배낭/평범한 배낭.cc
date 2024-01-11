#include <iostream>

using namespace std;

struct Item{
    int weight, value;
};

int value[101][100001];
int n, k;
Item items[101]; 

int main()
{
    cin >> n >> k;
    for(auto i =1;i<=n;i++){
        int w, v;
        cin >> w >> v;
        items[i] = {w,v};
    }
    
    // knapsack dp
    for(auto i=1;i<=n;i++){
        for(auto j=1; j<=k; j++){
            int wi = items[i].weight;
            int vi = items[i].value;
            if(wi > j){ 
                // 현재 무게에 지금 선택된 것을 포함 x
                value[i][j] = value[i-1][j];
            }else{
                // 무게는 가능, 가치를 따짐.
                // 지금 선택된 것을 포함 X vs 포함 O
               value[i][j] = max(value[i-1][j], vi + value[i-1][j-wi]);
            }
            
        }
    }
    cout << value[n][k] << '\n';
    return 0;
}
