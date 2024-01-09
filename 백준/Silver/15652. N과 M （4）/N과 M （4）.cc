#include <iostream>
# define MAX 9

using namespace std;

int N,M;
int arr[MAX];

void dfs(int num, int k){
    if(k==M){
        for(auto i =0; i<M; i++){
            cout << arr[i] << ' ';
        }
        cout << '\n';
    }else{
        for(auto i=num; i<=N; i++){
            arr[k]=i;
            dfs(i,k+1);
        }
    }
    
}

int main()
{
    cin >> N >> M;
    dfs(1,0);

    return 0;
}