import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int n;
    private static long sum;
    private static int[][] visited;
    private static int[] queen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new int[n][n];
        queen = new int[n];
        Arrays.fill(queen, -1);
        sum = 0L;
        backTracking(0);
        System.out.println(sum);
    }

    private static void backTracking(int count) {
        //1.n개의 크기면 n개의 퀸이 보드 판에 존재해야함
        //2.퀸을 놓는 순간 상하좌우대각선 true로 바꿔줘야함 -> 5. integer로 바꿔주기
        //3.backTracking 실행될때마다 오른쪽으로 한칸씩이동 (start)
        //4.퀸의 위치도 알고 있긴해야겠네 (인덱스가 가로, 값에 세로를 기록)
        //5.visited가 boolean[] 이면 안되네, why? backTracking 돌고나서 지울 때 다 지움
        //6.queen[]을 처음에 -1로 초기화해줌, why? 값이 0일 수 있잖아
        if (count == n) {
            for (int i : queen) {
                if (i == -1) {
                    return;
                }
            }
            sum++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i][count] <= 0) {
                //여왕위치 기록
                queen[count] = i;
                //상하좌우
                for (int j = 0; j < n; j++) {
                    visited[j][count] += 1; //상하
                    visited[i][j] += 1; //좌우
                }

                //대각선 \ / 아래
                for (int j = i + 1, left = count - 1, right = count + 1; j < n; j++, left--, right++) {
                    if (left >= 0) {
                        visited[j][left] += 1; // 대각선 /
                    }
                    if (right < n) {
                        visited[j][right] += 1; //대각선 \
                    }
                }
                //대각선 \ / 위
                for (int j = i - 1, left = count - 1, right = count + 1; j >= 0; j--, left--, right++) {
                    if (left >= 0) {
                        visited[j][left] += 1; //대각선 \
                    }
                    if (right < n) {
                        visited[j][right] += 1; //대각선 /
                    }
                }
                //6.근데 보니까 여왕위치 중복처리되네
                visited[i][count] -= 1;

                //7.start 굳이 필요하나?
                backTracking(count+1);

                //8.근데 원래 n-queen 코드가 이렇게 길었나?
                queen[count] = -1;
                //상하좌우
                for (int j = 0; j < n; j++) {
                    visited[j][count] -= 1;
                    visited[i][j] -= 1;
                }

                //대각선 \ / 아래
                for (int j = i + 1, left = count - 1, right = count + 1; j < n; j++, left--, right++) {
                    if (left >= 0) {
                        visited[j][left] -= 1;
                    }
                    if (right < n) {
                        visited[j][right] -= 1;
                    }
                }
                //대각선 \ / 위
                for (int j = i - 1, left = count - 1, right = count + 1; j >= 0; j--, left--, right++) {
                    if (left >= 0) {
                        visited[j][left] -= 1;
                    }
                    if (right < n) {
                        visited[j][right] -= 1;
                    }
                }
                visited[i][count] += 1;
            }
        }
    }
}