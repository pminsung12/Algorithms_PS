import java.util.Scanner;

public class Main {

	static int N,K;
	static int max_res=0;
	static Integer[] visited = new Integer[26];	
	static String[] str;
	private static Scanner sc;
	
	public static void main(String[] args) {
		// System.setIn(new FileInputStream("src/DAY01/P1062/input.txt"));
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		str=new String[N];
		
		for(int i=0; i<N; i++) {
			String full = sc.next();
			str[i]=full.substring(4,full.length()-4);
		}
		
		for(int i=0; i<26; i++) {
			visited[i]=0;
		}
		
		visited['a'-'a'] = 1;
		visited['n'-'a'] = 1;
		visited['t'-'a'] = 1;
		visited['i'-'a'] = 1;
		visited['c'-'a'] = 1;
		// antic은 항상 포함
//		System.out.println(visited.toString());
		if(K<5) {
			System.out.println(0);
		} else if (K>=26){
			System.out.println(N);
		} else if(K==5){
		    System.out.println(countReadableWord());
		}else {
			for(int i=0; i<26; i++) {
				if(visited[i]==0) {
					dfs(i, 5);
				}
			}
			System.out.println(max_res);
		}
		
		
		
	}
	
	static void dfs(int node, int depth) {
//		System.out.println("node: "+node+"depth: "+depth);
		// 1. 체크인
		visited[node]=1;
		depth+=1;
		// 2. 목적지인가? - 선택한 단어의 개수가 K개인가?
		if(depth==K) {
			int res = countReadableWord();
			max_res = Math.max(max_res, res);
			
		}
		else {
			// 3. 연결된 곳을 순회 - 현재보다 다음거 ~ z
			for(int next=node+1; next<26; next++) {
				// 4. 갈 수 있는가? - 방문한 적이 없으면
//				System.out.println(i);
				if(visited[next]==0) {
					// 5. 간다 - dfs 호출
					dfs(next, depth);
				}
			}
		}
		
		// 6. 체크아웃
		visited[node]=0;
	}
	
	static int countReadableWord() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			String word = str[i];
			boolean isReadable=true;
			for(int j=0; j<word.length(); j++) {
				if(visited[word.charAt(j)-'a']==0) {
					isReadable=false;
					break;
				}
			}
			if(isReadable) {
//				System.out.println(i+"번 째 단어");
				cnt++;
				
			} 
		}
		return cnt;
	}

}
