import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        long right = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (right < arr[i]) {
                right = arr[i];
            }
        }

        long left = 1;
        long mid = 0;
        right++;

        while (left + 1 < right) {
            mid = (left + right) / 2;
            long count = 0;

            for (int v : arr) {
                count += v / mid;
            }
            if (N <= count) {
                left = mid;
                continue;
            }
            right = mid;

        }
        System.out.println(left);
    }
}
