#include <iostream>
using namespace std;

#define MAX 2001
#define HASH_SIZE (1 << 30)
#define DIV (HASH_SIZE - 1)

int dream[MAX][MAX], teacher[MAX][MAX];
int teacherHash[MAX][MAX], tmp[MAX][MAX];
 
int multiplyByShift(int num, int shift) {
    unsigned long long rev = 1;
    for(int i = 1; i < num; i++) {
        rev = (rev << shift) + rev;
    }
    return (int) (rev & DIV);
}
 
int GetHash(int* piv, int num, int shift) {
    unsigned long long hash = 0;
    for(int i = 0; i < num; i++) {
        hash = (hash << shift) + hash + *piv++;
    }
    return (int) (hash & DIV);
}

// 롤링 해시를 사용하여 현재 해시 값에서 다음 해시 값을 계산
// 현재 해시 값에서 빠진 값(sub * mul)을 빼고,
// 새로운 값(add)을 추가하여 새로운 해시 값을 계산
int GetNext(int prev, int sub, int mul, int add, int shift) {
    unsigned long long hash = prev - (sub * mul);
    hash = (hash << shift) + hash + add;
    return (int) (hash & DIV);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int T;
    cin >> T;

    for (int testCase = 1; testCase <= T; testCase++) {
        int h, w, n, m;
        cin >> h >> w >> n >> m;
        
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                char a;
                cin >> a;
                if(a == 'o') dream[i][j] = 1;
                else dream[i][j] = 0;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char a;
                cin >> a;
                if(a == 'o') teacher[i][j] = 1;
                else teacher[i][j] = 0;
            }
        }

        // 꿈 해시값 계산
        for(int i = 0; i < h; i++) tmp[0][i] = GetHash(dream[i], w, 4);
        int dreamHash = GetHash(tmp[0], h, 5);
 
        // 선생님 그림 가능한 모든 부분 해시값 계산
        // tmp[]에는 선생님이 그린 그림의 각 행에 대한 해시 값을 계산
        int mulC = multiplyByShift(w, 4);
        int mulR = multiplyByShift(h, 5);
        for(int i = 0; i < n; i++) {
            tmp[0][i] = GetHash(teacher[i], w, 4);
            for(int j = 1; j < m - w + 1; j++) {
                tmp[j][i] = GetNext(tmp[j-1][i], teacher[i][j-1], mulC, teacher[i][j+w-1], 4);
            }
        }
        // teacherHash[]에는 각 열에 대한 선생님의 그림의 해시 값을 계산
        for(int i = 0; i < m - w + 1; i++) {
            teacherHash[0][i] = GetHash(tmp[i], h, 5);
            for(int j = 1; j < n - h + 1; j++) {
                teacherHash[j][i] = GetNext(teacherHash[j-1][i], tmp[i][j-1], mulR, tmp[i][j+h-1], 5);
            }
        }
 
        // 해시 값 비교
        int cnt = 0;
        for(int i = 0; i < n - h + 1; i++) for(int j = 0; j < m - w + 1; j++)
            if(teacherHash[i][j] == dreamHash) cnt++;
 
        cout << '#' << testCase << ' ' << cnt << endl;
    }

    return 0;
}
