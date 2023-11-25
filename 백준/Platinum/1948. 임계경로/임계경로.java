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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<VE>> graph = new ArrayList<>();
        //늦게 온 사람 이전 점들 그래프로 만들기
        List<List<Integer>> lasts = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            lasts.add(new ArrayList<>());
        }
        int[] topol = new int[n + 1];

        //각 점으로 온 것들중 최대값 기억
        long[] maxPaths = new long[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new VE(b, c));
            topol[b]++;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<VE> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.e, o2.e));
        pq.offer(new VE(S, 0));

        long[] res = new long[2];
        //1. 위상정렬
        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (now.v == E) {
                res[0] = now.e;
            }

            for (VE next : graph.get(now.v)) {
                long e = now.e + next.e;
                topol[next.v]--;
                if (maxPaths[next.v] == e) {
                    lasts.get(next.v).add(now.v);
                }
                if (maxPaths[next.v] < e) {
                    lasts.get(next.v).clear();
                    lasts.get(next.v).add(now.v);
                    maxPaths[next.v] = e;
                }

                if (topol[next.v] == 0) {
                    pq.offer(new VE(next.v, maxPaths[next.v]));
                }
            }
        }
        //2. 역추적 (topol2 채우기)
        int[] topol2 = new int[n + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(E);

        while (!dq.isEmpty()) {
            int now = dq.pollFirst();

            for (Integer next : lasts.get(now)) {
                res[1]++;
                if (topol2[next] == 0) {
                    dq.addLast(next);
                }
                topol2[next]++;
            }
        }
        sb.append(res[0]).append("\n").append(res[1]).append("\n");
        System.out.println(sb);
    }
}


