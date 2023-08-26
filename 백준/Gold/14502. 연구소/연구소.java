import java.io.*;
import java.time.Year;
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

    private static int max, Y, X;
    private static int[] dy, dx;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[Y][X];
        dy = new int[]{1, -1, 0, 0};
        dx = new int[]{0, 0, -1, 1};
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < X; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0);
        System.out.println(max);
    }

    private static void backTracking(int cnt) {
        if (cnt == 3) {
            //bfs
            int[][] graph = new int[Y][X];
            Deque<YX> dq = new ArrayDeque<>();
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    graph[i][j] = arr[i][j];
                    if (graph[i][j] == 2) {
                        dq.addLast(new YX(i, j));
                    }
                }
            }
            while (!dq.isEmpty()) {
                YX now = dq.pollFirst();

                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
                        continue;
                    }
                    if (graph[ny][nx] != 0) {
                        continue;
                    }
                    dq.addLast(new YX(ny, nx));
                    graph[ny][nx] = 2;
                }
            }
            //갯수세기
            int res = 0;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (graph[i][j] == 0) {
                        res++;
                    }
                }
            }
            max = Math.max(max, res);
            return;
        }

        //백트랙킹
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    backTracking(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }
}
