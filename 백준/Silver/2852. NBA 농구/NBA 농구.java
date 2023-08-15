import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " :");
            int a = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = mm * 60 + ss; //초로 변환하기
        }
        int[] res = new int[3];
        int[] scores = new int[3];

        int idx = 1;
        int win = 0;
        for (int i = 0; i < 2880; i++) {
            if (idx <= N && arr[idx][1] == i) {
                scores[arr[idx][0]]++;
                idx++;

            }
            if (scores[1] > scores[2]) {
                res[1]++;
                continue;
            }
            if (scores[1] < scores[2]) {
                res[2]++;
            }
        }

        if (res[1] / 60 < 10) {
            sb.append("0");
        }
        sb.append(res[1] / 60).append(":");
        if (res[1] % 60 < 10) {
            sb.append("0");
        }
        sb.append(res[1] % 60).append("\n");
        //
        if (res[2] / 60 < 10) {
            sb.append("0");
        }
        sb.append(res[2] / 60).append(":");
        if (res[2] % 60 < 10) {
            sb.append("0");
        }
        sb.append(res[2] % 60).append("\n");

        System.out.println(sb);
    }
}
