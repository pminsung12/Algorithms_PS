#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct Node {
    char data;
    int left;
    int right;
};

void inorderTraversal(const vector<Node>& tree, int node, string& ans){
    if(!node) return;
    inorderTraversal(tree, tree[node].left, ans);
    ans += tree[node].data;
    inorderTraversal(tree, tree[node].right, ans);
}

int main()
{
    int T=10;
    for(int t=0;t<T;t++){
        int n;
        cin >> n;
        vector<Node> tree(n+1);
        for(int i=0; i<n; i++){
            int idx;
            cin >> idx;
            cin >> tree[idx].data;
            tree[idx].left = 0;
            tree[idx].right = 0;
            // 완전 이진트리이기 때문에 left, right 여부를 노드번호로 알 수 있다.
            if(n>=2*idx) cin >> tree[idx].left;
            if(n>=2*idx+1) cin >> tree[idx].right;
        }
        string ans = "";
        inorderTraversal(tree, 1, ans);
        cout << '#' << t+1 << ' ' << ans << endl;
    }
    
    
    return 0;
}
