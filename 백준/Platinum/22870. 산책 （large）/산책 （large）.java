import java.io.*;
import java.util.*;

class VE {
    int v;
    long e;

    public VE(int v, long e) {
        this.v = v;
        this.e = e;
    }
}

public class Main {
    private static StringBuilder sb;
    private static int S,E;
    private static boolean[] visited;
    private static final long INF = 1_000L * 500_000L + 1L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        //1. 다익스트라를 시작점 종료점 두번 돌린다
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<VE>> graph = new ArrayList<>();
        long[] distS = new long[N + 1];
        long[] distE = new long[N + 1];
        Arrays.fill(distS, INF);
        Arrays.fill(distE, INF);

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new VE(B, C));
            graph.get(B).add(new VE(A, C));
        }
        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distS[S] = 0L;
        distE[E] = 0L;
        long res = 0;
        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.e, o2.e));
        pq.offer(new VE(S, 0L));

        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (distS[now.v] < now.e) {
                continue;
            }

            for (VE next : graph.get(now.v)) {
                if (distS[next.v] > now.e + next.e) {
                    distS[next.v] = now.e + next.e;
                    pq.offer(new VE(next.v, distS[next.v]));
                }
            }
        }
        res = distS[E];

        pq.offer(new VE(E, 0L));
        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (distE[now.v] < now.e) {
                continue;
            }

            for (VE next : graph.get(now.v)) {
                if (distE[next.v] > now.e + next.e) {
                    distE[next.v] = now.e + next.e;
                    pq.offer(new VE(next.v, distE[next.v]));
                }
            }
        }
        //2. 사전순 최단경로를 찾기 ★
        //https://ongveloper.tistory.com/236
        int SS = S;
        boolean[] visited = new boolean[N + 1];
        while (SS != E) {
            int tmp = 200_001;
            for (VE next : graph.get(SS)) {
                // S에서 시작하여 S와 연결된 다음 노드를 N이라 할 때, dist[S]+N노드로 가는 거리(증가치) + distE[N] == distS[E] 라면 해당 노드는 최단 경로에 사용된 노드가 맞다.
                if (distS[SS] + next.e + distE[next.v] == distS[E]) {
                    //S에서 시작하여 S와 연결된 또 다른 다음 노드를 M이라 할 때, 4.1의 과정을 반복한 후, N,M을 비교하여 낮은 수가 사전 순으로 앞선 경로가 된다.
                    tmp = Math.min(tmp, next.v);
                }
            }
            //N,M중 작은 수가 N이라고 할 때, S를 N으로 갱신해 준다.
            SS = tmp;
            //위의 과정을 S가 E가 될 때까지 반복하고, 여기서 구한 노드들을 used[]배열에 true로 저장하여 S->E에서 사용된 노드들임을 저장한다.
            visited[SS] = true;
        }
        //3. 다익스트라
        pq.offer(new VE(E, 0L));
        Arrays.fill(distE, INF);

        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (distE[now.v] < now.e) {
                continue;
            }

            for (VE next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }
                if (distE[next.v] > now.e + next.e) {
                    distE[next.v] = now.e + next.e;
                    pq.offer(new VE(next.v, distE[next.v]));
                }
            }
        }
        res += distE[S];
        System.out.println(res);

    }
}


