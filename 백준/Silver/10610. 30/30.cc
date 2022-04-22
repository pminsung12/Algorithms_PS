#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string N;
    cin>>N;
    int res=0;
    bool chk=false;
    vector<int> v;
    
    for(int i=0;i<N.size();i++){
        if(N[i]=='0') chk=true;
        res+=N[i]-'0';
        v.push_back(N[i]-'0');
    }
    if(chk&&res%3==0){
        sort(v.begin(),v.end(),greater<int>());
        for(auto i:v){
            cout<<i;
        }
    }
    else{
        cout<<"-1"<<'\n';
    }


    return 0;
}