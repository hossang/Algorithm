import java.io.*;
import java.util.*;

public class Main {
    private static class Person {
        int height;
        int count;

        public Person(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Person> dq = new ArrayDeque<>();
        long answer = 0L;

        for (int i = 0; i < n; i++) {
            int person = Integer.parseInt(br.readLine());
            Person now = new Person(person, 1);

            while (!dq.isEmpty() && dq.peekLast().height <= person) { //i=1부터 시작
                Person past = dq.pollLast();
                answer += past.count;

                if (past.height == person) {
                    now.count += past.count;
                }
            }

            if (!dq.isEmpty()) {
                answer++;
            }
            dq.addLast(now);
        }

        System.out.println(answer);
    }
}