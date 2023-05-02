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
        if (N <= 2) {
            System.out.println(1);
            return;
        }

        long[] arr = new long[90 + 1];
        arr[1] = 1L;
        arr[2] = 1L;
        for (int i = 3; i < 91; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[N]);
    }
}
