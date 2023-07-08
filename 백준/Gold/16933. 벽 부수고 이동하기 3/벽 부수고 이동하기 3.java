import java.io.*;
import java.util.*;

class YXK {
    int y;
    int x;
    int k;

    YXK(int y, int x, int k) {
        this.y=y;
        this.x=x;
        this.k =k;
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
        int H = Integer.parseInt(st.nextToken()); //세로
        int W = Integer.parseInt(st.nextToken()); //가로
        int K = Integer.parseInt(st.nextToken());
        int[][] graph = new int[H][W];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        boolean[][][] visited = new boolean[K+1][H][W]; //k개 만큼 필요하려나?

        Deque<YXK> dq = new ArrayDeque<>();
        visited[K][0][0] = true;
        dq.addLast(new YXK(0, 0, K));
        int res = 0;
        boolean an = true; // true : 낮
        boolean flag = false;
        a:while (!dq.isEmpty()) {

            int ds = dq.size();
            for (int h = 0; h < ds; h++) {
                YXK now = dq.pollFirst();

                if (now.y == H - 1 && now.x == W - 1) {
                    flag = true;
                    break a;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
                        continue;
                    }
                    if (graph[ny][nx] == 1) {
                        continue;
                    }
                    if (visited[now.k][ny][nx]) {
                        continue;
                    }

                    visited[now.k][ny][nx] = true;
                    dq.addLast(new YXK(ny, nx, now.k));
                }
                if (an) {
                    for (int i = 0; i < 4; i++) {
                        int nx = now.x + dx[i];
                        int ny = now.y + dy[i];

                        if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
                            continue;
                        }
                        if (now.k == 0) {
                            continue;
                        }
                        if (graph[ny][nx] == 1) {
                            int k = now.k - 1;
                            if (visited[k][ny][nx]) {
                                continue;
                            }
                            visited[k][ny][nx] = true;
                            dq.addLast(new YXK(ny, nx, k));
                        }

                    }
                } else {
                    dq.addLast(new YXK(now.y, now.x, now.k));
                }


            }
            res++;
            an = !an;
        }

        if (flag) {
            System.out.println(res + 1);
            return;
        }

        System.out.println(-1);

    }
}
