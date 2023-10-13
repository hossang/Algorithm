import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        
        if (N >= 1000) {
            if (U >= 8000 || L >= 260) {
                System.out.println("Very Good");
                return;
            }
            System.out.println("Good");
            return;
        }
        System.out.println("Bad");
        
    }
}
