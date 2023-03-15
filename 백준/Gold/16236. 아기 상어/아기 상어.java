import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class YXD {
    int y;
    int x;
    int distance;

    public YXD(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }
}
public class Main {
    public static final int INF = 123_456_789;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        YXD shark = null;
        int[] directx = {-1, 1, 0, 0};
        int[] directy = {0, 0, -1, 1};
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new YXD(i, j, 0);
                    arr[i][j] = INF;
                }
            }
        }
        int sharksize = 2;
        int cnt = 0;
        int time = 0;
        while (true) {
            boolean[][] visited = new boolean[N][N];

            Deque<YXD> dq = new ArrayDeque<>();
            PriorityQueue<YXD> fishes = new PriorityQueue<>((o1,o2)-> {
                if (o1.distance == o2.distance) {
                    if (o1.y == o2.y) {
                        return o1.x - o2.x;
                    }
                    return o1.y - o2.y;
                }
                return o1.distance - o2.distance;
            });
            dq.addLast(new YXD(shark.y, shark.x, 0));
            visited[shark.y][shark.x] = true;

            while (!dq.isEmpty()) {
                YXD now = dq.pollFirst();

                if (arr[now.y][now.x] > 0 && arr[now.y][now.x] < sharksize) {
                    fishes.offer(now);
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nexty = now.y + directy[i];
                    int nextx = now.x + directx[i];

                    if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= N) {
                        continue;
                    }
                    if (visited[nexty][nextx]) {
                        continue;
                    }
                    if (sharksize < arr[nexty][nextx]) {
                        continue;
                    }
                    visited[nexty][nextx] = true;
                    dq.addLast(new YXD(nexty, nextx, now.distance + 1));
                }
            }
            if (fishes.isEmpty()) { //먹을 게 없으면
                break;
            } else {
                arr[shark.y][shark.x] = 0;
                YXD tmp = fishes.poll();
                shark = new YXD(tmp.y, tmp.x, 0);
                time += tmp.distance;
                arr[shark.y][shark.x] = INF;
                cnt++;
                if (cnt == sharksize) {
                    cnt = 0;
                    sharksize++;
                }
            }
        }
        System.out.println(time);
    }
}