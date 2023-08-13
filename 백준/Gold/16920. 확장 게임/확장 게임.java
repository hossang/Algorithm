import java.io.*;
import java.util.*;

class YX {
    int y;
    int x;

    public YX(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        //성의 가장자리에서 상하좌우 확장시켜 !
        //가장자리 how get ? 상하좌우중 . 하나라도 있으면 가장자리
        int[] arr = new int[P+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= P; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        char[][] graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        List<Deque<YX>> edges = new ArrayList<>();
        for (int i = 0; i < P + 1; i++) {
            edges.add(new ArrayDeque<>());
        }
        //시작 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != '#' && graph[i][j] != '.') {
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                            continue;
                        }
                        if (graph[ny][nx] == '.') {
                            int i1 = graph[i][j] - '0';
                            edges.get(i1).addLast(new YX(i, j));
                            break;
                        }
                    }
                }
            }
        }
        //게임진행
        while (true) {
            for (int i = 1; i < P + 1; i++) { //플레이어
                int cnt = 0;

                while (!edges.get(i).isEmpty()) {
                    int ds = edges.get(i).size();
                    for (int j = 0; j < ds; j++) {
                        YX now = edges.get(i).pollFirst();

                        for (int k = 0; k < 4; k++) {
                            int ny = now.y + dy[k];
                            int nx = now.x + dx[k];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                                continue;
                            }

                            if (graph[ny][nx] == '.') {
                                graph[ny][nx] = graph[now.y][now.x];
                                edges.get(i).add(new YX(ny, nx));
                            }

                        }

                    }
                    cnt++;
                    if (cnt == arr[i]) {
                        break;
                    }

                }
            }
            //확장 검증
            int cnt = 0;
            for (int i = 1; i < P + 1; i++) {
                if (edges.get(i).isEmpty()) {
                    cnt++;
                }
            }
            if (cnt == P) {
                break;
            }
        }

        //답 구하기
        int[] res = new int[P + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != '#' && graph[i][j] != '.') {
                    res[graph[i][j] - '0']++;
                }
            }
        }
        for (int i = 1; i < P + 1; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);

    }
}
