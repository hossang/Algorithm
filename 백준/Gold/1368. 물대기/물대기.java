import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class VE {
    int v1;
    int v2;
    int e;

    public VE(int v1, int v2, int e) {
        this.v1 = v1;
        this.v2 = v2;
        this.e = e;
    }
}

public class Main {
    private static StringBuilder sb;
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            parents[i] = i;
        }
        int[][] graph = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            graph[0][i] = arr[i];
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        for (int i = 0; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                pq.offer(new VE(i, j, graph[i][j]));
            }
        }
        int res = 0;
        while (!pq.isEmpty()) {
            VE now = pq.poll();
            if (find(now.v1) != find(now.v2)) {
                res += now.e;
                union(now.v1, now.v2);
            }
        }
        System.out.println(res);
    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);
        if (v1 < v2) {
            parents[v2] = v1;
            return;
        }
        parents[v1] = v2;
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }


}
