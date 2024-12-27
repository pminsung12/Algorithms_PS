import java.io.*;
import java.util.*;

class  Main{

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
      int first_abs = Math.abs(o1);
      int second_abs = Math.abs(o2);
      if(first_abs==second_abs){
        return o1>o2?1:-1;
      }
      return first_abs-second_abs;
    });

    for(int n=0; n<N;n++){
      int input = Integer.parseInt(br.readLine());
      if(input == 0){
        if(pq.isEmpty()){
          System.out.println("0");
        } else {
          System.out.println(pq.poll());
        }
      } else {
        pq.add(input);
      }
    }

    
  }
}