import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
public class Main {
    private static class Tree {
        Node root;
        //나 궁금한게 추가로 데이터들어오면서 이거 노드 위치 바뀔 수 있는데, 그런거까지 고민해서 짜야하나?
        //-> 그정도까진 아닌듯 전위순회 한 결과를 입력으로 주니까
        //일단 대충 짜
        public void add(int data) {
            if (root == null) {
                root = new Node(data);
            } else {
                if (root.data > data) {
                    if (root.left == null) {
                        root.left = new Node(data);
                    } else {
                        add(root.left, data);
                    }
                } else if (root.data < data) {
                    if (root.right == null) {
                        root.right = new Node(data);
                    } else {
                        add(root.right, data);
                    }
                }
            }
        }
        public void add(Node node, int data) {
            if (node.data > data) {
                if (node.left == null) {
                    node.left = new Node(data);
                } else {
                    add(node.left, data);
                }
            } else if (node.data < data) {
                if (node.data < data) {
                    if (node.right == null) {
                        node.right = new Node(data);
                    } else {
                        add(node.right, data);
                    }
                }
            }
        }
        public void postorder(Node node) {
            if (node.left != null) {
                postorder(node.left);
            }
            if (node.right != null) {
                postorder(node.right);
            }
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();
        String str = "";
        while ((str = br.readLine()) != null) {
            tree.add(Integer.parseInt(str));
        }
        tree.postorder(tree.root);
    }
}