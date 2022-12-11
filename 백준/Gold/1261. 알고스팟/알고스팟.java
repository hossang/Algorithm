import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class YXW {
    int y;
    int x;
    int w;

    public YXW(int y, int x, int w) {
        this.y = y;
        this.x = x;
        this.w = w;
    }
}

public class Main {
    private static int[][] arr,dist;
    private static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        arr = new int[y + 1][x + 1];
        dist = new int[y + 1][x + 1];
        int[] arrx = {-1, 1, 0, 0}; //좌우하상
        int[] arry = {0, 0, 1, -1};
        for (int i = 0; i <= y; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 1; i <= y; i++) {
            String str = br.readLine();
            for (int j = 1; j <= x; j++) {
                if (str.charAt(j - 1) == '1') {
                    arr[i][j] = 1;
                }
            }
        }
        PriorityQueue<YXW> pq = new PriorityQueue<>(((o1, o2) -> o1.w - o2.w));
        pq.offer(new YXW(1, 1, arr[1][1]));
        dist[1][1] = arr[1][1];

        while (!pq.isEmpty()) {
            YXW now = pq.poll();

            if (dist[now.y][now.x] < now.w) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextx = now.x + arrx[i];
                int nexty = now.y + arry[i];
                if (nextx < 1 || nexty < 1 || nextx > x || nexty > y) {
                    continue;
                }

                int nextw = dist[now.y][now.x] + arr[nexty][nextx];
                if (dist[nexty][nextx] > nextw) {
                    dist[nexty][nextx] = nextw;
                    pq.offer(new YXW(nexty, nextx, dist[nexty][nextx]));
                }
            }
        }

        System.out.println(dist[y][x]);
    }
}