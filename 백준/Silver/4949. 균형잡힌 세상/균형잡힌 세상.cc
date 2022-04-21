#include <iostream>
#include <stack>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string input;
    while(1){
        stack <char> stk;
        bool balance = true;
        
        getline(cin,input);
        
        if(input==".") break;
        
        for(int i=0;i<input.size();i++){
            if(!balance) break;
            
            if(input[i]=='('){
                stk.push('(');
            }
            else if(input[i]==')'){
                if(!stk.empty()){
                    if(stk.top()=='(') {
                        stk.pop();
                        continue;
                    }
                }
                balance=false;
                break;
                
            }
            else if(input[i]=='['){
                stk.push('[');
            }
            else if(input[i]==']'){
                if(!stk.empty()){
                    if(stk.top()=='[') {
                        stk.pop();
                        continue;
                    }
                }
                balance=false;
                break;
            }
        }
        if(!balance||!stk.empty()) cout<<"no"<<'\n';
        else if(balance && stk.empty()) cout<<"yes"<<'\n';
    }
    return 0;
}