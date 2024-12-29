import java.io.*;
import java.util.*;

class Main{

  static int inputLen;
  static int[] input;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String inputStr = br.readLine();
    inputLen = inputStr.length();
    input = new int[inputLen];
    for(int n=0; n<inputLen;n++){
      input[n] = Integer.parseInt(inputStr.substring(n,n+1));
    }

    selectionSort();
    for(int i=0; i<input.length; i++){
      System.out.printf("%d",input[i]);
    }
    
  }

  static void selectionSort(){
    int maxIdx;
    for(int i=0; i<inputLen; i++){ 
      maxIdx=i;
      for(int j=i+1; j<inputLen; j++){
        if(input[j]>input[maxIdx]){
          maxIdx=j;
        }
      }
      if(input[i]<input[maxIdx]){
        int tmp = input[maxIdx];
        input[maxIdx]= input[i];
        input[i]=tmp;
      }
    }
  }
}