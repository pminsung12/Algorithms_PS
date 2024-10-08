import java.util.*;
import java.io.*;

class Main{
  
  static int N, M;
  static int maxLength;
  static int[] input;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    input = new int[N];
    maxLength=0;
    
    st = new StringTokenizer(br.readLine());
    for(int n=0; n<N; n++){
        input[n] = Integer.parseInt(st.nextToken());
        maxLength = Math.max(maxLength, input[n]);
    }

    int start=0, end=maxLength, mid=0, res=0;
    long sum=0;
    while(start<=end){
      mid = (start+end)/2;
      sum = getLength(mid);
      if(sum==M){
        res=mid;
        break;
      }
      else if(sum<M){
        // 내리기
        end = mid -1;
      } else if(sum>M ){
        // 올리기
        start = mid+1;
        res=mid;
      }
    }
    bw.write(String.valueOf(res));
    bw.flush();
    bw.close();
    br.close();
  }

  static long getLength(int n){
    long res=0;
    for(int i: input){
      if(i>n){
        res+=i-n;
      }
    }
    return res;
  }
}