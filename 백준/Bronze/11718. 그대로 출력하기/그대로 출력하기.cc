#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    char ch[101];
    int cnt=0;
    while(cnt<100){
        cin.getline(ch,101);
        printf("%s\n",ch);
        cnt++;
    }
    
    return 0;
}