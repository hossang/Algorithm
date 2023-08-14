import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            st = new StringTokenizer(s, " ");
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            boolean[] visited = new boolean[N];
            int[] ans = new int[6];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backTracking(0, 0,visited, arr, ans);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void backTracking(int cnt, int start, boolean[] visited, int[] arr, int[] ans) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[cnt] = arr[i];
                backTracking(cnt + 1, i + 1, visited, arr, ans);
                visited[i] = false;
            }
        }
    }


}
