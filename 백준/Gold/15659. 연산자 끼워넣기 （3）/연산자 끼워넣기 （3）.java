import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static int[] arr, pmmd, combin;

    public static void main(String[] args) throws IOException {
        /*  주어진 수의 순서를 바꾸면 안 된다.
         * 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다
         * 나눗셈은 정수 나눗셈으로 몫만 취한다. 음수를 양수로 나눌 때는 C++14의 기준을 따른다.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        pmmd = new int[4];
        combin = new int[n - 1];
        Arrays.fill(combin, -1);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            pmmd[i] = Integer.parseInt(st.nextToken());
        }
        pmmdBackTracking(0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void pmmdBackTracking(int count) {
        if (count == n - 1) {
            //초기화
            Deque<Integer> pmmdDQ = new ArrayDeque<>();
            Deque<Integer> arrDQ = new ArrayDeque<>();
            Deque<Integer> tmp = new ArrayDeque<>();
            for (int i = 0; i < n - 1; i++) {
                pmmdDQ.addLast(combin[i]);
            }
            for (int i = 0; i < n; i++) {
                arrDQ.addLast(arr[i]);
            }
            // * 또는 / 하기
            tmp.addLast(arrDQ.pollFirst());
            int psize = pmmdDQ.size();
            for (int i = 0; i < psize; i++) {
                // * /을 만나면 계산하고 넣기
                if (pmmdDQ.peekFirst() == 0 || pmmdDQ.peekFirst() == 1) {
                    pmmdDQ.addLast(pmmdDQ.pollFirst());
                    tmp.addLast(arrDQ.pollFirst());
                } else {
                    if (pmmdDQ.peekFirst() == 2) {
                        int x = tmp.pollLast();
                        int y = arrDQ.pollFirst();
                        pmmdDQ.pollFirst();
                        tmp.addLast(x * y);
                    } else if (pmmdDQ.peekFirst() == 3) {
                        int x = tmp.pollLast();
                        int y = arrDQ.pollFirst();
                        pmmdDQ.pollFirst();
                        tmp.addLast(x / y);
                    }
                }
            }
            arrDQ = tmp;
            tmp = new ArrayDeque<>();
            // + - 하기
            tmp.addLast(arrDQ.pollFirst());
            psize = pmmdDQ.size();
            for (int i = 0; i < psize; i++) {
                // * /을 만나면 계산하고 넣기
                if (pmmdDQ.peekFirst() == 0) {
                    int x = tmp.pollLast();
                    int y = arrDQ.pollFirst();
                    pmmdDQ.pollFirst();
                    tmp.addLast(x + y);
                } else if (pmmdDQ.peekFirst() == 1) {
                    int x = tmp.pollLast();
                    int y = arrDQ.pollFirst();
                    pmmdDQ.pollFirst();
                    tmp.addLast(x - y);
                }
            }
            int num = tmp.pollLast();
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for (int i = 0; i < 4; i++) {
            if (pmmd[i] > 0) {
                pmmd[i] -= 1;
                combin[count] = i;
                pmmdBackTracking(count + 1);
                combin[count] = -1;
                pmmd[i] += 1;
            }
        }
    }
}