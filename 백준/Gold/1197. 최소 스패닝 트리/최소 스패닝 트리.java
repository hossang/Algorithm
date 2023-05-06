import java.util.*;
import java.io.*;

public class Main {
    public static int[] parent;

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
    public static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }

    }
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, c));
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                sum += now.w;
            }
        }
        System.out.println(sum);
    }
}