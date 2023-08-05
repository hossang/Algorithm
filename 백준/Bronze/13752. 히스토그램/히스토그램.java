
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int i1 = Integer.parseInt(br.readLine());
            for (int j = 0; j < i1; j++) {
                sb.append('=');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
