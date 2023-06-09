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

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
        PriorityQueue<VVE> pq1 = new PriorityQueue<>((o1, o2) -> o2.e - o1.e);
        PriorityQueue<VVE> pq2 = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq1.offer(new VVE(A, B, C));
            pq2.offer(new VVE(A, B, C));
        }
        long res1 = 0L;
        while (!pq1.isEmpty()) {
            VVE now = pq1.poll();

            if (find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                if (now.e == 0) {
                    res1++;
                }
            }
        }
        long res2 = 0;
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
        while (!pq2.isEmpty()) {
            VVE now = pq2.poll();

            if (find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                if (now.e == 0) {
                    res2++;
                }
            }
        }
        System.out.println(res2 * res2 - res1 * res1);
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
