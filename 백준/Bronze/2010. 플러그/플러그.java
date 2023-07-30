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
        int x = 1;
        for (int i = 0; i < N; i++) {
            x += Integer.parseInt(br.readLine());
        }
        System.out.print(x-N);
    }
}
