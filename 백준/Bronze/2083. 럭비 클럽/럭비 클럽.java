import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    //백준
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if (name.equals("#") && age == 0 && weight == 0) {
				break;
			}

			if (age > 17 || weight >= 80) {
				sb.append(name + " Senior").append("\n");
			} else {
				sb.append(name + " Junior").append("\n");
			}

		}
        System.out.print(sb);
    }
}