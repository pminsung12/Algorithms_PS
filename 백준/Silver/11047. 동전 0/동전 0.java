import java.io.*;
import java.util.*;

class Main{

  static int N,K;
  static int[] input;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    input = new int[N];
    
    for(int n=0; n<N; n++){
      input[n] = Integer.parseInt(br.readLine());
    }
    
    int cnt=0;
    for(int i=N-1; i>=0; i--){
      if(input[i]>K){
        continue;
      }
      cnt+=(K/input[i]);
      K%=input[i];
    }

    System.out.println(cnt);
  }

}