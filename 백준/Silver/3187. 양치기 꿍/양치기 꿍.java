import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class YX {
    int y;
    int x;
    int wolf;
    int sheep;

    public YX(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[R][C];
        int wolf = 0;
        int sheep = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] != '#' && !visited[i][j]) {
                    Deque<YX> dq = new ArrayDeque<>();
                    dq.addLast(new YX(i, j));
                    visited[i][j] = true;
                    int w = 0;
                    int s = 0;
                    if (graph[i][j] == 'v') {
                        w++;
                    } else if (graph[i][j] == 'k') {
                        s++;
                    }

                    while (!dq.isEmpty()) {
                        YX now = dq.pollFirst();

                        for (int k = 0; k < 4; k++) {
                            int nexty = now.y + dy[k];
                            int nextx = now.x + dx[k];

                            if (nextx < 0 || nexty < 0 || nexty >= R || nextx >= C) {
                                continue;
                            }
                            if (visited[nexty][nextx]) {
                                continue;
                            }
                            if (graph[nexty][nextx] == '#') {
                                continue;
                            }

                            visited[nexty][nextx] = true;
                            dq.add(new YX(nexty, nextx));
                            if (graph[nexty][nextx] == 'v') {
                                w++;
                            } else if (graph[nexty][nextx] == 'k') {
                                s++;
                            }
                        }
                    }
                    if (w < s) {
                        sheep += s;
                    } else {
                        wolf += w;
                    }
                }
            }
        }
        sb.append(sheep).append(" ").append(wolf);
        System.out.println(sb);
    }
}
