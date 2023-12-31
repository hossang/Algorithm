import java.io.*;
import java.util.*;

class YX {
    int y;
    int x;
    int e;

    public YX(int y, int x, int e) {
        this.y = y;
        this.x = x;
        this.e = e;
    }
}

public class Main {
    private static final int INF = 50 * 50 + 1;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        /*Q 벽 부수고 이동하기와 알고스팟의 차이가 뭘까 ?
        공통점
        1. 모두 벽을 부수고 목적지에 도착해야 한다
        차이점
        1. 벽 부수고 이동하기는 최단 거리를 알고스팟은 부순 벽의 개수를 구한다
        */

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = 0;

        PriorityQueue<YX> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        pq.offer(new YX(0, 0, 0));

        while (!pq.isEmpty()) {
            YX now = pq.poll();

            if (now.e > dist[now.y][now.x]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                if (graph[ny][nx] == 0) {
                    if (dist[ny][nx] > dist[now.y][now.x] + 1) {
                        dist[ny][nx] = dist[now.y][now.x] + 1;
                        pq.offer(new YX(ny, nx, dist[ny][nx]));
                    }
        //https://www.acmicpc.net/source/70970240 에서 vistied가 필요했던 이유가 continue의 위치가 부적절 했기 때문이다.
                    
                    continue;
                }
                if (dist[ny][nx] > dist[now.y][now.x]) {
                    dist[ny][nx] = dist[now.y][now.x];
                    pq.offer(new YX(ny, nx, dist[ny][nx]));
                }
            }
        }

        System.out.println(dist[n - 1][n - 1]);
    }
}
