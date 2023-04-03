import java.io.*;
import java.util.*;

class Node {
    String value;
    Map<String, Node> child;

    public Node() {
        this.value = null;
        this.child = new TreeMap<>();
    }

    public Node(String value) {
        this.value = value;
        this.child = new TreeMap<>();
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Node root = new Node();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            Node node = root;
            for (int j = 0; j < k; j++) {
                String str = st.nextToken();

                if (!node.child.containsKey(str)) {
                    node.child.put(str, new Node(str));
                }

                node = node.child.get(str);
            }
        }

        dfs(root, 0);

        System.out.print(sb);
    }

    static void dfs(Node node, int depth) {
        for (String key : node.child.keySet()) {
            for (int i = 0; i < depth; i++) {
                sb.append("--");
            }
            sb.append(key).append("\n");
            dfs(node.child.get(key), depth + 1);
        }
    }
}
