#include <iostream>
#include <list>

using namespace std;

list<int> seq;

void myInsert(int pos, int tmp) {
    auto it = seq.begin();
    advance(it, pos); // list에서 특정 위치로 이동
    seq.insert(it, tmp);
}

void myDelete(int pos) {
    auto it = seq.begin();
    advance(it, pos);
    seq.erase(it);
}

void myChange(int pos, int tmp){
    auto it = seq.begin();
    advance(it, pos);
    *it = tmp; // 값 변경
}

int main() {
    int T;
    cin >> T;
    for(int t = 1; t <= T; t++) {
        
        seq.clear();
        
        int n, m, l;
        cin >> n >> m >> l;
            
        for(int i=0; i<n; i++){
            int tmp;
            cin >> tmp;
            seq.emplace_back(tmp);
        }
    
        while(m--){
        
            int pos, tmp;
            char cmd;
            cin >> cmd;
                
            
            if(cmd == 'I') {
                // I 명령어는 pos에 tmp를 삽입
                cin >> pos >> tmp;
                myInsert(pos, tmp);
            } else if(cmd == 'D') {
                // D 명령어는 pos 자리 값 제거
                cin >> pos;
                myDelete(pos);
            } else if(cmd == 'C') {
                // C 명령어는 pos 자리 값을 tmp로 변경
                cin >> pos >> tmp;
                myChange(pos, tmp);
            }
            
            // for(auto val:seq ){
            //     cout << val <<' ';
            // }
            // cout << endl;
        }
        
        cout << '#' << t << ' ';
        if(seq.size() < l){
            cout << -1 << endl;
            continue;
        }
        auto it = seq.begin();
        advance(it, l);
        cout << *it << endl;
    }

    return 0;
}
