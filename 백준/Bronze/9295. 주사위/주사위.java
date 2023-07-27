import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sb.append("Case ").append(i + 1).append(": ").append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
