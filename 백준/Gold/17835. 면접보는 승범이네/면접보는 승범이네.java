import java.io.*;
import java.math.BigInteger;
import java.util.*;

class VE{
    int v;
    long e;

    public VE(int v, long e) {
        this.v = v;
        this.e = e;
    }
}

public class Main {
    //백준
    private static StringBuilder sb;
    private static final Long INF = 1234567891231L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.e - o2.e < 0) {
                return -1;
            }
            if (o1.e - o2.e == 0) {
                return 0;
            }
            return 1;
        });
        List<List<VE>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            graph.get(V).add(new VE(U, C));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int x = Integer.parseInt(st.nextToken());
            dist[x] = 0L;
            pq.offer(new VE(x, 0L));
        }

        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (dist[now.v] < now.e) {
                continue;
            }

            for (VE next : graph.get(now.v)) {
                if (dist[next.v] > now.e + next.e) {
                    dist[next.v] = now.e + next.e;
                    pq.offer(new VE(next.v, dist[next.v]));
                }
            }
        }
        long f = 0;
        int idx = 0;
        for (int i = 0; i < N + 1; i++) {
            if (f < dist[i] && dist[i] != INF) {
                f = dist[i];
                idx = i;
            }
        }
        sb.append(idx).append("\n").append(f);
        System.out.println(sb);
    }
}
