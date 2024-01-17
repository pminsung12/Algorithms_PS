#include <iostream>
#include <vector>
#include <unordered_set>
#define MAX 10001

using namespace std;

struct Node {
    int left;
    int right;
    int parent;
    Node(): left(0), right(0), parent(0){}
};

int treeSize(const vector<Node>& tree, int node){
    if (!node) return 0;
    int cnt = 1;
    cnt += treeSize(tree, tree[node].left);
    cnt += treeSize(tree, tree[node].right);

    return cnt;
}

int main() {
    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        int v, e, n, m;
        cin >> v >> e >> n >> m;

        vector<Node> tree(v + 1);
        bool visited[MAX]={false,};

        for (int i = 1; i <= e; i++) {
            int parent, child;
            cin >> parent >> child;
            if(tree[parent].left==0) tree[parent].left = child;
            else tree[parent].right = child;
            
            tree[child].parent = parent;
        }
        
        int cur = tree[n].parent;
        while(cur){
            visited[cur] = true;
            cur = tree[cur].parent;
        }
        
        int cur2 = tree[m].parent;
        while(cur2){
            if(visited[cur2]){
                cout << '#' << t << ' ' << cur2 << ' ' << treeSize(tree, cur2) << endl;
                break;
            }
            cur2 = tree[cur2].parent;
        }
    }

    return 0;
}
