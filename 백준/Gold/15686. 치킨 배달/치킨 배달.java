import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class YX {
    int y;
    int x;

    public YX(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    private static int result = Integer.MAX_VALUE;
    private static int N, M;
    private static boolean[] checked;
    private static List<YX> houses, chickens;
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) { //house
                    houses.add(new YX(i, j));
                }
                if (x == 2) {
                    chickens.add(new YX(i, j));
                }
            }
        }
        checked = new boolean[chickens.size()];
        backTracking(0, 0);
        //출력
        System.out.println(result);
    }

    private static void backTracking(int start, int cnt) {
        if (M == cnt) {
            int x = 0;
            for (int i = 0; i < houses.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (checked[j]) {
                        int dist = Math.abs(houses.get(i).x - chickens.get(j).x)
                                + Math.abs(houses.get(i).y - chickens.get(j).y);
                        min = Math.min(min, dist);
                    }
                }
                x += min;
            }
            result = Math.min(result, x);
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            checked[i] = true;
            backTracking(i + 1, cnt + 1);
            checked[i] = false;
        }
    }
}