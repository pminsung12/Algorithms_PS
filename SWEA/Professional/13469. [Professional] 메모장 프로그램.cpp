#include <iostream>
#include <deque>
using namespace std;

deque<char> grid[303];
int counting[303][26];
int h, w;
int cur_r, cur_c;
int len;

void init(int H, int W, char str[])
{
	len=0;
	h=H, w=W;
	for(int i=0; i<303; i++){
	    grid[i].clear();
	    for (int j = 0; j < 26; j++) {
            counting[i][j] = 0;
        }
	}
	for(int i=0; i<H; i++){
	    for(int j=0; j<W; j++){
	        if(str[len]){
	            counting[i][str[len]-'a']++;
	            grid[i].push_back(str[len++]);
	        }else{
	            break;
	        }
	    }
	}
	cur_r = cur_c = 0;
}

// 커서 위치에 문자 mChar를 입력한다.
// 입력 후, 커서는 새로 입력된 문자의 오른쪽에 위치한다.
void insert(char c)
{
    grid[cur_r].insert(grid[cur_r].begin()+cur_c, c);
    counting[cur_r][c-'a']++;
    int row = cur_r;
    ++len;
    ++cur_c;
    if(cur_c==w){
        ++cur_r;
        cur_c=0;
    }
    
    // 삽입했을 때 줄이 넘치면 안넘칠 때까지 계속 한개씩 줄이 밀린다.
    while(grid[row].size()>w){
        char bk=grid[row].back();
        
        counting[row][bk-'a']--;
        grid[row].pop_back();
        
        counting[row+1][bk-'a']++;
        grid[row+1].push_front(bk);
        ++row;
    }
    
}

// 커서의 다음 문자를 리턴한다.
// 커서가 문자열 끝에 위치하여, 커서의 다음 문자가 없는 경우 ‘$’를 리턴한다.
char moveCursor(int row, int col)
{
	--row;
	--col;
	// 커서가 문자열 끝 이후면 문자열 끝으로 옮기고 $ 리턴
	if(row*w+col >=len){
	    row=len/w;
	    col=len%w;
	    cur_r=row;
	    cur_c=col;
	    return '$';
	}
	cur_r = row;
	cur_c = col;
	return grid[row][col];
}

// 커서의 뒤쪽 문자열에서 mChar 문자의 등장 횟수를 리턴한다.
int countCharacter(char c)
{
	int row = cur_r;
	int col = cur_c;
	int ret=0;
	if(col){
	    for(int i=col; i<grid[row].size(); i++){
	        ret += grid[row][i] == c;
	    }
	    ++row;
	}
	for(int i=row;i<h; i++){
	    ret+=counting[i][c-'a'];
	}
	return ret;
}
