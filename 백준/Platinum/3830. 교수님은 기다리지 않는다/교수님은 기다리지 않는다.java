import java.io.*;
import java.util.*;

public class Main {
    private static int[] parents;
    private static long[] dist;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            parents = new int[N + 1];
            dist = new long[N + 1];
            for (int i = 0; i <= N; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                if (command.equals("!")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                    continue;
                }
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (find(a) != find(b)) {
                    sb.append("UNKNOWN").append("\n");
                    continue;
                }
                sb.append((dist[b] - dist[a])).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void union(int x, int y, int w) {
        int xx = find(x);
        int yy = find(y);

        if (xx == yy) {
            return;
        }
        dist[yy] = dist[x] - dist[y] + w;
        parents[yy] = xx;
        return;
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        int root = find(parents[x]);
        dist[x] += dist[parents[x]];
        return parents[x] = root;
    }

}
