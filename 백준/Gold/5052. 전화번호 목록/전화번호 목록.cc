#include <iostream>
#include <algorithm>
using namespace std;

void checking(string num[], int n){
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            int t=min(num[i].length(),num[j].length());
            for(int k=0;k<t;k++){
                if(num[i][k]!=num[j][k]) break;
                else{
                    if(k==t-1){
                        cout<<"NO"<<'\n';
                        return;
                    }
                }
            }
        }
    }
    cout<<"YES"<<'\n';
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T,n;
    cin>>T;

    string num[10001];
    while(T--){
        cin>>n;
        for(int i=0;i<n;i++){
            cin>>num[i];
        }
        sort(num,num+n);
        checking(num,n);
    }
    return 0;
}