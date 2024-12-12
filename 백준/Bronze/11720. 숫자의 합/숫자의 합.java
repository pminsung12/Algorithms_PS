import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    char[] input = br.readLine().toCharArray();
    
    int answer =0;
    for(int i=0; i<N; i++){
      answer+= input[i]-48;
    }

    System.out.println(answer);
  }
}