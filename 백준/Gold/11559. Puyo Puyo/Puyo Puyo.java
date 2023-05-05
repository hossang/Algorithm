import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class YX{
    int y;
    int x;

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

        //R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.
        char[][] puyo = new char[12][6];
        int[] dx = {-1, 1, 0, 0}; //좌우상하
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                puyo[i][j] = s.charAt(j);
            }
        }
        int result = -1;
        boolean flag = true;
        while (flag) {
            flag = false;
            //뿌요 폭파시키기
            int[][] visited = new int[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (puyo[i][j] != '.' && visited[i][j] == 0) {
                        Deque<YX> dq = new ArrayDeque<>();
                        Deque<YX> stack = new ArrayDeque<>();
                        visited[i][j] = 1;
                        int cnt = 1;
                        stack.addLast(new YX(i, j));
                        dq.addLast(new YX(i, j));
                        while (!dq.isEmpty()) {
                            YX now = dq.pollFirst();

                            for (int k = 0; k < 4; k++) {
                                int nextx = now.x + dx[k];
                                int nexty = now.y + dy[k];

                                if (nextx < 0 || nexty < 0 || nextx >= 6 || nexty >= 12) {
                                    continue;
                                }
                                if (visited[nexty][nextx] != 0) {
                                    continue;
                                }
                                if (puyo[now.y][now.x] != puyo[nexty][nextx]) {
                                    continue;
                                }

                                visited[nexty][nextx] = cnt++;
                                dq.addLast(new YX(nexty, nextx));
                                stack.addLast(new YX(nexty, nextx));
                            }
                        }
                        if (stack.size() >= 4) {
                            while (!stack.isEmpty()) {
                                YX now = stack.pollLast();
                                puyo[now.y][now.x] = '.';
                            }
                            flag = true;
                        }

                    }
                }
            }
            //뿌요 땡겨오기(세로별로 뿌요를 담아서 한번에 쫙 땡겨오기)
            for (int i = 0; i < 6; i++) {
                Deque<Character> queque = new ArrayDeque<>();
                for (int j = 11; j >= 0; j--) {
                    if (puyo[j][i] != '.') {
                        queque.addLast(puyo[j][i]);
                        puyo[j][i] = '.';
                    }
                }
                for (int j = 11; j >= 0 && !queque.isEmpty(); j--) {
                    puyo[j][i] = queque.pollFirst();
                }
            }
            result++;
        }
        System.out.println(result);
    }
}
