import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        char[][] chars = new char[5][15];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(chars[i], ' ');
        }
        for (int i = 0; i <5; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                chars[i][j] = charArray[j];

            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                char c = chars[j][i];
                if (c == ' ') {
                    continue;
                }
                sb.append(c);
            }
        }
        System.out.println(sb);

    }
}
