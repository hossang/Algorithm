import java.io.*;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        //fail 1
        /*sb.append(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int cursor = sb.length();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            if (a.equals("L")) {
                cursor = Math.max(0, cursor - 1);
                continue;
            }

            if (a.equals("D")) {
                cursor = Math.min(sb.length(), cursor + 1);
                continue;
            }
            if (a.equals("B")) {
                if (cursor == 0) {
                    continue;
                }
                cursor = cursor - 1;
                sb.deleteCharAt(cursor);
                continue;
            }
            if (st.hasMoreTokens()) {
                String b = st.nextToken();
                sb.insert(cursor, b);
                cursor = Math.min(sb.length(), cursor + 1);
            }
        }*/

        //fail2
        /*String s = br.readLine();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        int cursor = list.size();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            if (c == 'L') {
                cursor = Math.max(0, cursor - 1);
                continue;
            }
            if (c == 'D') {
                cursor = Math.min(list.size(), cursor + 1);
                continue;
            }
            if (c == 'B') {
                if (cursor == 0) {
                    continue;
                }
                cursor = cursor - 1;
                list.remove(cursor);
                continue;
            }
            if (st.hasMoreTokens()) {
                char c1 = st.nextToken().charAt(0);
                list.add(cursor, c1);
                cursor = Math.min(list.size(), cursor + 1);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb);*/

        //덱 쓸 생각은 상상도 못했네
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Deque<Character> dq1 = new ArrayDeque<>();
        Deque<Character> dq2 = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            dq1.addLast(s.charAt(i));
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            if (c == 'L') {
                if (!dq1.isEmpty()) {
                    dq2.addLast(dq1.pollLast());
                }
            }
            if (c == 'D') {
                if (!dq2.isEmpty()) {
                    dq1.addLast(dq2.pollLast());
                }
            }
            if (c == 'B') {
                if (!dq1.isEmpty()) {
                    dq1.pollLast();
                }
            }
            if (st.hasMoreTokens()) {
                char c1 = st.nextToken().charAt(0);
                dq1.addLast(c1);
            }
        }
        while (!dq1.isEmpty()) {
            sb.append(dq1.pollFirst());
        }
        while (!dq2.isEmpty()) {
            sb.append(dq2.pollLast());
        }
        System.out.println(sb);
    }
}
