import java.io.*;
import java.util.*;
class YX {
    int y;
    int x;
    YX(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    //백준
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); //세로
        int m = Integer.parseInt(st.nextToken()); //가로
        int[][] graph = new int[n][m];
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Deque<YX> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    dq.addLast(new YX(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while (!dq.isEmpty()) {
            YX now = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (graph[ny][nx] == 0) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                dq.addLast(new YX(ny, nx));
                visited[ny][nx] = true;
                result[ny][nx] = result[now.y][now.x] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && result[i][j] == 0) {
                    sb.append(-1);
                } else {
                    sb.append(result[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
