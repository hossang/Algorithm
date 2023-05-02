import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    Character c;
    SortedMap<Character, Node> child;

    public Node() {
        c = null;
        child = new TreeMap<>();
    }

    public Node(Character c) {
        this.c = c;
        child = new TreeMap<>();
    }
}

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        Node root = new Node();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) != 1) {
                sb.append(s).append(map.get(s)).append("\n");
                continue;
            }
            Node trie = root;
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!trie.child.containsKey(c)) {
                    trie.child.put(c, new Node(c));
                    if (flag) {
                        dfs(root ,s, 0);
                        flag = false;
                    }
                }
                trie = trie.child.get(c);
            }
            if (flag) {
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(Node now, String s, int i) {
        if (now.child.size() == 0) {
            sb.append("\n");
            return;
        }
        sb.append(s.charAt(i));
        dfs(now.child.get(s.charAt(i)), s, i + 1);
    }
}
