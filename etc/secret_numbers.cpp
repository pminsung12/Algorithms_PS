#include <iostream>
#include <list>

using namespace std;

int n, m;
list<int> secret;

void myInsert(int pos, const list<int>& new_input) {
    auto it = secret.begin();
    advance(it, pos); // list에서 특정 위치로 이동
    secret.insert(it, new_input.begin(), new_input.end());
}

void myDelete(int pos, int cnt) {
    auto it = secret.begin();
    advance(it, pos);
    auto it_end = it;
    advance(it_end, cnt);
    secret.erase(it, it_end);
}

int main() {
    for(int t = 1; t <= 10; t++) {
        secret.clear();
        cin >> n;

        for(int i = 0; i < n; i++) {
            int tmp;
            cin >> tmp;
            secret.push_back(tmp);
        }

        cin >> m;

        while(m--) {
            int cnt, pos;
            char cmd;
            cin >> cmd;

            if(cmd == 'I') {
                // I 명령어는 pos에 cnt만큼 삽입
                cin >> pos >> cnt;
                list<int> new_input(cnt);
                for(auto& val : new_input) {
                    cin >> val;
                }
                myInsert(pos, new_input);
            } else if(cmd == 'D') {
                // D 명령어는 pos에 cnt만큼 제거
                cin >> pos >> cnt;
                myDelete(pos, cnt);
            } else if(cmd == 'A') {
                // A 명령어는 맨 뒤에 cnt만큼 추가
                cin >> cnt;
                list<int> new_input(cnt);
                for(auto& val : new_input) {
                    cin >> val;
                }
                secret.insert(secret.end(), new_input.begin(), new_input.end());
            }
        }
        
        cout << '#' << t << ' ';
        auto it = secret.begin();
        for(int i = 0; i < 10 && it != secret.end(); ++i, ++it) {
            cout << *it << ' ';
        }
        cout << endl;
    }

    return 0;
}
