import java.io.*;
import java.util.*;

class Main {
  
  static int N,M;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int n=0; n<N; n++){
      arr[n] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(arr);

    int start=0;
    int end=N-1;
    int sum= arr[start]+arr[end];
    int cnt=0; 
    while(start!=end){
      if(sum < M){
        sum-=arr[start];
        start++;
        sum+=arr[start];
      } else if(sum>M){
        sum-=arr[end];
        end--;
        sum+=arr[end];
      } else {
        cnt++;
        sum-=arr[end];
        end--;
        sum+=arr[end];
      }
    }

    System.out.println(cnt);
  }

}