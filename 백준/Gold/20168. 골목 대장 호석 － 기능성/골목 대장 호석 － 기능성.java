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
    private static final Long INF = 1_000_000_000_000_001L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long[] dist = new long[N + 1];

        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.e, o2.e));
        List<List<VE>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            long E = Long.parseLong(st.nextToken());
            graph.get(U).add(new VE(V, E));
            graph.get(V).add(new VE(U, E));

        }

        long res = -1;
        long l = -1;
        long r = INF;
        long m;
        while (l + 1 < r) {
            m = l + (r - l) / 2;

            Arrays.fill(dist, INF);
            dist[A] = 0L;
            pq.offer(new VE(A, 0L));

            while (!pq.isEmpty()) {
                VE now = pq.poll();

                if (dist[now.v] < now.e) {
                    continue;
                }

                for (VE next : graph.get(now.v)) {
                    if (dist[next.v] > now.e + next.e) {
                        if (next.e > m) {
                            continue;
                        }
                        dist[next.v] = now.e + next.e;
                        pq.offer(new VE(next.v, dist[next.v]));
                    }
                }
            }

            if (dist[B] > C) {
                l = m;
                continue;
            }
            res = m;
            r = m;
        }
        System.out.println(res);

    }
}
