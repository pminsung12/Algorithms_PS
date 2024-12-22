import java.io.*;
import java.util.*;

class Main {
  
  static int N,M;
  static int checkSecret=0;
  static int[] checkArr;
  static int[] myArr;
  static char[] input;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    checkArr = new int[4];
    myArr = new int[4];
    input = new char[N];

    input = br.readLine().toCharArray();

    st = new StringTokenizer(br.readLine());
    for(int m=0; m<4; m++){
      checkArr[m] = Integer.parseInt(st.nextToken());
      if(checkArr[m]==0){
        checkSecret++;
      }
    }
    
    for(int m=0; m<M; m++){
      add(input[m]);
    }

    int res=0;
    if(checkSecret==4) res++;

    int j=0;
    
    for(int i=M; i<N; i++){
      j=i-M;
      add(input[i]);
      remove(input[j]);
      if(checkSecret==4){
        res++;
      }
    }

    System.out.println(res);
  }

  static void add(char c){
    switch(c){
      case 'A':
        myArr[0]++;
        if(myArr[0]==checkArr[0]) checkSecret++;
        break;
      case 'C':
        myArr[1]++;
        if(myArr[1]==checkArr[1]) checkSecret++;
        break;
      case 'G':
        myArr[2]++;
        if(myArr[2]==checkArr[2]) checkSecret++;
        break;
      case 'T':
        myArr[3]++;
        if(myArr[3]==checkArr[3]) checkSecret++;
        break;
      default:
        break;
    }
  }
  
  static void remove(char c){
    switch(c){
      case 'A':
        if(myArr[0]==checkArr[0]) checkSecret--;
        myArr[0]--;
        break;
      case 'C':
        if(myArr[1]==checkArr[1]) checkSecret--;
        myArr[1]--;
        break;
      case 'G':
        if(myArr[2]==checkArr[2]) checkSecret--;
        myArr[2]--;
        break;
      case 'T':
        if(myArr[3]==checkArr[3]) checkSecret--;
        myArr[3]--;
        break;
      default:
        break;
    }
  }

}