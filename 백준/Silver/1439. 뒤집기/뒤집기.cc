#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string s;
    cin>>s;
    int one_cnt=0, zero_cnt=0;

    if(s[0]=='1') one_cnt++;
    else zero_cnt++;
    for(int i=1;i<s.size();i++){
        if(s[i]=='1') {
            if(s[i-1]=='0') one_cnt++;
        }
        else {//0일때
            if(s[i-1]=='1') zero_cnt++;
        }
    }
    cout<<min(zero_cnt,one_cnt);
    return 0;
}