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

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];

        st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pq.offer(arr[i]);
        }
        //어려운점
        //어떤 규칙을 가지고 곱할지 ...(오름차순으로 주어지는 이유가 있음 분명)

        int cnt = 0;
        long result = 0L;
        a : while (cnt++<N) {
            result = pq.poll();

            for (int i = 0; i < K; i++) {
                long tmp = result * arr[i];
                if (tmp<Integer.MAX_VALUE) {
                    pq.offer(tmp);
                }
                if (result % arr[i] == 0) {
                    break;
                }
            }

        }
        System.out.println(result);
    }
}