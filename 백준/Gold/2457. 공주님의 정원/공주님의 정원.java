import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Flower{
    int start;
    int end;

    public Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];
        //3.1 ~ 11.30
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int start = sm * 100 + sd;
            int end = em * 100 + ed;
            flowers[i] = new Flower(start, end);
        }

        Arrays.sort(flowers, (o1,o2) -> { //시작일 빠르면서 늦게 지는 거 선택
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            }
            return o1.start - o2.start;
        });

        int startDate = 301;
        int endDate = 1201;
        int max = 0;
        int idx = 0;
        int result = 0;

        while (startDate < endDate) {
            boolean flag = false;

            for (int i = idx; i < N; i++) {
                if (flowers[i].start > startDate) {
                    break;
                }

                if (max < flowers[i].end) {
                    flag = true;
                    max = flowers[i].end;
                    idx = i + 1;
                }

            }
            if (flag) {
                startDate = max;
                result++;
                continue;
            }
            break;
        }
        if (max < endDate) {
            System.out.println(0);
            return;
        }
        System.out.println(result);
    }
}
