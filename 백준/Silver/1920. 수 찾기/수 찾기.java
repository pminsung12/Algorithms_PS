import java.util.*;
import java.io.*;

class Main {
  
  static int N, M;
  static int[] A;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(br.readLine());
    A = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}

    Arrays.sort(A);

    M = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int m=0; m<M; m++){
			int input = Integer.parseInt(st.nextToken());
      if(binarySearch(A, input)){
        sb.append("1\n");
      }else{
        sb.append("0\n");
      }
    }
    System.out.println(sb.toString());

  }

  static boolean binarySearch(int arr[], int key){
    int start = 0;
    int end=arr.length -1;
    int mid;

    while(start <= end){
      mid = (start+end)/2;  
      if(key==arr[mid]){
        return true;
      } else if(key<arr[mid]){
        end = mid-1;
      } else {
        start = mid +1;
      }
    }
    return false;
  }
}