import java.io.*;
import java.util.*;



public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        String s = br.readLine().toLowerCase();
        if (s.equals("n")) {
            System.out.println("Naver D2");
            return;
        }
        System.out.println("Naver Whale");
        
    }
}
