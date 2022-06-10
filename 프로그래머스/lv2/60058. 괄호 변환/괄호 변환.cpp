#include <string>
#include <vector>
#include <stack>
using namespace std;

bool right_checking(string s){
    stack<char> stk;
    stk.push(s[0]);
    for(int i=1;i<s.length();i++){
        if(stk.top()=='('&&s[i]==')'){
            stk.pop();
            continue;
        }
        stk.push(s[i]);
    }
    if(stk.empty()) return true;
    return false;
}


string solution(string p) {
    string answer = "";
    if(p.empty()) return p;
    
    int left=0, right =0;
    string u="",v="";
    
    for(int i=0;i<p.length();i++){
        if(p[i]=='(') left++;
        else right++;
        
        if(left==right) {
            u=p.substr(0,i+1);
            v=p.substr(i+1);
            break;
        }
    }
    if(right_checking(u)) answer=u+solution(v);
    else{
        answer='('+solution(v)+')';
        for(int i=1;i<u.length()-1;i++){
            if(u[i]=='(') answer+=')';
            else answer+='(';
        }
    }
    
    
    return answer;
}