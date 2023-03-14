import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class YX{
    int y;
    int x;

    public YX(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    private static int Y,X;
    private static Deque<YX> dq, dc;
    private static int[] directx, directy;
    private static boolean[][] visited;
    private static int[][] cheese;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //초기화, cnt : 치즈의 남은 갯수 확인하기 위한 변수
        st = new StringTokenizer(br.readLine(), " ");
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        cheese = new int[Y][X];
        int cnt = 0;
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < X; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) {
                    cnt++;
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(cnt);
        directx = new int[]{-1, 1, 0, 0}; //좌우상하
        directy = new int[]{0, 0, -1, 1};
        //아니 근데 치즈안에는 또 체크하면 안되잖아아
        //BFS
        while (cnt != 0) {
            visited = new boolean[Y][X];
            dc = new ArrayDeque<>();

            int i = 0;
            int j = 0;
            if (cheese[i][j] == 0 && !visited[i][j]) {
                cnt = BFS(cnt, i, j);
            }

            pq.offer(cnt);
            while (!dc.isEmpty()) {
                YX now = dc.pollFirst();
                cheese[now.y][now.x] = 0;
            }
        }
        pq.poll();

        sb.append(pq.size()).append("\n");
        sb.append(pq.poll());
        System.out.println(sb);

    }

    private static int BFS(int cnt, int i, int j) {
        dq = new ArrayDeque<>();
        visited[i][j] = true;
        dq.addLast(new YX(i, j));
        while (!dq.isEmpty()) {
            YX now = dq.pollFirst();

            for (int k = 0; k < 4; k++) {
                int nexty = now.y + directy[k];
                int nextx = now.x + directx[k];

                if (nexty < 0 || nextx < 0 || nexty > Y-1 || nextx > X-1) {
                    continue;
                }
                if (visited[nexty][nextx]) {
                    continue;
                }
                visited[nexty][nextx] = true;
                if (cheese[nexty][nextx] == 1) {
                    cnt--;
                    dc.addLast(new YX(nexty, nextx));
                } else {
                    dq.addLast(new YX(nexty, nextx));
                }
            }
        }
        return cnt;
    }
}