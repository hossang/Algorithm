import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class XY {
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Direct {
    int sec;
    int dir;

    public Direct(int sec, int dir) {
        this.sec = sec;
        this.dir = dir;
    }
}

public class Main {
    private static int[][] apple;

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        apple = new int[n][n];
        int[] arrx = {1, 0, -1, 0}; //우상좌하
        int[] arry = {0, -1, 0, 1}; //D이면 -1 L +1
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()) - 1;
            int column = Integer.parseInt(st.nextToken()) - 1;
            apple[row][column] = 4;
        }
        int l = Integer.parseInt(br.readLine());
        List<Direct> list = new ArrayList<>();
        list.add(new Direct(0, 0));
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sec = Integer.parseInt(st.nextToken());
            char dl = st.nextToken().charAt(0);
            if (dl == 'D') {
                list.add(new Direct(sec, list.get(i).dir - 1));
            } else {
                list.add(new Direct(sec, list.get(i).dir + 1));
            }
        }
        list.add(new Direct(100_000_000, 0));
        Deque<XY> dq = new ArrayDeque<>();
        dq.addLast(new XY(0, 0));
        apple[0][0] = 1;
        int count = 0; //시간
        int idx = 0; //list의 인덱스

        while (!dq.isEmpty()) {
            XY now = dq.peekLast();
            //방향확인하기
            if (count >= list.get(idx).sec && count < list.get(idx + 1).sec) {
                int nextx = now.x + arrx[(1_048_576 + list.get(idx).dir) % 4];
                int nexty = now.y + arry[(1_048_576 + list.get(idx).dir) % 4];
                //벽만나면 탈출
                if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= n) {
                    break;
                }
                //자기자신 만나면 탈출
                if (apple[nexty][nextx] == 1) {
                    break;
                }
                //이동하기
                dq.addLast(new XY(nextx, nexty));
                //사과탐지
                if (apple[nexty][nextx] == 4) {
                    apple[nexty][nextx] = 1;
                } else {
                    //사과가 없어 ㅜㅜ
                    apple[nexty][nextx] = 1;
                    XY tail = dq.pollFirst();
                    apple[tail.y][tail.x] = 0;
                }
                count++;
            } else { //방향이 바뀌면 idx만 증가시키고 다시 집어넣기
                idx++;
            }
        }
        System.out.println(count+1);
    }
}