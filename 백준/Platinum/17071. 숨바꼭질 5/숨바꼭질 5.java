import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
            return;
        }
        //일단 다녀왔던곳 다시 갈 수 있어야 함
        boolean[][] visited = new boolean[2][500_001];

        int[] dx = {-1, 1, 2};

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(N);
        visited[0][N] = true;
        boolean flag = false;
        int res = 0;
        a:
        while (!dq.isEmpty()) {

            if (K > 500_000) {
                break a;
            }
            int eo = res % 2;
            if (visited[eo][K]) {
                flag = true;
                break a;
            }

            int ds = dq.size();
            for (int i = 0; i < ds; i++) {
                Integer now = dq.pollFirst();

                for (int j = 0; j < 3; j++) {
                    int nx;
                    if (j == 2) {
                        nx = now * dx[j];
                    } else {
                        nx = now + dx[j];
                    }

                    if (nx < 0 || nx > 500_000) {
                        continue;
                    }
                    if (visited[(res + 1) % 2][nx]) {
                        continue;
                    }
                    visited[(res + 1) % 2][nx] = true;
                    dq.addLast(nx);
                }
            }
            res++;
            K += res;
        }

        if (flag) {
            System.out.println(res);
            return;
        }
        System.out.println(-1);
    }
}
