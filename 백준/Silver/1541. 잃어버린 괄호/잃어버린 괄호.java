import java.io.*;
import java.util.*;

class Main{

  static int N,K;
  static int[] input;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
    int res = Integer.MAX_VALUE;

    while(sub.hasMoreTokens()){
      int sum=0;
      StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
      while(add.hasMoreTokens()){
        sum+=Integer.parseInt(add.nextToken());
      }

      if(res==Integer.MAX_VALUE){
        res=sum;
      } else {
        res-=sum;
      }
    }

    System.out.println(res);
  }

}