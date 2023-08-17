import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int l = 0;
        int r = (int) (1e9 + 7);
        int m;
        while (l + 1 < r) {
            m = l + (r - l) / 2;

            if (check(m, N, C)) {
                l = m;
                continue;
            }
            r = m;
        }

        System.out.println(l);
    }

    private static boolean check(int m, int n, int c) {
        int cnt = 1;
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];

            if (now - pre >= m) {
                cnt++;
                pre = now;
            }
        }
        return cnt >= c;
    }


}
