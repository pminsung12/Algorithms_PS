import java.util.*;
import java.io.*;

class Main {
  
  static int L, C;
  static char[] inputs;
  static boolean[] visited;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    inputs = new char[C];
    visited = new boolean[C];
    sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    for(int c=0; c<C; c++){
      inputs[c]=st.nextToken().charAt(0);
    }
    
    Arrays.sort(inputs);

    for(int c=0; c<C; c++){
      if(isVowel(inputs[c])){
        dfs(c, 0, 1);
      } else{
        dfs(c, 1, 0);
      }
    }
  }

  static boolean isVowel(char c){
    if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
      return true;
    }
    return false;
  }

  static void dfs(int cur, int con, int vow){
    // 1. 체크인: 현재까지 만들어진 암호
    sb.append(inputs[cur]);
    // 2. 목적지인가: length==L, 자음, 모음 조건건 -> 암호 출력
    if(sb.length()==L && con>=2 && vow>=1){
      System.out.println(sb.toString());
    } else{
      // 3. 연결된 곳을 순회
      for(int next=cur+1; next<C; next++){
        // 4. 갈 수 있다면
        if(isVowel(inputs[next])){
          // 방문
          dfs(next, con, vow+1);
        } else {
          dfs(next, con+1, vow);
        }
      }
    }
    sb.deleteCharAt(sb.length()-1);
  }
}
    