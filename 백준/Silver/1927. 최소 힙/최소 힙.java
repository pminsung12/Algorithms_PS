import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		MinHeap heap = new MinHeap();
		for (int i = 0; i < N; i++) {
			if (input[i] == 0) { // 최소 힙에서 루트 꺼내고 삭제
				System.out.println(heap.delete());
			} else { // 최소 힙에 추가
				heap.insert(input[i]);
			}
		}
	}
}

class MinHeap {
	private List<Integer> list;

	public MinHeap() {
		list = new ArrayList<>();
		// 0번은 안 씀
		list.add(0);
	}

	public void insert(int val) {
		// 1. 트리의 가장 마지막 위치에 노드를 삽입
		list.add(val);
		// 2. 추가된 노드와 그 부모 노드가 힙 조건을 만족하는지 확인한다.
		int idx = list.size() - 1; // 추가한 노드의 인덱스
		while (idx > 1 && list.get(idx / 2) > list.get(idx)) {
			// 3. 만족하지 않는다면 부모와 자식의 키 값을 바꾼다.
			int tmp = list.get(idx / 2);
			list.set(idx / 2, val);
			list.set(idx, tmp);
			// 4. 조건에 만족하거나 추가된 노드가 루트에 도달할 때까지 2~3을 반복한다.
			idx /= 2;
		}
	}

	public int delete() {
		// 비어있는데 삭제 할 때는 0 반환
		if(list.size()-1 < 1) return 0;
		// 1. 루트 노드를 삭제한다.
		int deleted = list.get(1);
		// 2. 트리의 가장 마지막 노드를 루트 자리로 삽입
		list.set(1, list.get(list.size()-1));
		list.remove(list.size()-1);
		// 3. 바꾼 위치의 노드가 힙 조건을 만족하는지 확인한다.
		int idx =1;
		while(idx*2<list.size()) { // 리프까지 갔는지 left 자식으로 확인
			int minVal = list.get(idx*2);
			int minPos = idx*2;
			
			// 오른쪽 자식이 존재하고 더 작은 값이면 오른쪽으로 갈아치우기
			if(((idx*2+1)<list.size()) && minVal>list.get(idx*2+1)){
				minVal = list.get(idx*2+1);
				minPos = idx*2+1;
			}
			
			if(list.get(idx)<minVal) {
				break;
			}
			// 4. 만족하지 않는다면 왼쪽 자식과 오른쪽 자식 중 적합한 노드와 키 값을 바꾼다.

			int tmp = list.get(idx);
			list.set(idx, list.get(minPos));
			list.set(minPos, tmp);
			idx=minPos;
			
			// 5. 조건을 만족하거나 리프노드에 도달할 때까지 3~4를 반복
		}
		return deleted;
	}

}
