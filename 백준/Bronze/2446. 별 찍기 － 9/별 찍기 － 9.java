import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;
    private static final Long INF = (long) (1e10 * 5 + 1);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = N - i;
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        int n = 2;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
            n++;
        }

    }
}
