import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
  
  int num;
  int count;
  int time;

  public Student(int num, int count, int time) {
    this.num = num;
    this.count = count;
    this.time = time;
  }

  @Override
  public int compareTo(Student o) {
    int comp1 = o.count - count;
    if(comp1 ==0){
      return o.time-time;
    }
    return comp1;
  }
}

class Main {

  static int N, K;
  static List<Student> list;
  static Student[] students;


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    
    students = new Student[101];
    list = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for(int k=0; k<K; k++){
      int input = Integer.parseInt(st.nextToken());

      if(students[input] == null){
        students[input] = new Student(input, 0, 0);
      } 
      if(students[input].count!=0){ // 사진틀에 존재한다면
        students[input].count++; // 추천 ++
      } else { // 사진틀에 없으면
        // 자리가 없을 때
        if(list.size()==N){
          Collections.sort(list);
          Student s = list.remove(N-1);
          s.count=0;
          s.time=0;
        }

        students[input].count=1;
        students[input].time = k;
        list.add(students[input]);

      }
    }

    Collections.sort(list, (a,b)-> a.num-b.num);
    for(Student s:list){
      System.out.printf(s.num+" ");
    }
  }
}