import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] arr = new int[y][x];
        int[] arrx = {-1, 1, 0, 0}; //좌우상하
        int[] arry = {0, 0, -1, 1};
        boolean[][] visited = new boolean[y][x];
        Deque<XY> dq = new ArrayDeque<>();
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                if (str.charAt(j) == '1') {
                    arr[i][j] = 1;
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 0; i < x; i++) {
            if (arr[0][i] == 0) {
                dq.addLast(new XY(i, 0));
                visited[0][i] = true;
            }
        }

        
        while (!dq.isEmpty()) {
            XY now = dq.pollFirst();

            if (now.y == y - 1) {
                System.out.println("YES");
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextx = now.x + arrx[i];
                int nexty = now.y + arry[i];

                if (nextx < 0 || nexty < 0 || nextx >= x || nexty >= y) {
                    continue;
                }
                if (visited[nexty][nextx] || arr[nexty][nextx] == 1) {
                    continue;
                }
                dq.addLast(new XY(nextx, nexty));
                visited[nexty][nextx] = true;
            }

        }
        System.out.println("NO");
    }

}