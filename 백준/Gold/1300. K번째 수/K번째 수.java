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
        int k = Integer.parseInt(br.readLine());

        long l = -1;
        long r = (long) (1e10 + 1);
        long m, count;
        while (l + 1 < r) {
            m = l + (r - l) / 2;
            count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(m / i, N);
            }

            if (count < k) {
                l = m;
                continue;
            }
            r = m;
        }
        System.out.println(r);
    }
}
