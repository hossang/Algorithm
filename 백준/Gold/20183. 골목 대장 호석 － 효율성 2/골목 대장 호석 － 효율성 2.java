import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class VE{
    int vertex;
    int edge;

    public VE(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
    }
}

class VMS {
    int vertex;
    int max;
    long sum;

    public VMS(int vertex, int m1, int m2, long x) {
        this.vertex = vertex;
        this.max = Math.max(m1, m2);
        this.sum += x;
    }
}
public class Main {
    public static final int INF = 123456789;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        List<List<VE>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph.get(N1).add(new VE(N2, E));
            graph.get(N2).add(new VE(N1, E));

        }
        //당신이 받는 수치심은 경로 상에서 가장 많이 낸 돈에 비례하기 때문에,
        // 결국 갈 수 있는 다양한 방법들 중에서 최소한의 수치심을 받으려고 한다.
        // 즉, 한 골목에서 내야 하는 최대 요금을 최소화하는 것이다.
        //이거 그냥 bfs하면 되는 거아님?
        boolean[] visited = new boolean[N + 1];
        Deque<VMS> dq = new ArrayDeque<>();
        dq.addLast(new VMS(A, 0, 0, 0));
        visited[A] = true;
        long min = Integer.MAX_VALUE;
        int result = 0;
        while (!dq.isEmpty()) {
            VMS now = dq.pollFirst();

            if (now.vertex == B) {
                if (now.sum <= C) {
                    if (min > C - now.sum) {
                        min = C - now.sum;
                        result = now.max;
                    }
                }
                continue;
            }

            for (VE next : graph.get(now.vertex)) {

                if (visited[next.vertex]) {
                    continue;
                }
                if (next.vertex != B) {
                    visited[next.vertex] = true;
                }
                dq.addFirst(new VMS(next.vertex, next.edge, now.max, now.sum + next.edge));
            }
        }
        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

}