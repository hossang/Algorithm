import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis[0] = arr[0];
        int idx = 1;
        for (int i = 0; i < n; i++) {
            if (lis[idx - 1] < arr[i]) {
                lis[idx++] = arr[i];
                continue;
            }
            lowerbound(idx, arr[i], lis);
        }
        System.out.println(idx);
    }

    private static void lowerbound(int r, int k, int[] lis) {
        int l = -1;
        int m;

        while (l + 1 < r) {
            m = l + (r - l) / 2;

            if (lis[m] < k) {
                l = m;
                continue;
            }
            r = m;
        }
        lis[r] = k;
    }
}
