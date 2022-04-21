#include <iostream>
#include <string>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string s;
    string tmp;
    bool isMinus=false;
    int res=0;

    cin>>s;

    for(int i=0;i<=s.size();i++){
        if(s[i]=='+'||s[i]=='-'||i==s.size()){
            if(isMinus==false){
                res+=stoi(tmp);
            }
            else{
                res-=stoi(tmp);
                
            }
            tmp="";
            if(s[i]=='-') isMinus=true;
        }
        else{
            tmp+=s[i];
        }
    }
    cout<<res<<'\n';
    return 0;
}
