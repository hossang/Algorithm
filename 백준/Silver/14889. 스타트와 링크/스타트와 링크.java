import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int diff = Integer.MAX_VALUE;
    private static int[][] arr;
    private static int[] start, link;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /* N은 짝수이다. 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
         * BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고,
         * 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다.
         * 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다
         *  Sij는 Sji와 다를 수도 있으며, (Q이게 왜 다를 수 있지? =>입력으로 능력치 표가 주어지네~)
         * i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.
         * 축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다
         * =>
         * */
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        start = new int[n / 2];
        link = new int[n / 2];
        visited = new boolean[n + 1];
        arr = new int[n + 1][n + 1]; //1 ~ n
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //백트래킹
        backTracking(0, 1);
        //차이 출력
        System.out.println(diff);
    }

    private static void backTracking(int count, int s) {
        if (count == n / 2) {
            int idx = 0;
            for (int i = 1; i <= n; i++) { //link 채우기
                if (!visited[i]) {
                    link[idx++] = i;
                }
            }
            
            int startSum = 0;
            int linkSum = 0;
            for (int i = 0; i < link.length; i++) { //start, link 합구하기
                for (int j = 0; j < link.length; j++) {
                    if (j != i) {
                        linkSum += arr[link[i]][link[j]];
                        startSum += arr[start[i]][start[j]];
                    }
                }
            }
            diff = Math.min(diff, Math.abs(linkSum - startSum));
            return;
        }

        for (int i = s; i <= n; i++) {
            start[count] = i;
            visited[i] = true;
            backTracking(count + 1, i + 1);
            visited[i] = false;

        }
    }

}