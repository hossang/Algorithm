import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Integer[] alphabets = new Integer[26];
        Arrays.fill(alphabets,0);
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int num = (int) Math.pow(10, s.length() - 1);
            for (int j = 0; j < s.length(); j++) {
                alphabets[s.charAt(j) - 'A'] += num;
                num /= 10;
            }
        }
        Arrays.sort(alphabets,Comparator.reverseOrder());

        int sum = 0;
        int idx = 0;
        int a = 9;
        while (alphabets[idx] != 0) {
            sum += alphabets[idx++] * a--;
        }
        System.out.println(sum);
    }
}
