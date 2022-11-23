import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static int[] arr, result;
    private static boolean[] visited;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            //부분 집합 구하기
            arr = new int[k];
            result = new int[6];
            visited = new boolean[50]; //1~49
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backTracking(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void backTracking(int count) {
        if (count >= 2 && result[count - 1] < result[count - 2]) {
            return;
        }

        if (count == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                result[count] = arr[i];
                backTracking(count + 1);
                visited[arr[i]] = false;

            }
        }
    }


}
