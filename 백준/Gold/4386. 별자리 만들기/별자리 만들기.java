import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class XY {
    int idx;
    double x;
    double y;

    public XY(int idx, double x, double y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }
}
class XYW {
    XY xy1;
    XY xy2;
    double w;

    public XYW(XY xy1, XY xy2, double w) {
        this.xy1 = xy1;
        this.xy2 = xy2;
        this.w = w;
    }
}
public class Main {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        XY[] arr = new XY[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        /* 문제점
        * 1.이거 parent[] 어캐 설정해줘야히지? -> XY에 인덱스 추가
        * 2.소수점 계산
        * */
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            arr[i] = new XY(i, x, y);
        }
        PriorityQueue<XYW> pq = new PriorityQueue<>(new Comparator<XYW>() {
            @Override
            public int compare(XYW o1, XYW o2) {
                if (o1.w < o2.w) {
                    return -1;
                } else if (o1.w > o2.w) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.offer(new XYW(arr[i],arr[j]
                        ,Math.sqrt(Math.pow(arr[i].x-arr[j].x,2) + Math.pow(arr[i].y-arr[j].y,2))));
            }
        }
        double weight = 0.0;
        while (!pq.isEmpty()) {
            XYW now = pq.poll();
            if (find(now.xy1.idx) != find(now.xy2.idx)) {
                weight += now.w;
                union(now.xy1.idx, now.xy2.idx);
            }
        }

        System.out.printf("%.2f",weight);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }


}