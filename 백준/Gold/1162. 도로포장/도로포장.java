import java.io.*;
import java.util.*;

class VE {
    int v;
    long e;
    int cnt;

    public VE(int v, long e, int cnt) {
        this.v = v;
        this.e = e;
        this.cnt = cnt;
    }
}

public class Main {
    private static StringBuilder sb;
    private static final long INF = 1_000_000L * 50_000L + 1L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<List<VE>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        long[][] dist = new long[K + 1][N + 1];
        for (int i = 0; i < K + 1; i++) {
            Arrays.fill(dist[i], INF);
        }
        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.e, o2.e));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new VE(b, c,0));
            graph.get(b).add(new VE(a, c, 0));
        }
        dist[0][1] = 0;
        pq.offer(new VE(1, 0, 0));
        //1. 큰 숫자를 지우는 것이 효과적이다 (그치만 그리디는 아니다 )
        //2. 1 -> N 으로 가는 경로 중 하나이어야 한다
        // -> 1 -> N 으로 가는 경로들 중 무언가를 지워야한다.
        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (dist[now.cnt][now.v] < now.e) {
                continue;
            }

            for (VE next : graph.get(now.v)) {
                if (dist[now.cnt][next.v] > next.e + now.e) {
                    dist[now.cnt][next.v] = next.e + now.e;
                    pq.add(new VE(next.v, dist[now.cnt][next.v], now.cnt));
                }
                if (now.cnt < K && dist[now.cnt + 1][next.v] > now.e) {
                    dist[now.cnt + 1][next.v] = now.e;
                    pq.add(new VE(next.v, dist[now.cnt + 1][next.v], now.cnt + 1));

                }
            }
        }
        long res = INF;
        for (int i = 0; i < K + 1; i++) {
            res = Math.min(res, dist[i][N]);
        }

        System.out.println(res);
    }
}


