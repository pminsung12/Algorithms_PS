// package DAY01.P3055;

import java.io.BufferedReader;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int R, C, N, M;
	static char[][] map;
	static int[][] visited;
	static final int[] dx = { -1, 1, 0, 0 };
	static final int[] dy = { 0, 0, -1, 1 };

	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/DAY01/P3055/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
//				System.out.println(map[i][j]+" ");
				visited[i][j] = 0;
			}
		}

		q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 물부터 enqueue
				if (map[i][j] == '*') {
					q.add(new Point(i, j, '*'));
				}

				if (map[i][j] == 'S') {
					N = i;
					M = j;
				}

			}
		}
		// 비버 enqueue
		q.add(new Point(N, M, 'S'));

		int res = bfs();
		if (res == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(res);

	}

	static int bfs() {

		while (!q.isEmpty()) {
			// 1. 큐에서 꺼내옴
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int type = p.type;
			// 2. 목적지 -> 비버가 D에 도착했을 때
			if (type == 'S' && map[x][y] == 'D') {
				return visited[x][y];
			}
			// 3. 연결된 곳은 상하좌우 4곳
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 4. 갈 수 있는 곳은 .이면 갈 수 있고, 맵을 벗어나지 않아야함.
				if (!isInTheMap(nx, ny)) {
					continue;
				}
				if (type == '*') { // 물이면 주변 번지기
					if (map[nx][ny] == '.') {
						// 5. 체크인 방문예정인곳
						map[nx][ny] = '*';
						// 6. 큐에 넣음
						q.offer(new Point(nx, ny, '*'));
//						visited[nx][ny] = visited[x][y] + 1;
					}
				} else if (type == 'S') { // 고슴도치면
					if (!isInTheMap(nx, ny)) {
						continue;
					}
					if (visited[nx][ny] == 0 && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
						// 5. 체크인 방문예정인곳
						q.offer(new Point(nx, ny, 'S'));
						// 6. 큐에 넣음
						visited[nx][ny] = visited[x][y] + 1;
					}
				}

			}
		}

		return -1;
	}

	static boolean isInTheMap(int nx, int ny) {
		if (nx < R && nx >= 0 && ny < C && ny >= 0)
			return true;
		return false;
	}

}

class Point {
	int x;
	int y;
	char type;

	public Point(int x, int y, char type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", type=" + type + "]";
	}

}