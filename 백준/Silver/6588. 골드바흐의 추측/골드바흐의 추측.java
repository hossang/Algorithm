import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static final int PRIME = 1_000_000;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        boolean[] primes = new boolean[PRIME + 1];
        primes[0] = primes[1] = true;
        for (int i = 2; i * i <= PRIME; i++) {
            if (!primes[i]) {
                list.add(i);
                for (int j = i * i; j <= PRIME; j += i) {
                    primes[j] = true;
                }
            }
        }
        String str;
        while (!(str = br.readLine()).equals("0")) {
            int p = Integer.parseInt(str);
            int l;
            a:for (int i = 1; i < list.size(); i++) {
                l = list.get(i);
                if (!primes[p - l]) {
                    sb.append(p).append(" = ").append(l).append(" + ").append(p - l).append("\n");
                    break a;
                }
            }
        }
        System.out.println(sb);
    }
}