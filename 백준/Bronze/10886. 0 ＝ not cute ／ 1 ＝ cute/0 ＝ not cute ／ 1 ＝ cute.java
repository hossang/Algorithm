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
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 1) {
                one++;
                continue;
            }
            zero++;
        }

        if (one > zero) {
            System.out.println("Junhee is cute!");
            return;
        }
        System.out.println("Junhee is not cute!");
    }
}
