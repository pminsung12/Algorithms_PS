import java.io.*;
import java.util.*;

class Main{

  static int N,M;
  static int[] inputN;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(br.readLine());
    inputN = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int n=0; n<N; n++){
      inputN[n] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(inputN);

    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int num;
    for(int m=0; m<M; m++){
      num = Integer.parseInt(st.nextToken());
      if(binarySearch(num)){
        sb.append("1\n");
      }else{
        sb.append("0\n");
      }
    }
    System.out.println(sb.toString());
  }

  static boolean binarySearch(int target){
    int start =0;
    int end = N-1;
    while(start<=end){
      int mid = (start+end)/2;
      if(inputN[mid]==target){
        return true;
      } else if(inputN[mid] < target){
        start = mid+1;
      } else {
        end = mid-1;
      }
    }
    return false;
  }


}