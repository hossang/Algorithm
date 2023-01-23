import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class YX {
    int y;
    int x;

    public YX(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arrx = {-1, 1, 0, 0}; //좌우상하
        int[] arry = {0 , 0, -1, 1};
        int[][] arr = new int[Y][X];
        Deque<YX> dq = new ArrayDeque<>();
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < X; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //BFS
        int cnt = 0;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (arr[i][j] == 0) {
                    dq.addLast(new YX(i, j));
                    arr[i][j] = 1;
                    cnt++;
                    while (!dq.isEmpty()) {
                        YX now = dq.pollFirst();

                        for (int k = 0; k < 4; k++) {
                            int nexty = (Y + now.y + arry[k]) % Y;
                            int nextx = (X + now.x + arrx[k]) % X;
                            if (arr[nexty][nextx] == 0) {
                                dq.addLast(new YX(nexty, nextx));
                                arr[nexty][nextx] = arr[now.y][now.x] + 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
