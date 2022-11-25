import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        int[] visited = new int[100_001];
        int[] count = new int[100_001];
        Arrays.fill(visited, -1);
        visited[n] = 0;
        count[n] = 0;
        dq.addLast(n);


        while (!dq.isEmpty()) {
            int now = dq.pollFirst();
            //종료조건
            if (now == k) {
                break;
            }
            //bfs
            if (now + 1 <= 100_000 && visited[now + 1] == -1) {
                visited[now + 1] = visited[now] + 1;
                dq.addLast(now + 1);
                count[now + 1] = now;
            }

            if (now - 1 >= 0 && visited[now - 1] == -1) {
                visited[now - 1] = visited[now] + 1;
                dq.addLast(now - 1);
                count[now - 1] = now;
            }

            if (now * 2 <= 100_000 && visited[now * 2] == -1) {
                visited[now * 2] = visited[now] + 1;
                dq.addLast(now * 2);
                count[now * 2] = now;
            }
        }
        System.out.println(visited[k]);
        List<Integer> list = new ArrayList<>();
        list.add(0, k);
        int idx = count[k];
        while (idx != 0) {
            list.add(0, idx);
            idx = count[idx];
        }
        if (n == 0 && k != 0) {
            list.add(0, 0);
        }
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        System.out.print(sb);
    }
}
