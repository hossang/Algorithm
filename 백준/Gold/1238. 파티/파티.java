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
    private static final int INF = 123_456_789;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] dist = new int[n + 1];
        int[] reversedist = new int[n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(reversedist, INF);
        List<List<VE>> list = new ArrayList<>();
        List<List<VE>> reverselist = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            reverselist.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new VE(b, w));
            reverselist.get(b).add(new VE(a, w));
        }

        PriorityQueue<VE> pq = new PriorityQueue<>(new Comparator<VE>() {
            @Override
            public int compare(VE o1, VE o2) {
                return o1.e - o2.e;
            }
        });
        //x에서 되돌아올때 걸리는 시간
        pq.offer(new VE(x, 0));
        dist[x] = 0;

        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (dist[now.v] < now.e) {
                continue;
            }

            for (VE ve : list.get(now.v)) {
                if (dist[ve.v] > now.e + ve.e) {
                    dist[ve.v] = now.e + ve.e;
                    pq.offer(new VE(ve.v, dist[ve.v]));
                }
            }
        }
        pq.offer(new VE(x, 0));
        reversedist[x] = 0;
        while (!pq.isEmpty()) {
            VE now = pq.poll();

            if (reversedist[now.v] < now.e) {
                continue;
            }

            for (VE ve : reverselist.get(now.v)) {
                if (reversedist[ve.v] > now.e + ve.e) {
                    reversedist[ve.v] = now.e + ve.e;
                    pq.offer(new VE(ve.v, reversedist[ve.v]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, reversedist[i] + dist[i]);
        }
        System.out.println(max);
    }
}