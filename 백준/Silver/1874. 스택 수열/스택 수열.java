import java.io.*;
import java.util.*;

class Main{

  static int N;
  static int[] input;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    input = new int[N];
    for(int n=0; n<N;n++){
      input[n]= Integer.parseInt(br.readLine());
    }

    Stack<Integer> stk = new Stack<>();
    boolean isPossible=true;
    int num=1;
    for(int i=0; i<input.length; i++){
      int cur = input[i];
      if(cur >= num){
        while(cur>=num){
          stk.push(num++);
          sb.append("+\n");
        }
        stk.pop();
        sb.append("-\n");
      } else {
        int tmp = stk.pop();
        if(cur < tmp){
          System.out.println("NO");
          isPossible=false;
          break;
        } else {
          sb.append("-\n");
        }
      }
    }
    if(isPossible) System.out.println(sb.toString());

  }
}