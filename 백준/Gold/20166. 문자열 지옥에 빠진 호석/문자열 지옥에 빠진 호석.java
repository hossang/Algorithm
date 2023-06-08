import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class YX {
    int y;
    int x;
    String s;

    public YX(int y, int x) {
        this.y = y;
        this.x = x;
        s = "";
    }
}

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        String[] strings = new String[K];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            strings[i] = br.readLine();
            map.put(strings[i], 0);
        }

        int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
        Deque<YX> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dq.addLast(new YX(i, j));
                }
                while (!dq.isEmpty()) {
                    YX now = dq.pollFirst();
                    now.s += graph[now.y][now.x];

                    if (map.containsKey(now.s)) {
                        map.put(now.s, map.getOrDefault(now.s, 0) + 1);
                    }
                    if (now.s.length() == 5) {
                        continue;
                    }

                    for (int j = 0; j < 8; j++) {
                        int ny = (now.y + dy[j] + N) % N;
                        int nx = (now.x + dx[j] + M) % M;
                        YX next = new YX(ny, nx);
                        next.s = now.s;
                        dq.addLast(next);
                    }
                }
            }

        for (int i = 0; i < strings.length; i++) {
            sb.append(map.get(strings[i])).append("\n");
        }
        System.out.println(sb);
    }
}
