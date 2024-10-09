import java.util.*;
import java.io.*;

class Main{
  
  static int N, M;
  static int[] input;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    input = new int[N+1];
    
    st = new StringTokenizer(br.readLine());
    for(int n=0; n<N; n++){
        input[n] = Integer.parseInt(st.nextToken());
    }

    // System.out.println(Arrays.toString(input));

    int low=0, high=0, sum=input[0], minLength=100001;
    while(true){
      if(sum >= M){
        minLength = Math.min(minLength, high-low+1);
        sum-=input[low];
        low++;
      } else {
        high++;
        sum+=input[high];
      }

      if(high==N){
        break;
      }
    }
    if(minLength == 100001){
      bw.write("0");
    } else {
      bw.write(String.valueOf(minLength));
    }
    bw.flush();
    bw.close();
    br.close();

  }
}