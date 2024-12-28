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
      input[n] = Integer.parseInt(br.readLine());
    }

    bubbleSort();
    for(int i=0; i<input.length; i++){
      System.out.println(input[i]);
    }
    
  }

  static void bubbleSort(){
    for(int i=0; i<input.length-1; i++){ 
      for(int j=0;j<input.length-i-1; j++){
        if(input[j]>input[j+1]){
          int tmp = input[j+1];
          input[j+1]=input[j];
          input[j]=tmp;
        }
      }
    }
  }
}