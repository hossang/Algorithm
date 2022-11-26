import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int find(int x) {
        if (arr[x] == x) {
            return x;
        } else {
            return arr[x] = find(arr[x]);
        }
    }

    public static void union(int x, int y) {
        if (x < y) {
            arr[y] = x;
        } else {
            arr[x] = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(br.readLine());
            StringTokenizer st;
            Map<String, Integer> map = new HashMap<>();
            ArrayList<Integer> al = new ArrayList<>();
            int idx = 0;
            for (int j = 0; j < f; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    String str = st.nextToken();
                    if (!map.containsKey(str)) {
                        map.put(str, idx++);
                    }
                    al.add(map.get(str));
                }
            }
            arr = new int[map.size()];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = j;
            }
            idx = 0;
            Map<Integer, Integer> mii = new HashMap<>();
            for (int j = 0; j < al.size(); j += 2) {
                int x = al.get(idx++);
                int y = al.get(idx++);
                int findx = find(x);
                int findy = find(y);
                int getx = -1;
                int gety = -1;
                if (!mii.containsKey(findx)) {
                    mii.put(findx, mii.getOrDefault(findx, 1));
                }
                if (!mii.containsKey(findy)) {
                    mii.put(findy, mii.getOrDefault(findy, 1));
                }
                getx = mii.get(findx);
                gety = mii.get(findy);

                if (findx > findy) {
                    union(findx, findy);
                    mii.put(findy, getx + gety);
                    mii.put(findx, 0);
                    sb.append(mii.get(findy)).append("\n");
                } else if (findx < findy) {
                    union(findx, findy);
                    mii.put(findx, getx + gety);
                    mii.put(findy, 0);
                    sb.append(mii.get(findx)).append("\n");
                } else {
                    sb.append(mii.get(findx)).append("\n");
                }
            }
            map.clear();
            al.clear();
            mii.clear();

        }
        System.out.print(sb);
    }
}
