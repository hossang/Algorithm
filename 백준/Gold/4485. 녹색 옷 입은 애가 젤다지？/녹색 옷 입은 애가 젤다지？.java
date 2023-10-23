import java.io.*;
import java.util.*;

class YX {
    int y;
    int x;
    int s;

    YX(int y, int x, int s) {
        this.y = y;
        this.x = x;
        this.s = s;
    }
}

public class Main {
    //백준
    private static StringBuilder sb;

    private static final int INF = 200_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int idx = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int[][] graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], INF);
            }
            PriorityQueue<YX> pq = new PriorityQueue<>((o1, o2) -> o1.s - o2.s);
            pq.offer(new YX(0, 0, graph[0][0]));
            dist[0][0] = graph[0][0];

            while (!pq.isEmpty()) {
                YX now = pq.poll();

                if (dist[now.y][now.x] < now.s) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                        continue;
                    }
                    if (dist[ny][nx] > dist[now.y][now.x] + graph[ny][nx]) {
                        dist[ny][nx] = dist[now.y][now.x] + graph[ny][nx];
                        pq.offer(new YX(ny, nx, dist[ny][nx]));
                    }
                }
            }
            sb.append("Problem ").append(idx++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
