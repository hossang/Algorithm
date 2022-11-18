import java.io.*;
import java.util.*;

public class Main {
    private static class XY { //다음부터 XY 클래스만들때, YX 순으로 하자
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] arrx = {-1, 1, 0, 0}; //좌우상하
        int[] arry = {0, 0, -1, 1};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        int countMax =0;
        Deque<XY> dq = new ArrayDeque<>();
        for (int i = min - 1; i < max; i++) {
            boolean[][] visited = new boolean[n][n];
            for (int j = 0; j < n; j++) { //잠기는 부분 추가
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] <= i) {
                        visited[j][k] = true;
                    }
                }
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k]) { //물에 안잠겼으면
                        dq.addLast(new XY(k, j)); //큐에 추가
                        visited[j][k] = true;
                        count++;
                        while (!dq.isEmpty()) {
                            XY now = dq.pollFirst();

                            for (int l = 0; l < 4; l++) {
                                int nextx = now.x + arrx[l];
                                int nexty = now.y + arry[l];

                                if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= n) {
                                    continue;
                                }
                                if (!visited[nexty][nextx]) {
                                    visited[nexty][nextx] = true;
                                    dq.addLast(new XY(nextx, nexty));
                                }
                            }
                        }
                    }
                }
            }
            if (countMax < count) {
                countMax = count;
            }
        }
        System.out.println(countMax);

    }
}