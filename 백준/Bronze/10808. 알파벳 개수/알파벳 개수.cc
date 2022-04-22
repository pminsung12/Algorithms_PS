#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int alpha[27]={0,};
    string s;
    cin>>s;

    for(int i=0;i<s.size();i++){
        alpha[s[i]-'a']++;
    }
    for(int i=0;i<26;i++){
        cout<<alpha[i]<<' ';
    }
    return 0;
}