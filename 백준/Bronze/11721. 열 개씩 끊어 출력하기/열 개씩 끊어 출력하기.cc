#include <iostream>
#include <cstdio>
using namespace std;

int main(){
    
    char ch;
    int cnt=0;
    ch=getchar();
    while(ch!='\n'){
        putchar(ch);
        cnt++;
        if(cnt%10==0) cout<<endl;
        ch=getchar();
    }
    return 0;
}