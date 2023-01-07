import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); //정점의 갯수
        int m = Integer.parseInt(st.nextToken()); //간선의 갯수
        int t = 1;
        while (!(n == 0 && m == 0)) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
            Deque<Integer> deque = new ArrayDeque<>();
            Set<Integer> cycle = new HashSet<>();
            Set<Integer> root = new HashSet<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                if (find(v1) != find(v2)) {
                    union(v1, v2);
                } else { //사이클
                    deque.addLast(parent[v1]);
                }
            }
            for (int i = 1; i <= n; i++) {
                parent[i] = find(i);
            }
            while (!deque.isEmpty()) {
                int now = deque.pollFirst();
                cycle.add(find(now));
            }
            for (int i = 1; i <= n; i++) {
                root.add(parent[i]);
            }
            int rc = root.size() - cycle.size();
            if (rc == 0) {
                sb.append("Case ").append(t).append(": No trees.").append("\n");
            } else if (rc == 1) {
                sb.append("Case ").append(t).append(": There is one tree.").append("\n");
            } else {
                sb.append("Case ").append(t).append(": A forest of ")
                        .append(rc).append(" trees.").append("\n");
            }
            t++;
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);
        if (v2 > v1) {
            parent[v2] = v1;
        } else {
            parent[v1] = v2;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

}