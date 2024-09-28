import java.util.*;
import java.io.*;

class Main {
  
  static int N, M, a, b, c;
  static int[] nums;
  static int[] parent;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    parent = new int[N+1];
    init();

    for(int m=0; m<M; m++){
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      if(a==0){
        // union
        union(b,c);

      } else {
        // print
        if(isInTheSameUnion(b, c)){
          System.out.println("YES");
        } else{
          System.out.println("NO");
        }
      }
    }
  }

  static void init(){
    for(int n=0; n<=N; n++){
      parent[n]=n;
    }
  }

  static void union(int a, int b){

    int aRoot = find(a);
    int bRoot = find(b);

    if(aRoot != bRoot){
      parent[bRoot]=aRoot;
    }
  }

  static int find(int a){
    if(parent[a]==a){
      return a;
    }
    return parent[a] = find(parent[a]);
  }

  static boolean isInTheSameUnion(int a, int b){
    int aRoot = find(a);
    int bRoot = find(b);

    if(aRoot == bRoot){
      return true;
    } 
    return false;
  }
}