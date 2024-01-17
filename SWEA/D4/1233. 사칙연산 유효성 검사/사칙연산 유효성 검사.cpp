#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct Node {
    string data;
    int left;
    int right;
};

bool checkIfComputable(int n, int idx, string data){
    if(n<2*idx && (data=="+" || data=="-" || data=="*" || data=="/")) return false;
    if(n>=2*idx && (data!="+" && data!="-" && data!="*" && data!="/")) return false;
    return true;
}

int main()
{
    int T=10;
    for(int t=0;t<10;t++){
        bool isComputable=true;
        int n;
        cin >> n;
        vector<Node> tree(n+1);
        for(int i=1; i<=n; i++){
            int idx;
            cin >> idx;
            cin >> tree[idx].data;
            if(!checkIfComputable(n, idx, tree[idx].data)){
                isComputable=false;
            }
            tree[idx].left = 0;
            tree[idx].right = 0;
            // 완전 이진트리이기 때문에 left, right 여부를 노드번호로 알 수 있다.
            if(n>=2*idx) cin >> tree[idx].left;
            if(n>=2*idx+1) cin >> tree[idx].right;
        }
        if(isComputable) {
            cout << '#' << t+1 << ' ' << 1 << endl;
            continue;
        }
        cout << '#' << t+1 << ' ' << 0 << endl;
    }
    
    
    return 0;
}
