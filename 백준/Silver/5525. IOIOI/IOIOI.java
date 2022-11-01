import java.util.*;
import java.io.*;

public class Main {
    private static final int a = 31;
    private static final int m = 1234567891;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tnum = Integer.parseInt(br.readLine());
        String t = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append("IOI");
        for (int i = 1; i < n; i++) {
            sb.append("OI");
        }
        String p = sb.toString();
        int pnum = p.length();
        long phash = 0L;
        long thash = 0L;
        long[] power = new long[pnum];
        power[0] = 1;

        for (int i = 1; i < pnum; i++) {
            power[i] = power[i - 1] * a % m;
        }
        for (int i = 0; i < pnum; i++) {
            phash = (phash + power[pnum - 1 - i] * p.charAt(i)) % m;
            thash = (thash + power[pnum - 1 - i] * t.charAt(i)) % m;
        }
        int count = 0;
        if (phash == thash) {
            count++;
        }
        for (int i = 1; i <= tnum - pnum; i++) {
            thash =  (thash - power[pnum - 1] * t.charAt(i - 1)) % m;
            if (thash < 0) {
                thash += m;
            }
            thash = a * thash % m;
            thash = (thash + t.charAt(pnum - 1 + i)) % m;
            if (thash == phash) {
                count++;
            }
        }
        System.out.println(count);
    }
}