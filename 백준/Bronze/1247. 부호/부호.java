import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            int i1 = Integer.parseInt(br.readLine());
            BigInteger res = new BigInteger("0");
            for (int j = 0; j < i1; j++) {
                BigInteger tmp = new BigInteger(br.readLine());
                res = res.add(tmp);
            }
            if (res.compareTo(BigInteger.ZERO) == 1) {
                sb.append("+");
            }
            if (res.compareTo(BigInteger.ZERO) == -1) {
                sb.append("-");
            }
            if (res.compareTo(BigInteger.ZERO) == 0) {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
