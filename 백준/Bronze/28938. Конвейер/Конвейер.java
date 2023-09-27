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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum == 0) {
            System.out.println("Stay");
        } else if (sum > 0) {
            System.out.println("Right");
        } else {
            System.out.println("Left");
        }
        
    }
}
