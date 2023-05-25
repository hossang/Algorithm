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

        int n = Integer.parseInt(br.readLine());
        n %= 8;
        System.out.println(n > 5 || n == 0 ? (10 - n) % 8 : n);
    }
}
