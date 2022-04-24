#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string s;
    
    vector<string> v;

    cin>>s;
    for(int i=0;i<s.size();i++){
        string tmp;
        for(int j=i;j<s.size();j++){
            tmp+=s[j];
        }
        v.push_back(tmp);
    }
    sort(v.begin(),v.end());
    for(auto i:v){
        cout<<i<<'\n';
    }
    return 0;
}