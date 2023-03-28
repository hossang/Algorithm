import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, N) - 1)).append("\n");

        hanoi(N, 1, 2, 3);
        System.out.println(sb);

    }

    private static void hanoi(int n, int from, int tmp, int to) {
        if (n == 1) {
            sb.append(from + " " + to).append("\n");
            return;
        }
        hanoi(n - 1, from, to, tmp);
        sb.append(from + " " + to).append("\n");
        hanoi(n - 1, tmp, from, to);
    }
}