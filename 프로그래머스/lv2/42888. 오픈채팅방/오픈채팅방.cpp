#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

vector<string> solution(vector<string> record) {
    
    vector<string> answer,temp;
    map<string,string> user;
    
    for(int i=0;i<record.size();i++){
        string str[3];
        string token;
        stringstream ss(record[i]);
        int index=0;
        while(ss>>token){
            str[index++]=token;
        }
        if(str[0]=="Enter"){
            temp.push_back("님이 들어왔습니다.");
            answer.push_back(str[1]);
            user[str[1]]=str[2];
        }
        else if(str[0]=="Leave"){
            temp.push_back("님이 나갔습니다.");
            answer.push_back(str[1]);
        }
        else if(str[0]=="Change"){
            user[str[1]]=str[2];
        }
    }
    for(int j=0;j<answer.size();j++){
        answer[j]=user[answer[j]]+temp[j];
    }
    
    return answer;
}