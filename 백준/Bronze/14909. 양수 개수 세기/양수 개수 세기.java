import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int res = 0;
        while (st.hasMoreTokens()) {
            if (Integer.parseInt(st.nextToken()) > 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}
