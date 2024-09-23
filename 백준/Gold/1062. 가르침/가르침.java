import java.io.*;
import java.util.*;

class Main {

  static int N, K, max_cnt=0;
  static boolean[] visited;
  static String[] strArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    strArr = new String[N];
    visited = new boolean[26];

    for(int i=0; i<N; i++){
      String fullWord=br.readLine();
      strArr[i] = fullWord.substring(4, fullWord.length()-4);
    }

    // for(int i=0; i<26; i++){
    //   visited[i]=false;
    // }

    // antic은 필수 포함.
    visited['a'-'a']=true;
    visited['n'-'a']=true;
    visited['t'-'a']=true;
    visited['i'-'a']=true;
    visited['c'-'a']=true;

    if(K<5){
      System.out.println(0);
    }else if(K>=26){
      System.out.println(N);
    }else if(K==5){
      System.out.println(countReadable());
    }else{
      for(int i=1; i<26; i++){ // a는 항상 visited이므로
        if(!visited[i]){
          dfs(i,6);
        }
      }
      System.out.println(max_cnt);
    }

  }

  static void dfs(int cur, int depth){
    // 1. 체크인
    visited[cur]=true;
    // 2. 목적지인가: depth가 K인가?
    if(depth == K) {
      int cnt = countReadable();
      max_cnt = Math.max(cnt, max_cnt);
    } else{
      // 3. 연결된 곳을 순회: 현재꺼에서 다음꺼 ~ z
      for(int i=cur+1; i<26; i++){
        // 4. 갈 수 있는가?: 방문한 적이 없다면
        if(!visited[i]){
          // 5. 간다: dfs 호출
          dfs(i, depth+1);
        }
      }
    }
    visited[cur]=false;
  }

  static int countReadable(){
    int cnt =0;
    for(int i=0; i<N; i++){
      String word = strArr[i];
      boolean isReadable = true;
      for(int j=0; j<word.length(); j++){
        if(!visited[word.charAt(j)-'a']){
          isReadable=false;
          break;
        }
      }
      if(isReadable){
        cnt++;
      }
    }
    return cnt;
  }
}