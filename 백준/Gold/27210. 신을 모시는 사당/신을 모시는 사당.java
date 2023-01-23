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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //구간별 합 구하기
        int pre = arr[0];
        int sum = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] == pre) {
                sum ++;
            } else {
                list.add(sum);
                sum = 1;
                pre = arr[i];
            }
        }
        list.add(sum); //마지막 집합 넣어주기
        int max = 0;
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }
        if (list.size() == 2) {
            max = Math.max(list.get(0), list.get(1));
            System.out.println(max);
            return;
        }
        //누적합 같은데... 모르겠다...
        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(max, list.get(i));
            int tmp = list.get(i);
            boolean flag = true;
            for (int j = i + 1; j < list.size(); j++) {
                if (flag) {
                    tmp -= list.get(j);
                    flag = false;
                } else {
                    tmp += list.get(j);
                    flag = true;
                }
                max = Math.max(max, tmp);
            }
        }
        System.out.println(max);
    }
}
