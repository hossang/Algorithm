import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }

}

public class Main {
    private static class Tree {
        Node root;

        private void search(Node root, char parent, char left, char right) {
            if (root == null) {
                return;
            }
            if (root.data == parent) {
                if (left != '.') {
                    root.left = new Node(left);

                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                search(root.left, parent, left, right);
                search(root.right, parent, left, right);
            }
        }

        public void add(char parent, char left, char right) {
            if (root == null) {
                root = new Node(parent);
                if (left != '.') {
                    root.left = new Node(left);

                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                search(root, parent, left, right);
            }
        }

        public void preorder(Node root) {
            System.out.print(root.data);
            if (root.left != null) {
                preorder(root.left);
            }
            if (root.right != null) {
                preorder(root.right);
            }
        }

        public void inorder(Node root) {
            if (root.left != null) {
                inorder(root.left);
            }
            System.out.print(root.data);
            if (root.right != null) {
                inorder(root.right);
            }
        }

        public void postorder(Node root) {
            if (root.left != null) {
                postorder(root.left);
            }
            if (root.right != null) {
                postorder(root.right);
            }
            System.out.print(root.data);
        }
    }

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.add(parent, left, right);
        }
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}