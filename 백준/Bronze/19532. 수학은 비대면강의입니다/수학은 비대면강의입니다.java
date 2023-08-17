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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        a: for (int i = -999; i <= 999; i++) {

            for (int j = -999; j <= 999; j++) {
                if (a * i + b * j != c) {
                    continue;
                }
                if (d * i + e * j == f) {
                    System.out.println(i + " " + j);
                    break a;
                }
            }
        }
    }
}
