import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class VVE {
    int v1;
    int v2;
    int e;

    public VVE(int v1, int v2, int e) {
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
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        int[][] graph = new int[N][N];
        PriorityQueue<VVE> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (i != j) {
                    pq.offer(new VVE(i, j, graph[i][j]));
                }
            }
        }
        long res = 0;
        while (!pq.isEmpty()) {
            VVE now = pq.poll();
            if (find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                res += now.e;
            }
        }
        System.out.println(res);

    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parents[y] = x;
            return;
        }
        parents[x] = y;
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

}
