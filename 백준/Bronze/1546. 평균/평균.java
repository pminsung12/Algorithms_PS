import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long N = Long.parseLong(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    long maxScore =0;
    long total=0;
    for(int n=0; n<N; n++){
      long tmp = Long.parseLong(st.nextToken());
      total += tmp;
      if(tmp>maxScore){
        maxScore = tmp;
      }
    }

    System.out.println(total * 100.0 / N / maxScore);    

  }
}