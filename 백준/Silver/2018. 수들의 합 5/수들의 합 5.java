import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  
  static int N;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    int start=1;
    int end=1;
    int sum=1;
    int cnt=1; // N
    while(end!=N){
      if(sum < N){
        end++;
        sum+=end;
      } else if(sum>N){
        sum-=start;
        start++;
      } else {
        cnt+=1;
        end++;
        sum+=end;
      }
    }

    System.out.println(cnt);
  }

}