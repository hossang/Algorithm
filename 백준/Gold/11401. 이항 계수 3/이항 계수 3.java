import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static final long MOD = 1_000_000_007L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long numerator = factorial(N);
        long denominator = factorial(K) * factorial(N - K) % MOD;

        long res = numerator * pow(denominator, MOD - 2) % MOD;
        System.out.println(res);
    }

    private static long factorial(long n) {
        long x = 1L;

        while(n > 1) {
            x = (x * n) % MOD;
            n--;
        }
        return x;
    }

    private static long pow(long d, long e) {
        long res = 1;

        while (e > 0) {
            if (e % 2 == 1) {
                res *= d;
                res %= MOD;
            }
            d = (d * d) % MOD;
            e /= 2;
        }
        return res;
    }
}


