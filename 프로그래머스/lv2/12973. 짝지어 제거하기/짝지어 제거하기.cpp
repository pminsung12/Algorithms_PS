#include <iostream>
#include <stack>
#include<string>
using namespace std;

int solution(string s)
{
    int answer = -1;
    stack<char> stk;
    char prev;
    stk.push(s[0]);
    prev=s[0];
    for(int i=1;i<s.length();i++){
        stk.push(s[i]);
        if(stk.size()>1){
            if(prev==s[i]){
                stk.pop();
                stk.pop();
            }
        }
        if(!stk.empty()) prev=stk.top();
    }
    if(stk.empty()) answer=1;
    else answer=0;
    
//     for(int i=0;i<stk.size();i++){
        
//         cout<<stk.top();
//         stk.pop();
//     }

    return answer;
}