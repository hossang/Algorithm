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

        int n = Integer.parseInt(br.readLine());
        while (true) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                break;
            }
            if (x % n == 0) {
                System.out.println(x + " is a multiple of " + n + ".");
                continue;
            }
            System.out.println(x + " is NOT a multiple of " + n + ".");
        }

    }
}
