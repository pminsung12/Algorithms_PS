#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
                
    string s;
    int cnt=0;
    while(cnt<100){
        getline(cin,s);
        cout<<s<<endl;
        cnt++;
    }
    
    return 0;
}