import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
    private static final int INF = 123456789;
    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> ass = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            ass.add(new ArrayList<>());
        }
        int[] dist = new int[v + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            ass.get(a).add(new Edge(b, w));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        //기본적으로 BFS꼴이네
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (dist[edge.v] < edge.w) { //★ 이거 뭐임 ? -> '현재까지 최적의 가중치' < '이전노드에서 현재 v노드로 도착한 가중치' 이면 PASS , 나는 최적값을 원해
                continue;
            }
            for (int i = 0; i < ass.get(edge.v).size(); i++) {
                Edge nextEdge = ass.get(edge.v).get(i);
                if (dist[nextEdge.v] > edge.w + nextEdge.w) {
                    dist[nextEdge.v] = edge.w + nextEdge.w;
                    pq.offer(new Edge(nextEdge.v, dist[nextEdge.v]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}