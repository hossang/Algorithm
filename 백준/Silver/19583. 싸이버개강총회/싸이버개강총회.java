import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " :");
        //(00:00 ≤ S < E < Q ≤ 23:59) S<E<Q<= 23: 59 라는 조건이 있었네 ! 그럼 쉽지
        int S = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

        int res = 0;
        Set<String> set = new HashSet<>();
        String str;
        while ((str = br.readLine())!= null) {
            st = new StringTokenizer(str, " :");
            int t = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            if (t <= S) {
                set.add(s);
                continue;
            }
            if (E <= t && t <= Q && set.contains(s)) {
                set.remove(s);
                res++;
            }
        }
        System.out.println(res);
    }
}
