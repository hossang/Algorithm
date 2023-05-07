import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class YX {
    int y;
    int x;
    int cnt;
    String s;

    public YX(int y, int x, int cnt, String s) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.s = s;
    }
}

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        String[][] digits = new String[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                digits[i][j] = st.nextToken();
            }
        }
        int[] dx = {-1, 1, 0, 0}; //좌우상하
        int[] dy = {0, 0, -1, 1};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Deque<YX> dq = new ArrayDeque();
                dq.addLast(new YX(i,j,1,digits[i][j]));

                while (!dq.isEmpty()) {
                    YX now = dq.pollFirst();

                    if (now.cnt == 6) {
                        set.add(now.s);
                        continue;
                    }
                    for (int k = 0; k < 4; k++) {
                        int nexty = now.y + dy[k];
                        int nextx = now.x + dx[k];

                        if (nextx < 0 || nexty < 0 || nextx >= 5 || nexty >= 5) {
                            continue;
                        }
                        String nexts = now.s + digits[nexty][nextx];

                        dq.addLast(new YX(nexty, nextx, now.cnt + 1, nexts));
                    }
                }
            }
        }
        System.out.println(set.size());
    }
}
