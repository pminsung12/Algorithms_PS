#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    string s;
    cin>>T;
    while(T--){
        cin>>s;
        cout<<(s[0]-'0')+(s[2]-'0')<<'\n';
    }
    return 0;
}