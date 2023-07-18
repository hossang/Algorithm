import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long x, y;
        if (r%n > 0)
            x = r/n + 1;
        else
            x = r/n;
        if (c%n > 0)
            y = c/n + 1;
        else
            y = c/n;
        System.out.println(x*y);
    }
}
