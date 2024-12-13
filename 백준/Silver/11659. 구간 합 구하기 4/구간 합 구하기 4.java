import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long[] input = new long[N];
    long[] partSum = new long[N];

    st = new StringTokenizer(br.readLine());
    for(int n=0; n<N; n++){
      input[n] = Long.parseLong(st.nextToken());
      if(n==0){
        partSum[n] = input[n];
      } else {
        partSum[n] = partSum[n-1] + input[n];
      }
    }
    
    for(int m=0; m<M; m++){
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      if(i==1){
        System.out.println(partSum[j-1]);
      } else {
        System.out.println(partSum[j-1]-partSum[i-2]);
      }
    }

  }
}