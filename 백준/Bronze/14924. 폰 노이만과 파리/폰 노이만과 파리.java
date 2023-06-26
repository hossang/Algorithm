import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static final int INF = 1_000_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        System.out.println(D/(2*S)*T);
    }
}
