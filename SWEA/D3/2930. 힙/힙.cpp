#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 101

using namespace std;

void insertToHeap(vector<int>& max_heap, int x){
    max_heap.emplace_back(x);
    push_heap(max_heap.begin(), max_heap.end());
}

int popFromHeap(vector<int>& max_heap){
    if(max_heap.size() == 0){
        return -1;
    }
    pop_heap(max_heap.begin(), max_heap.end());
    int root = max_heap.back();
    max_heap.pop_back();
    return root;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        int n;
        cin >> n;
        
        vector<int> max_heap;
        make_heap(max_heap.begin(), max_heap.end());
        vector<int> res;
        
        for (int i = 1; i <= n; i++) {
            int cmd;
            cin >> cmd;
            if(cmd==1){
                int cmd2;
                cin >> cmd2;
                insertToHeap(max_heap, cmd2);
            }
            else if(cmd==2){
                res.emplace_back(popFromHeap(max_heap));
                
            }
        }
        
        cout << '#' << t << ' ';
        for(auto i: res){
            cout << i << ' ';
        }
        cout << endl;

    }

    return 0;
}
