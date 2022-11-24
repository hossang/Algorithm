import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str1 = br.readLine();
        String str2 = br.readLine();
        Deque<Character> deque1 = new ArrayDeque<>(); //stack
        Deque<Character> deque2 = new ArrayDeque<>(); //deque
        for (int i = 0; i < str2.length(); i++) {
            deque2.addLast(str2.charAt(i));
        }
        int count = 0;
        int i = 0;
        int size = str1.length();
        while (true){
            if (deque1.peekLast() == deque2.peekFirst()) {//같으면
                count++;
                deque2.addLast(deque2.pollFirst());
            } else { //같지 않으면 덱을 원래대로 만들어주고, 카운트 초기화
                for (int j = 0; j < count; j++) {
                    deque2.addFirst(deque2.pollLast());
                }
                if (count > 0) {
                    count = 0;
                    continue;
                }
            }
            if (count == deque2.size()) {
                for (int j = 0; j < count; j++) {
                    deque1.pollLast();
                }
                count = 0;
                continue;
            }
            if (i == str1.length()) { //★
                if (size == deque1.size()) {
                    break;
                } else {
                    for (char val : deque1) {
                        sb.append(val);
                    }
                    str1 = sb.toString();
                    sb = new StringBuilder();
                    count = 0;
                    i = 0;
                    size = str1.length();
                    deque1.clear();
                    continue;
                }

            }
            deque1.addLast(str1.charAt(i++));
        }

        if (deque1.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char val : deque1) {
                sb.append(val);
            }
            System.out.println(sb);
        }

    }
}