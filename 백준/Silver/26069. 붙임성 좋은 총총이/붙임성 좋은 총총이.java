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
        Set<String> dances = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String A = st.nextToken();
            String B = st.nextToken();
            if (A.equals("ChongChong")) {
                dances.add(A);
            }
            if (B.equals("ChongChong")) {
                dances.add(B);
            }

            if (dances.contains(A)) {
                dances.add(B);
            }
            if (dances.contains(B)) {
                dances.add(A);
            }
        }
        System.out.println(dances.size());
    }
}
