import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 123456789;
    static int n, m, find;
    static int[][] dist;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        find = Integer.parseInt(st.nextToken()); //탐색 범위
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        dist = new int[n + 1][n + 1];
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            dist[a][b] = l;
            dist[b][a] = l;

        }
        floyd();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= find) {
                    sum += arr[j];
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) { //★ 경유지 가 for 루프 중 가장 밖에 있어야 함
            for (int i = 1; i <= n; i++) { //출발지
                for (int j = 1; j <= n; j++) { //도착지
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); //Math.min(기존것, k를 들렸다가 j로 가는 경우(i -> k -> j))


                }
            }
        }
    }
}