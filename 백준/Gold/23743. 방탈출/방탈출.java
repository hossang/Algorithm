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

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new VE(a, b, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            pq.offer(new VE(0, i, Integer.parseInt(st.nextToken())));
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
