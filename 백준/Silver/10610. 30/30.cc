#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string N;
    cin>>N;
    int res=0;
    sort(N.begin(),N.end(),greater<char>());
    if(N[N.size()-1]!='0') cout<<-1<<'\n';
    else{
        for(auto i:N){
            res+=i-'0';
        }
        if(res%3==0) cout<<N;
        else cout<<-1<<'\n';
    }

    return 0;
}