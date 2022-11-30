import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            int pre = arr[0];
            switch (combin[0]) {
                case 0:
                    pre += arr[1];
                    break;
                case 1:
                    pre -= arr[1];
                    break;
                case 2:
                    pre *= arr[1];
                    break;
                case 3:
                    pre /= arr[1];
                    break;
            }

            for (int i = 2; i < n; i++) {
                switch (combin[i - 1]) {
                    case 0:
                        pre += arr[i];
                        break;
                    case 1:
                        pre -= arr[i];
                        break;
                    case 2:
                        pre *= arr[i];
                        break;
                    case 3:
                        pre /= arr[i];
                        break;
                }
            }
            max = Math.max(max, pre);
            min = Math.min(min, pre);
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