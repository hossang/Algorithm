import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static final int INF = 1_000_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        String s = br.readLine();
        if (s.equals("SONGDO")) {
            System.out.println("HIGHSCHOOL");
            return;
        }
        if (s.equals("CODE")) {
            System.out.println("MASTER");
            return;
        }
        if (s.equals("2023")) {
            System.out.println("0611");
            return;
        }
        if (s.equals("ALGORITHM")) {
            System.out.println("CONTEST");
            return;
        }
    }
}
