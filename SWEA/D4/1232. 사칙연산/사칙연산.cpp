#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct Node {
    string data;
    int left;
    int right;
};

double calculateTree(string data, double l, double r){
    if(data == "+") return l+r;
    if(data == "-") return l-r;
    if(data == "*") return l*r;
    else return l/r;
}

double inorderTraversalCalculation(const vector<Node>& tree, int node){
    if(!node) return 0.0;
    // 단말노드일 때
    if(tree[node].left==0 && tree[node].right==0) return stoi(tree[node].data);
    double lSubTree = inorderTraversalCalculation(tree, tree[node].left);
    double rSubTree = inorderTraversalCalculation(tree, tree[node].right);
    return calculateTree(tree[node].data, lSubTree, rSubTree);
}

bool isOperation(string data){
    if(data == "+" || data == "-" || data == "*" || data == "/") return true;
    return false;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T=10;
    for(int t=0;t<T;t++){
        int n;
        cin >> n;
        vector<Node> tree(n+1);
        for(int i=1; i<=n; i++){
            int idx;
            cin >> idx;
            cin >> tree[idx].data;
            tree[idx].left = 0;
            tree[idx].right = 0;
            if(isOperation(tree[idx].data)) cin >> tree[idx].left >> tree[idx].right;
        }
        cout << '#' << t+1 << ' ' << inorderTraversalCalculation(tree, 1) << endl;
    }
    
    
    return 0;
}