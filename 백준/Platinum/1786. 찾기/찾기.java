import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    private static final int a = 31;
    private static final int m = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        /*BigInteger bigInteger = BigInteger.valueOf(1234567891);
        System.out.println(bigInteger.multiply(bigInteger)); -> 1524157877488187881
        long l = 1234567891L;
        System.out.println(l * l); -> 1524157877488187881*/
        List<Integer> ll = new LinkedList<>();
        String t = br.readLine();
        String p = br.readLine();
        int tsize = t.length();
        int psize = p.length();
        if (tsize < psize) {
            System.out.println(0);
            return;
        }
        long phash = 0L;
        long thash = 0L;
        long[] pow = new long[psize];
        pow[0] = 1;
        for (int i = 1; i < psize; i++) {
            pow[i] = pow[i - 1] * a % m;
        }
        for (int i = 0; i < psize; i++) {
            thash = (thash + t.charAt(i) * pow[psize - 1 - i]) % m;
            phash = (phash + p.charAt(i) * pow[psize - 1 - i]) % m;
        }
        if (thash == phash) {
            ll.add(1);
        }
        for (int i = 1; i <= tsize - psize; i++) {
            thash = (thash - t.charAt(i - 1) * pow[psize - 1]) % m;

            if (thash < 0) { //★0보다 작은데 왜 나머지를 더하는거지? -> 바로 뒤에서 thash = thash % m *a로 나머지 없애줌(양수만들기)
                thash += m; //★근데 음수가 왜 나오지 ? -> 계속 m으로 나눠주기 때문에 thash가 t.charAt(i - 1) * pow[psize - 1] 보다 작아질 수 있음
            }
            thash = thash * a % m;
            thash = (thash + t.charAt(i + psize - 1)) % m;
            if (thash == phash) {
                ll.add(i + 1);
            }
        }
        System.out.println(ll.size());
        for (Integer integer : ll) {
            sb.append(integer).append(" ");
        }
        System.out.print(sb);
    }
}