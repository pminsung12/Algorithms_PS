import java.util.*;
import java.io.*;

public class Main {

	// pq를 쓴 이유
	// 무게, 가격을 가지고 최댓값이 필요할 때 pq를 씀.
	// 시점이라는 개념이 추가됨. 가방을 뽑은 시점에 가능한 애들 중에 가장 큰 걸 선택해서 넣기 위해.
	static int N, K;
	static Long res=0L;
	static PriorityQueue<Jewel> pq;
	static PriorityQueue<Jewel> jewels;
	static PriorityQueue<Integer> bags;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		jewels = new PriorityQueue<>((o1, o2)->o1.getWeight()-o2.getWeight());
		bags = new PriorityQueue<Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewels.offer(new Jewel(value, weight));
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			bags.offer(weight);
		}

		pq = new PriorityQueue<>(Comparator.comparing(Jewel::getValue).reversed());

		// 가방을 순회
		while (!bags.isEmpty()) {
			int bagWeight = bags.poll();
			
			// 가방에 넣을 수 있는 보석을 pq에 삽입
			while(!jewels.isEmpty() && jewels.peek().getWeight()<=bagWeight) {
				pq.offer(jewels.poll());
			}
			
			// 이 때 pq의 top의 의미는 가방에 넣을 수 있는 가장 비싼 보석
			if(!pq.isEmpty()) {
				res+=pq.poll().getValue();
			}
		}
		
		System.out.println(res);

	}

}

class Jewel {
	private int value;
	private int weight;

	public Jewel(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Jewel [value=" + value + ", weight=" + weight + "]";
	}

}