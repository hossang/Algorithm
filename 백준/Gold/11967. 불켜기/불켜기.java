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

    private static int firstLeaf;
    private static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] graph = new int[N + 1][N + 1];
        boolean[][] visited = new boolean[N + 1][N + 1];
        boolean[][] lighted = new boolean[N + 1][N + 1];
        List<List<YX>> lights = new ArrayList<>();
        int nn1 = N * N + 1;
        for (int i = 0; i < nn1; i++) {
            lights.add(new ArrayList<>());
        }

        Arrays.fill(visited[0], true);
        for (int i = 0; i < N + 1; i++) {
            visited[i][0] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            //다음 M줄에는 네 개의 정수 x, y, a, b가 주어진다.
            // (x, y)방에서 (a, b)방의 불을 켜고 끌 수 있다는 의미이다.
            // 한 방에 여러개의 스위치가 있을 수 있고,하나의 불을 조절하는 스위치 역시 여러개 있을 수 있다.
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lights.get((x - 1) * N + y).add(new YX(a, b));
        }

        Deque<YX> dq = new ArrayDeque<>();
        dq.addLast(new YX(1, 1));
        visited[1][1] = true;
        lighted[1][1] = true;
        int res = 1;
        while (!dq.isEmpty()) {
            YX now = dq.pollFirst();

            int i1 = (now.y - 1) * N + now.x;
            for (int i = 0; i < lights.get(i1).size(); i++) {
                YX yx = lights.get(i1).get(i);
                if (!lighted[yx.y][yx.x]) {
                    lighted[yx.y][yx.x] = true;
                    res++;
                    for (int j = 0; j < 4; j++) {
                        int ny = yx.y + dy[j];
                        int nx = yx.x + dx[j];

                        if (ny < 1 || nx < 1 || ny > N || nx > N) {
                            continue;
                        }
                        if (visited[ny][nx]) {
                            dq.addLast(new YX(ny, nx));
                            break;
                        }
                    }

                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 1 || nx < 1 || ny > N || nx > N) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (!lighted[ny][nx]) {
                    continue;
                }
                dq.addLast(new YX(ny, nx));
                visited[ny][nx] = true;
            }
        }
        System.out.println(res);
    }
}
