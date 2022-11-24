import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr, result;
    private static boolean[] visited;
    private static int l, c;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        //암호는 서로 다른 L개의 알파벳 소문자들로 구성되며
        // 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다
        //암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[c];
        visited = new boolean[26]; //알파벳 갯수
        result = new int[l];
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0)-'a'; //모음 위치 0,4,8,14,20
        }
        Arrays.sort(arr);

        brackTracking(0);

        System.out.println(sb);
    }

    private static void brackTracking(int count) {
        if (count >= 2 && result[count - 2] > result[count - 1]) {
            return;
        }
        if (count == l) {
            int sum = 0;
            if (visited[0]) {
                sum++;
            }
            if (visited[4]) {
                sum++;
            }if (visited[8]) {
                sum++;
            }if (visited[14]) {
                sum++;
            }if (visited[20]) {
                sum++;
            }
            if (sum == 0 || l - sum < 2) {
                return;
            }
            for (int i : result) {
                sb.append((char) (i + 'a'));
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < c; i++) {
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                result[count] = arr[i];
                brackTracking(count + 1);
                visited[arr[i]] = false;
            }
        }
    }

}
