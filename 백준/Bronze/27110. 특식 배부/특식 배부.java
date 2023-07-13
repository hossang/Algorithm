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
        int sum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x < N) {
                sum += x;
                continue;
            }
            sum += N;
        }
        System.out.println(sum);
    }
}
