import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(10);
        list.add(5);
        list.add(1);
        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());

            for (int j = 0; j < list.size(); j++) {
                sb.append(C / list.get(j)).append(" ");
                C = C % list.get(j);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
