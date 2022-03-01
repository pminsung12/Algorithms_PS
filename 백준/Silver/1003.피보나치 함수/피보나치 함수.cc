#include <iostream>
using namespace std;

int main(){
    int T;
    cin>>T;
    int z[41]={1,0,};
    int o[41]={0,1,};

    for(int i=0;i<T;i++){
        int N;
        cin>>N;
        for(int j=2;j<=N;j++){
            z[j]=z[j-1]+z[j-2];
            o[j]=o[j-1]+o[j-2];
        }
        cout<<z[N]<<" "<<o[N]<<'\n';
    }
    return 0;
}

