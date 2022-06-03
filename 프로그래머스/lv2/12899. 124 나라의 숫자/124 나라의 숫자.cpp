#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    int r;
    char arr[3]={'4','1','2'};
    while(n!=0){
        r=n%3;
        answer=arr[r]+answer;
        if(!(n%3))n=(n-1)/3;
        else n/=3;
    }
    
    return answer;
}