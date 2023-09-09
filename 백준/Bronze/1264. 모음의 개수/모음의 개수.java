import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        while (true) {
            String s = br.readLine().toLowerCase();
            if (s.equals("#")) {
                break;
            }
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    res++;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
