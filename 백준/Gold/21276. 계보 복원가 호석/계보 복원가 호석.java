import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        SortedMap<String, Integer> map1 = new TreeMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();
            map1.put(name, 0);
        }
        int idx = 0;
        for (String s : map1.keySet()) {
            map1.put(s, ++idx);
            map2.put(idx, s);
        }

        int[] arr1 = new int[N + 1];
        List<List<Integer>> graph1 = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph1.add(new ArrayList<>());
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String X = st.nextToken();
            String Y = st.nextToken();
            arr1[map1.get(X)]++;
            graph1.get(map1.get(Y)).add(map1.get(X)); //조상 -> 자손
        }
        Deque<Integer> dq = new ArrayDeque<>();
        List<List<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph2.add(new ArrayList<>());
        }
        for (int i = 1; i < N + 1; i++) {
            if (arr1[i] == 0) {
                dq.addLast(i);
                graph2.get(0).add(i);
            }
        }
        while (!dq.isEmpty()) {
            int now = dq.pollFirst();

            for (Integer next : graph1.get(now)) {
                arr1[next]--;
                if (arr1[next] == 0) {
                    dq.addLast(next);
                    graph2.get(now).add(next);
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph2.get(i));
        }
        sb.append(graph2.get(0).size()).append("\n");
        for (Integer node : graph2.get(0)) {
            sb.append(map2.get(node)).append(" ");
        }
        sb.append("\n");
        for (int i = 1; i < N + 1; i++) {
            if (arr1[i] == 0) {
                sb.append(map2.get(i)).append(" ").append(graph2.get(i).size()).append(" ");
                arr1[i]++;
                for (Integer node : graph2.get(i)) {
                    sb.append(map2.get(node)).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
