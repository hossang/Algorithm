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
            st = new StringTokenizer(br.readLine(), " ");
            int Ai = Integer.parseInt(st.nextToken());
            int Bi = Integer.parseInt(st.nextToken());
            int Xi = Integer.parseInt(st.nextToken());

            System.out.println((Xi - 1) * Ai + Bi);
        }
    }
}
