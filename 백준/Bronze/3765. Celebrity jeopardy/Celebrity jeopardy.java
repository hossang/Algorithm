import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        String s;
        while (true) {
            if ((s= br.readLine()) == null) {
                break;
            }
            sb.append(s).append("\n");

        }
        System.out.println(sb);
    }
}
