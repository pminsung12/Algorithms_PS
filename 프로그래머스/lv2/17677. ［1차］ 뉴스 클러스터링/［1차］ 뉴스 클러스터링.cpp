#include <string>
#include <vector>
#include <cmath>

using namespace std;

string processing(string s){
    for(int i=0;i<2;i++){ //65 90 97 122
        if((s[i]>=65&&s[i]<=90)||(s[i]>=97&&s[i]<=122)) {//알파벳이라면
            if(s[i]>=65&&s[i]<=90) s[i]+=32;//다 소문자로 통일
        }
        else return "";
    }
    return s;
}

int solution(string str1, string str2) {
    int answer = 0, cnt=0, v2size=0;
    vector<string> v1;
    vector<string> v2;
    string s;
    for(int i=0;i<str1.length();i++){
        s=processing(str1.substr(i,2));
        if(!s.empty()) v1.emplace_back(s);
    }
    for(int i=0;i<str2.length();i++){
        s=processing(str2.substr(i,2));
        if(!s.empty()) v2.emplace_back(s);
    }
    v2size=v2.size();
    for(int i=0;i<v1.size();i++){
        for(int j=0;j<v2.size();j++){
            if(v1[i]==v2[j]) {
                cnt++;
                v2.erase(v2.begin() + j);
                break;
            }
        }
    }
    if(!cnt&&!(v1.size()+v2size-cnt)) return 65536;
    double result=(double)cnt/(v1.size()+v2size-cnt);
    answer=floor(result*65536);
    
    return answer;
}