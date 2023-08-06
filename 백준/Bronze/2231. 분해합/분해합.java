import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for (int i = 2; i <= c; i++) {
            //각 자리의 합
            int sum = i;
            int j = i;
            while (j != 0) {
                sum += j % 10;
                j /= 10;
            }
            if (sum == c) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
