import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] directions;

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //이동순서 결정
        directions = new int[1024][5];
        int idx = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    for (int l = 1; l <= 4; l++) {
                        for (int m = 1; m <= 4; m++) {
                            directions[idx][0] = i;
                            directions[idx][1] = j;
                            directions[idx][2] = k;
                            directions[idx][3] = l;
                            directions[idx][4] = m;
                            idx++;
                        }
                    }
                }
            }
        }
        //이동시키기
        for (int i = 0; i < 1024; i++) {
            //arr배열 복사하고 합쳐진거 체크하는 배열 mergedarr 생성
            int[][] tmp = copyArray(arr);
            //1번 이동
            tmp = move(tmp, directions[i][0]);
            //2번 이동
            tmp = move(tmp, directions[i][1]);
            //3번 이동
            tmp = move(tmp, directions[i][2]);
            //4번 이동
            tmp = move(tmp, directions[i][3]);
            //5번 이동
            tmp = move(tmp, directions[i][4]);
            //큰수 찾기
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    max = Math.max(max, tmp[j][k]);
                }
            }
        }
        //큰수 출력
        System.out.println(max);
    }

    private static int[][] copyArray(int[][] arr) {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    private static int[][] move(int[][] tmp, int direction) {
        //좌우상하
        if (direction == 1) {
            return left(tmp);
        }
        if (direction == 2) {
            return right(tmp);
        }
        if (direction == 3) {
            return up(tmp);
        }
        return down(tmp);
    }

    private static int[][] left(int[][] tmp) {
        int[][] arr = new int[N][N];
        boolean[][] merged = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (tmp[i][j] > 0) {
                    arr[i][idx] = tmp[i][j];
                    //합쳐
                    if (idx > 0 && !merged[i][idx - 1] && !merged[i][idx] && arr[i][idx - 1] == arr[i][idx]) {
                        arr[i][idx - 1] *= 2;
                        merged[i][idx - 1] = true;
                        arr[i][idx] = 0;
                        continue;
                    }
                    idx++;
                }
            }
        }
        return arr;
    }

    private static int[][] right(int[][] tmp) {
        int[][] arr = new int[N][N];
        boolean[][] merged = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            int idx = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (tmp[i][j] > 0) {
                    arr[i][idx] = tmp[i][j];
                    if (idx < N - 1 && !merged[i][idx + 1] && !merged[i][idx] && arr[i][idx + 1] == arr[i][idx]) {
                        arr[i][idx + 1] *= 2;
                        merged[i][idx + 1] = true;
                        arr[i][idx] = 0;
                        continue;
                    }
                    idx--;
                }
            }
        }
        return arr;
    }

    private static int[][] up(int[][] tmp) {
        int[][] arr = new int[N][N];
        boolean[][] merged = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (tmp[j][i] > 0) {
                    arr[idx][i] = tmp[j][i];
                    //합쳐
                    if (idx > 0 && !merged[idx - 1][i] && !merged[idx][i] && arr[idx - 1][i] == arr[idx][i]) {
                        arr[idx - 1][i] *= 2;
                        merged[idx - 1][i] = true;
                        arr[idx][i] = 0;
                        continue;
                    }
                    idx++;
                }
            }
        }
        return arr;
    }

    private static int[][] down(int[][] tmp) {
        int[][] arr = new int[N][N];
        boolean[][] merged = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            int idx = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (tmp[j][i] > 0) {
                    arr[idx][i] = tmp[j][i];
                    if (idx < N - 1 && !merged[idx + 1][i] && !merged[idx][i] && arr[idx + 1][i] == arr[idx][i]) {
                        arr[idx + 1][i] *= 2;
                        merged[idx + 1][i] = true;
                        arr[idx][i] = 0;
                        continue;
                    }
                    idx--;
                }
            }
        }
        return arr;
    }
}