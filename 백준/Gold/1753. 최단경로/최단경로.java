import java.io.*;
import java.util.*;

class VE {
    int v;
    int e;

    public VE(int v, int e) {
        this.v = v;
        this.e = e;
    }
}

public class Main {
    //백준
    private static StringBuilder sb;

    private static int INF = (int) (1e9 + 7);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<List<VE>> graph = new ArrayList<>();
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }
        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        int start = Integer.parseInt(br.readLine());
        pq.offer(new VE(start, 0));
        dist[start] = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new VE(v, w));
        }


        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (dist[now.v] < now.e) {
                continue;
            }

            for (VE next : graph.get(now.v)) {
                if (dist[next.v] > next.e + now.e) {
                    dist[next.v] = next.e + now.e;
                    pq.offer(new VE(next.v, dist[next.v]));
                }
            }
        }
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == INF) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }
}
