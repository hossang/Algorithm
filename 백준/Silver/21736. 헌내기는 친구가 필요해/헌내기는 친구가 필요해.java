import java.io.*;
import java.util.*;

class YX {
    int y;
    int x;

    public YX(int y, int x) {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        char[][] graph = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        Deque<YX> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j);
                if (graph[i][j] == 'I') {
                    dq.addLast(new YX(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        while (!dq.isEmpty()) {
            YX now = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (graph[ny][nx] == 'X') {
                    continue;
                }
                if (graph[ny][nx] == 'P') {
                    res++;
                }
                dq.addLast(new YX(ny, nx));
                visited[ny][nx] = true;
            }
        }

        if (res == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(res);
    }
}
