import java.util.*;
import java.io.*;

class Main{
  
  static int N, M;
  static int[] nums;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    nums = new int[N];
    ArrayDeque<Integer> q = new ArrayDeque<>();

    int sum=0, res=0;
    st = new StringTokenizer(br.readLine());
    for(int n=0; n<N; n++){      
      int cur = Integer.parseInt(st.nextToken());
      q.add(cur);
      sum+=cur;

      while(sum>M){
        if(!q.isEmpty()){
          sum-=q.poll();
        }
      }
      
      if(sum==M){
        res++;
      }
    }
    
    bw.write(String.valueOf(res));    
    bw.flush();
    bw.close();
    br.close();
  }
}