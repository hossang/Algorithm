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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        b : while (true) {
            List<String> commands = new ArrayList<>();
            String str = "";
            while (true) {
                str = br.readLine();
                if (str.equals("QUIT")) {
                    break b;
                }
                if (str.equals("END")) {
                    break;
                }
                commands.add(str);
            }
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                //구현
                Deque<Long> dq = new ArrayDeque<>();
                dq.addLast(Long.parseLong(br.readLine()));
                boolean flag = true;
                a :
                for (int j = 0; j < commands.size(); j++) {
                    String s = commands.get(j);
                    long tmp1, tmp2, tmp3;
                    int remainder = 0;
                    switch (s) {
                        case "POP":
                            if (dq.isEmpty()) {
                                flag = false;
                                break a;
                            }
                            dq.pollLast();
                            break;
                        case "INV":
                            if (dq.isEmpty()) {
                                flag = false;
                                break a;
                            }
                            dq.addLast(dq.pollLast() * -1);
                            break;
                        case "DUP":
                            if (dq.isEmpty()) {
                                flag = false;
                                break a;
                            }
                            dq.addLast(dq.peekLast());
                            break;
                        case "SWP":
                            if (dq.size() < 2) {
                                flag = false;
                                break a;
                            }
                            tmp1 = dq.pollLast();
                            tmp2 = dq.pollLast();
                            dq.addLast(tmp1);
                            dq.addLast(tmp2);
                            break;
                        case "ADD":
                            if (dq.size() < 2) {
                                flag = false;
                                break a;
                            }
                            tmp1 = dq.pollLast();
                            tmp2 = dq.pollLast();
                            tmp3 = tmp1 + tmp2;
                            if (Math.abs(tmp3) > 1_000_000_000) {
                                flag = false;
                                break a;
                            }
                            dq.addLast(tmp3);
                            break;
                        case "SUB":
                            if (dq.size() < 2) {
                                flag = false;
                                break a;
                            }
                            tmp1 = dq.pollLast();
                            tmp2 = dq.pollLast();
                            tmp3 = tmp2 - tmp1;
                            if (Math.abs(tmp3) > 1_000_000_000) {
                                flag = false;
                                break a;
                            }
                            dq.addLast(tmp3);
                            break;
                        case "MUL":
                            if (dq.size() < 2) {
                                flag = false;
                                break a;
                            }
                            tmp1 = dq.pollLast();
                            tmp2 = dq.pollLast();
                            tmp3 = tmp2 * tmp1;
                            if (Math.abs(tmp3) > 1_000_000_000) {
                                flag = false;
                                break a;
                            }
                            dq.addLast(tmp3);
                            break;
                        case "DIV":
                            if (dq.size() < 2) {
                                flag = false;
                                break a;
                            }
                            tmp1 = dq.pollLast();
                            if (tmp1 == 0) {
                                flag = false;
                                break a;
                            }
                            if (tmp1 < 0) {
                                remainder++;
                            }
                            tmp2 = dq.pollLast();
                            if (tmp2 < 0) {
                                remainder++;
                            }
                            tmp3 = Math.abs(tmp2) / Math.abs(tmp1);
                            if (remainder == 1) {
                                tmp3 = tmp3 * -1;
                            }
                            if (Math.abs(tmp3) > 1_000_000_000) {
                                flag = false;
                                break a;
                            }
                            dq.addLast(tmp3);
                            break;
                        case "MOD":
                            if (dq.size() < 2) {
                                flag = false;
                                break a;
                            }
                            tmp1 = dq.pollLast();
                            if (tmp1 == 0) {
                                flag = false;
                                break a;
                            }
                            tmp2 = dq.pollLast();
                            if (tmp2 < 0) {
                                remainder++;
                            }
                            tmp3 = Math.abs(tmp2) % Math.abs(tmp1);
                            if (remainder == 1) {
                                tmp3 = tmp3 * -1;
                            }
                            if (Math.abs(tmp3) > 1_000_000_000) {
                                flag = false;
                                break a;
                            }
                            dq.addLast(tmp3);
                            break;
                        default:
                            st = new StringTokenizer(s, " ");
                            st.nextToken();
                            dq.addLast(Long.parseLong(st.nextToken()));
                            break;
                    }
                }
                if ((flag && dq.size() != 1) || !flag) {
                    sb.append("ERROR").append("\n");
                    continue;
                }
                if (flag) {
                    sb.append(dq.pop()).append("\n");
                }
            }
            br.readLine();
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
