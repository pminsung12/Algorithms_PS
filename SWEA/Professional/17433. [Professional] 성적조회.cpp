#include <iostream>
#include <set>
#include <unordered_map>
using namespace std;

struct student{
    int id;
    int score;
};

bool operator<(const student &a, const student &b){
    if(a.score != b.score){
        return a.score < b.score;
    } 
    return a.id < b.id;
}

// 기본 오름차순 정렬
set<student> st[3][2];
// remove에서는 id를 통해 gender과 grade를 알아내야 함.
// 해시테이블 기반 자료형 사용
unordered_map<int, tuple<int, int, int>> tps;

void init() {
    for(int i=0; i<3; i++){
        for(int j=0; j<2; j++){
            st[i][j].clear();
        }
    }
    tps.clear();
	return;
}

// mGrade학년 mGender인 학생 중에서 점수가 가장 높은 학생의 ID를 반환한다.
// 점수가 가장 높은 학생이 여러 명이라면, 그 중에서 ID가 가장 큰 값을 반환한다.
int add(int mId, int mGrade, char mGender[7], int mScore) {
	--mGrade;
	// 여자면 0번째 인덱스에 들어가고 남자면 1번째 인덱스
	bool isFemale = mGender[0]=='f';
	auto &au = st[mGrade][isFemale];
	au.insert({mId, mScore});
	tps[mId] = {mGrade, isFemale, mScore};
	return au.rbegin()->id;
}

// 삭제 후에 mId 학생의 학년과 성별이 동일한 학생 중에서 점수가 가장 낮은 학생의 ID를 반환한다.
// mId 학생이 없거나, mId 학생의 학년과 성별이 동일한 학생이 없는 경우에는 0을 반환한다.
int remove(int mId) {
    // mId 학생이 없을 때
    if(tps.count(mId)==0){
        return 0;
    }
    int grade, gender, score;
    tie(grade, gender, score) = tps[mId];
    auto &au = st[grade][gender];
    au.erase({mId, score});
    tps.erase(mId);
    // 동일 학년, 성별 집합의 학생이 없을 때 
    if(au.empty()) return 0;
	return au.begin()->id;
}

 // mGrade 집합과 mGender 집합에 속하면서, 점수가 mScore 이상인 학생 중에서 점수가 가장 낮은 학생의 ID를 반환한다. 
 // 점수가 mScore 이상인 학생이 없는 경우에는 0을 반환한다.
int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][7], int mScore) {
    student ret{0,(int)1e9};
    
	for(int i=0; i<mGradeCnt; i++){
	    --mGrade[i];
	    for(int j=0; j<mGenderCnt; j++){
	        auto &au = st[mGrade[i]][mGender[j][0]=='f'];
	        // {0,mScore} 이상의 숫자가 처음으로 나오는 it 반환
	        // upper_bound는 초과인 숫자 찾기!
	        auto it = au.lower_bound({0,mScore});
	        // {0, mScore}보다 크거나 같은 첫 번째 원소를 찾지 못했다면 au.end() 반환
	        if(it != au.end()){
	            if(*it < ret){
	                ret=*it;
	            }
	        }
	    }
	}
	return ret.id;
}
