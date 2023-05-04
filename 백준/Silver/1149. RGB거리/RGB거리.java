import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); //r
            arr[i][1] = Integer.parseInt(st.nextToken()); //g
            arr[i][2] = Integer.parseInt(st.nextToken()); //b

        }
        for (int i=1;i<n;i++) {
            arr[i][0] += Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0],arr[i-1][1]);

        }
        System.out.print(Math.min(Math.min(arr[n-1][0],arr[n-1][1]),arr[n-1][2]));

    }
}