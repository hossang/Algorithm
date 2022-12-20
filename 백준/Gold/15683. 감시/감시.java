import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static int min, y, x;
    private static List<XY> list;

    private static class XY {
        int x;
        int y;
        int direction;

        public XY(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[y][x];
        list = new ArrayList<>();
        List<XY> five = new ArrayList<>();
        min = 0;
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp > 0) {
                    arr[i][j] = tmp;
                    if (tmp < 5) {
                        list.add(new XY(j, i, 0)); //cctv1~4
                    } else if (tmp == 5) {
                        five.add(new XY(j, i, 0)); //cctv5는 따로 관리
                    }
                    continue; //벽
                }
                min++;
            }
        }
        //cctvfive()
        for (int i = 0; i < five.size(); i++) {
            cctvfive(five.get(i));
        }
        //backTracking
        backTracking(0);
        //최소값출력
        System.out.println(min);

    }

    private static void backTracking(int count) {
        if (count == list.size()) {
            int num = 0;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (arr[i][j] == 0) {
                        num++;
                    }
                }
            }
            min = Math.min(min, num);
            return;
        }

        XY now = list.get(count);
        for (int i = 0; i < 4; i++) { //방향설정
            now.direction = i; //방향설정
            switch (arr[now.y][now.x]) {
                case 1:
                    cctvone(now, true);
                    break;
                case 2:
                    cctvtwo(now, true);
                    break;
                case 3:
                    cctvthree(now, true);
                    break;
                case 4:
                    cctvfour(now, true);
                    break;
            }
            backTracking(count + 1);

            switch (arr[now.y][now.x]) {
                case 1:
                    cctvone(now, false);
                    break;
                case 2:
                    cctvtwo(now, false);
                    break;
                case 3:
                    cctvthree(now, false);
                    break;
                case 4:
                    cctvfour(now, false);
                    break;
            }
        }
    }

    private static void cctvfive(XY now) {
        left(now, true);
        right(now, true);
        up(now, true);
        down(now, true);
    }

    private static void cctvfour(XY now, boolean flag) {
        switch (now.direction) {
            case 0:
                left(now, flag);
                up(now, flag);
                right(now, flag);
                break;
            case 1:
                up(now, flag);
                right(now, flag);
                down(now, flag);
                break;
            case 2:
                right(now, flag);
                down(now, flag);
                left(now, flag);
                break;
            case 3:
                down(now, flag);
                left(now, flag);
                up(now, flag);
                break;
        }
    }

    private static void cctvthree(XY now, boolean flag) {
        switch (now.direction) {
            case 0:
                left(now, flag);
                up(now, flag);
                break;
            case 1:
                up(now, flag);
                right(now, flag);
                break;
            case 2:
                right(now, flag);
                down(now, flag);
                break;
            case 3:
                down(now, flag);
                left(now, flag);
                break;
        }
    }

    private static void cctvtwo(XY now, boolean flag) {
        switch (now.direction) {
            case 0:
            case 2:
                left(now, flag);
                right(now, flag);
                break;
            case 1:
            case 3:
                up(now, flag);
                down(now, flag);
                break;
        }
    }

    private static void cctvone(XY now, boolean flag) {
        switch (now.direction) {
            case 0:
                left(now, flag);
                break;
            case 1:
                right(now, flag);
                break;
            case 2:
                up(now, flag);
                break;
            case 3:
                down(now, flag);
                break;
        }
    }

    private static void down(XY now, boolean flag) {
        for (int i = now.y + 1; i < y; i++) {
            if (arr[i][now.x] == 6) {
                break;
            } else if (arr[i][now.x] > 0 && arr[i][now.x] < 6) {
                continue;
            } else if (flag) {
                arr[i][now.x] += 7;
            } else if (!flag) {
                arr[i][now.x] -= 7;
            }
        }
    }

    private static void up(XY now, boolean flag) { //상
        for (int i = now.y - 1; i >= 0; i--) {
            if (arr[i][now.x] == 6) {
                break;
            } else if (arr[i][now.x] > 0 && arr[i][now.x] < 6) {
                continue;
            } else if (flag) {
                arr[i][now.x] += 7;
            } else if (!flag) {
                arr[i][now.x] -= 7;
            }
        }
    }

    private static void right(XY now, boolean flag) { //우
        for (int i = now.x + 1; i < x; i++) {
            if (arr[now.y][i] == 6) {
                break;
            } else if (arr[now.y][i] > 0 && arr[now.y][i] < 6) {
                continue;
            } else if (flag) {
                arr[now.y][i] += 7;
            } else if (!flag) {
                arr[now.y][i] -= 7;
            }
        }
    }

    private static void left(XY now, boolean flag) { //좌
        for (int i = now.x - 1; i >= 0; i--) {
            if (arr[now.y][i] == 6) {
                break;
            } else if (arr[now.y][i] > 0 && arr[now.y][i] < 6) {
                continue;
            } else if (flag) {
                arr[now.y][i] += 7;
            } else if (!flag) {
                arr[now.y][i] -= 7;
            }
        }
    }

}