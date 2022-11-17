import java.io.*;
import java.util.*;

public class Main {
    private static class XY{
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
        StringBuilder sb = new StringBuilder();
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[y][x];
        boolean[][] visited = new boolean[y][x];
        int[] arrx = {-1, 1, 0, 0}; //좌우상하
        int[] arry = {0, 0, -1, 1};
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = y - Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = y - Integer.parseInt(st.nextToken());

            for (int j = y2; j < y1; j++) {
                for (int l = x1; l < x2; l++) {
                    arr[j][l] = -1;
                    visited[j][l] = true;
                }
            }

        }
        List<Integer> set = new ArrayList<>();
        Deque<XY> dq = new ArrayDeque<>();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j] != -1 && !visited[i][j]) {
                    visited[i][j] = true;
                    arr[i][j] = 1;
                    dq.addLast(new XY(j, i));
                    int idx = 1;
                    while (!dq.isEmpty()) {
                        XY now = dq.pollFirst();
                        int nowx = now.x;
                        int nowy = now.y;

                        for (int l = 0; l < 4; l++) {
                            int nextx = nowx + arrx[l];
                            int nexty = nowy + arry[l];
                            if (nextx < 0 || nexty < 0 || nextx >= x || nexty >= y) {
                                continue;
                            }
                            if (arr[nexty][nextx] != -1 && !visited[nexty][nextx]) {
                                visited[nexty][nextx] = true;
                                arr[nexty][nextx] = ++idx;
                                dq.addLast(new XY(nextx, nexty));
                            }
                        }
                    }
                    set.add(idx);
                }
            }
        }
        Collections.sort(set);
        
        sb.append(set.size()).append("\n");
        for (Integer integer : set) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }
}