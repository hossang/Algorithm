import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class VE {
    int v;
    int e;

    public VE(int v, int e) {
        this.v = v;
        this.e = e;
    }
}

public class Main {
    private static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dist = new int[n + 1];
        int[] pre = new int[n + 1];
        Arrays.fill(dist, INF);
        List<List<VE>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new VE(b, w));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<VE> pq = new PriorityQueue<>(new Comparator<VE>() {
            @Override
            public int compare(VE o1, VE o2) {
                return o1.e - o2.e;
            }
        });

        pq.offer(new VE(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (dist[now.v] < now.e) {
                continue;
            }

            for (VE ve : list.get(now.v)) {
                if (dist[ve.v] > now.e + ve.e) {
                    dist[ve.v] = now.e + ve.e;
                    pre[ve.v] = now.v;
                    pq.offer(new VE(ve.v, dist[ve.v]));
                }
            }
        }
        sb.append(dist[end]).append("\n");
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(end);
        int count = 1;
        while (pre[end] != 0) {
            count += 1;
            dq.addLast(pre[end]);
            end = pre[end];
        }
        sb.append(count).append("\n");
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}