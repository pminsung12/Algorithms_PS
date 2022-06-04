//문제를 잘못 이해했었음. 테스트 5를 해보고 겨우 이해했네
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer,days;
    int cnt=0;
    for(int i=0;i<progresses.size();i++){
        int res=100-progresses[i];
        if(res%speeds[i]){
            days.push_back(res/speeds[i]+1);
        }
        else days.push_back(res/speeds[i]);
    }
    
    while(!days.empty()){
        cnt=0;
        int cur=days.front();
        for(int i=0;i<days.size();i++){
            if(cur>=days[i]){
                cnt++;
            }
            else break;
        }
        for(int i=0;i<cnt;i++){
            days.erase(days.begin());
        }
        answer.emplace_back(cnt);
    }
    
    
    return answer;
}