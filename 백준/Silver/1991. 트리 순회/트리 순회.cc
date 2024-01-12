#include <iostream>
#define MAX 27

using namespace std;

pair<char,char> nodes[26];
int n;

void preorder(char node){
    if(node == '.') return;
    
    cout << node;
    preorder(nodes[node-'A'].first);
    preorder(nodes[node-'A'].second);
}

void inorder(char node){
    if(node == '.') return;
    
    inorder(nodes[node-'A'].first);
    cout << node;
    inorder(nodes[node-'A'].second);
}

void postorder(char node){
    if(node == '.') return;
    
    postorder(nodes[node-'A'].first);
    postorder(nodes[node-'A'].second);
    cout << node;
}

int main()
{
    cin >> n;
    for(auto i=0;i<n;i++){
        char parent, left, right;
        cin >> parent >> left >> right;
        nodes[parent-'A'].first = left;
        nodes[parent-'A'].second = right;
    }
    preorder('A');
    cout << '\n';
    inorder('A');
    cout << '\n';
    postorder('A');
    

    return 0;
}
