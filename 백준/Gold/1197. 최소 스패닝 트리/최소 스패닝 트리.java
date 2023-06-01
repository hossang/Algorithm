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
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }
        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new VE(A, B, C));
        }
        int result = 0;
        while (!pq.isEmpty()) {
            VE now = pq.poll();
            if (find(now.v1) == find(now.v2)) {
                continue;
            }
            union(now.v1, now.v2);
            result += now.e;
        }
        System.out.println(result);
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
