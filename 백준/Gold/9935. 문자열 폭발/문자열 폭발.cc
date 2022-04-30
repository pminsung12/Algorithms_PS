#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    string bomb;
    string temp="";
    int cnt;

    cin>>s>>bomb;
    
    for(int i=0;i<s.length();i++){
        temp+=s[i];
        if(temp[temp.length()-1]==bomb[bomb.length()-1]){
            cnt=1;
            for(int j=1;j<bomb.length();j++){
                if(temp[temp.length()-1-j]==bomb[bomb.length()-1-j]){
                    cnt++;
                }
            }
            if(cnt==bomb.length()){
                while(cnt--){
                    temp.pop_back();
                }
            }
        }
    }
    if(temp.length()==0){
        cout<<"FRULA"<<'\n';
    }
    else{
        cout<<temp<<'\n';
    }
    return 0;
}