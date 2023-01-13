import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] primes = new boolean[N + 1];
        primes[0] = true;
        primes[1] = true;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i * i <=N; i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (!primes[i]) {
                list.add(i);
            }
        }
        int lp = 0;
        int rp = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= N) {
                sum -= list.get(lp++);
            } else if (rp == list.size()) {
                break;
            } else if (sum < N) {
                sum += list.get(rp++);
            }
            if (sum == N) {
                count++;
            }
        }
        System.out.println(count);
    }
}
