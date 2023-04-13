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
        if (N == 0) {
            System.out.println("YONSEI");
            return;
        }
        System.out.println("Leading the Way to the Future");
    }
}
