#include <iostream>
using namespace std;

int checking(string a, string b){
    int cnt=0;
    for(int i=0;i<a.length();i++){
        if(a[i]!=b[i]) cnt++;
    }
    return cnt;
}

int part_checking(string a, string b){
    int res=100;
    int cnt=0;
    for(int i=0;i<=b.length()-a.length();i++){
        cnt=0;
        for(int j=0;j<a.length();j++){
            //cout<<a[j]<<' '<<b[i+j]<<' ';
            if(a[j]!=b[i+j]){
                cnt++;
            }
        }
        res=min(res,cnt);
        //cout<<res<<'\n';
    }
    return res;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string a,b;
    cin>>a>>b;
    int cnt=0;

    if(a.length()==b.length()){
        cnt=checking(a,b);
    }
    else{
        cnt=part_checking(a,b);
    }
    cout<<cnt<<'\n';
    return 0;
}