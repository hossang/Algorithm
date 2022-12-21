import java.util.*;
import java.io.*;

public class Main {
    public static final int INF = 123456789;
    public static class Edge implements Comparable<Edge> {
        int v;
        int w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Edge>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            al.get(v1).add(new Edge(v2, w));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        /*boolean[] visited = new boolean[n + 1];*/
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (dist[now.v] < now.w) {
                continue;
            }
            for (Edge next : al.get(now.v)) {
                if (/*!visited[next.v] && */dist[next.v] > dist[now.v] + next.w) {
                    dist[next.v] = Math.min(dist[next.v], dist[now.v] + next.w);
                    /*visited[next.v] = true;*/
                    pq.offer(next);
                }
            }
        }
        System.out.println(dist[end]);
    }
}