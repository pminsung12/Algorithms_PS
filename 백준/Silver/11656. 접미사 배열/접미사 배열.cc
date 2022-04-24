#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string s;
    string tmp;
    vector<string> v;

    cin>>s;
    for(int i=0;i<s.size();i++){
        
        tmp=s.substr(i,s.size()-i);
        v.push_back(tmp);
    }
    sort(v.begin(),v.end());
    for(auto i:v){
        cout<<i<<'\n';
    }
    return 0;
}