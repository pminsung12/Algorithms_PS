#include <iostream>
#include <algorithm>
#include <vector>
#include <functional>
using namespace std;

bool compare(int i, int j){
    return i>j;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin>>s;
    vector<int> v;
    for(int i=0;i<s.length();i++){
        v.push_back(s[i]-'0');
    }
    
    sort(v.begin(),v.end(),compare);
    
    for(auto& i:v){
        cout<<i;
    }

    return 0;
}