#include <string>
#include <vector>

using namespace std;
int answer;

void dfs(vector<int>& numbers,int idx, int target,int size, int res){
    if(idx==size) {
        if(res==target) answer++;
        return;
    }

    dfs(numbers, idx+1,target,size,res+numbers[idx]);
    dfs(numbers, idx+1,target,size,res-numbers[idx]);
}

int solution(vector<int> numbers, int target) {
    answer = 0;
    dfs(numbers,0, target, numbers.size(), 0);
    
    return answer;
}