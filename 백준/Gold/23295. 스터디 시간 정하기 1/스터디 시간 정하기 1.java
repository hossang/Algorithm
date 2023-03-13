import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        long[] prefixSum = new long[100_002];
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                prefixSum[S] += 1;
                prefixSum[E] -= 1;
            }
        }

        for (int i = 0; i < prefixSum.length - 1; i++) {
            prefixSum[i + 1] += prefixSum[i];
        }

        long max = Long.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < prefixSum.length - T; i++) {
            long sum = 0L;
            for (int j = i; j < T + i; j++) {
                sum += prefixSum[j];
            }
            if (max < sum) {
                max = sum;
                start = i;
                end = i + T;
            }
        }
        System.out.println(start + " " + end);

    }

}