#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.size();
    for(int i=1;i<=s.size()/2;i++){
        int cnt=1;
        string res="",a="";
        a=s.substr(0,i);
        for(int j=i;j<s.size();j+=i){
            if(a==s.substr(j,i)){
                cnt++;
            }
            else{
                if(cnt>1) res+=to_string(cnt);
                res+=a;
                a=s.substr(j,i);
                cnt=1;
            }
        }
        if(cnt>1) res+=to_string(cnt);
        res+=a;
        if(answer>res.size()) answer=res.size();
    }
    return answer;
}