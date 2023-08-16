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
        String s = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int idx = 0;
        long res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (0 <= c - '0' && c - '0' <= 9) {
                res += (c - '0') * Math.pow(B, idx++);
                continue;
            }
            res += (c - 'A' + 10) * Math.pow(B, idx++);
        }
        System.out.println(res);
    }
}
