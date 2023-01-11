import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//2178
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //n * m 행렬
        int n = Integer.parseInt(st.nextToken()); //N, M(2 ≤ N, M ≤ 100)
        int m = Integer.parseInt(st.nextToken()); //N, M(2 ≤ N, M ≤ 100)
        int count = 0;
        int[][] nm = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                nm[i][j] = str.charAt(j) - '0';
            }
        }
        Deque<Integer> di = new ArrayDeque<>();
        /*(0, 0)에서 (N - 1, M - 1)의 위치로 이동시키기
        * 동서남북 탐색 (BFS)
        * BFS
        * 1. 큐에 넣고, 팝해
        * 2. 팝한 것에 동서남북으로 연결된 거 찾기
        * ★좌표를 어떻게 얻지?? 그리고 좌표를 큐에 넣고 싶은데 아니면 2(i,j)개씩 넣을까?
        * */
        di.add(0);
        di.add(0);
        visited[0][0] = true;

        a : while (!di.isEmpty()&&!visited[n-1][m-1]) {
            int disize = di.size() / 2;
            count++;
            for (int i = 0; i < disize; i++) {
                int y = di.pop();
                int x = di.pop();

                if (x - 1 >= 0 && nm[y][x - 1] == 1 && !visited[y][x - 1]) {
                    visited[y][x - 1] = true;
                    di.add(y);
                    di.add(x - 1);

                }
                if (y - 1 >= 0 && nm[y - 1][x] == 1 && !visited[y - 1][x]) {
                    visited[y - 1][x] = true;
                    di.add(y - 1);
                    di.add(x);

                }
                if (y + 1 <= n - 1 && nm[y + 1][x] == 1 && !visited[y + 1][x]) {
                    visited[y + 1][x] = true;
                    di.add(y + 1);
                    di.add(x);

                }
                if (x + 1 <= m - 1 && nm[y][x + 1] == 1 && !visited[y][x + 1]) {
                    visited[y][x + 1] = true;
                    di.add(y);
                    di.add(x + 1);

                }
            }
        }
        System.out.println(++count);

    }
}
