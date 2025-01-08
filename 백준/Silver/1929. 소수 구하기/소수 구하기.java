import java.io.*;
import java.util.*;

class Main{

  static int N,M;
  static int[] prime;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    prime = new int[N+1];
    prime[1]=1;
    for(int i=2; i<=Math.sqrt(N); i++){
      if(prime[i]!=0){
        continue;
      }
      for(int j=i+i; j<=N; j=j+i){
        
        prime[j]=1;

      }
    }

    for(int i=M; i<=N; i++){
      if(prime[i]!=1){
        System.out.println(i);
      }
    }
  }

}