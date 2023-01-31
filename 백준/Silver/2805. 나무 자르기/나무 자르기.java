import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); //나무의 수
        int m = Integer.parseInt(st.nextToken()); //나무의 길이
        int[] arr = new int[n];
        long right = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (right < arr[i]) {
                right = arr[i];
            }
        }
        //적어도 m미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력
        long left = 0;
        while (left < right) {
            long mid = (left + right) / 2; //자르는 길이 ex 15
            long sum = 0;
            for (int i : arr) {
                if (mid < i) {
                    sum += i - mid; //자르고 남은 길이 ex 7
                }
            }

            if (sum < m) { //자르고 남은 길이가 m보다 작으면
                right = mid;
            } else {
                left = mid + 1; //자르고 남은 길이가 m이랑 같거나 m보다 크면
            }
        }
        System.out.println(left - 1);

    }
}
