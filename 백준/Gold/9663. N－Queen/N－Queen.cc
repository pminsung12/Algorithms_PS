#include <iostream>
#include <cmath>
#define MAX 15

int col[MAX];
int n;
int ans = 0;
using namespace std;

bool ifValid(int level){
    for(auto i=0;i<level;i++){
        // 1. 같은 행에 있는지
        // 2. 대각선에 있는지
        if(col[i] == col[level] || abs(col[level]-col[i]) == level-i){
            return false;
        }
    }
    return true;
}

void nqueen(int x){
    if(x==n){
        ans++;
        return;
    }
    for(auto i=0; i<n; i++){
        col[x]=i;
        if(ifValid(x)){
            nqueen(x+1);
        }
    }
   
}

int main()
{
    cin >> n;
    nqueen(0);
    cout << ans << '\n';

    return 0;
}