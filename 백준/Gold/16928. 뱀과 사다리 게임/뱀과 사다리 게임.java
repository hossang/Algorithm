import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> ladder = new ArrayList<>();
        ArrayList<Integer> snake = new ArrayList<>();
        int[] visited = new int[101];
        Arrays.fill(visited, -1);
        for (int i = 0; i <= 100; i++) {
            ladder.add(i, 1);
            snake.add(i, 1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder.set(x, y);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snake.set(u, v);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        visited[1] = 0;
        while (!deque.isEmpty()) {
            int now = deque.pollFirst();

            if (now == 100) {
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100 || visited[next] != -1) {
                    continue;
                }

                visited[next] = visited[now] + 1;
                if (ladder.get(next) != 1 && visited[ladder.get(next)] == -1) {
                    visited[ladder.get(next)] = visited[now] + 1;
                    deque.addLast(ladder.get(next));
                    continue;
                }
                if (snake.get(next) != 1) {
                    if (visited[snake.get(next)] == -1) {
                        visited[snake.get(next)] = visited[now] + 1;
                        deque.addLast(snake.get(next));
                    }
                    continue;
                }
                deque.addLast(next);
            }
        }

        System.out.println(visited[100]);
    }
}