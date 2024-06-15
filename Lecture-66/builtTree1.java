//creating tree from inorder and postorder
import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    static int index;

    public static Node solve(int[] in, int[] post, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd) {
            return null;
        }

        int element = post[index--];
        Node root = new Node(element);
        int position = inMap.get(element);

        root.right = solve(in, post, position + 1, inEnd, inMap);
        root.left = solve(in, post, inStart, position - 1, inMap);

        return root;
    }

    public static Node buildTree(int[] in, int[] post) {
        index = post.length - 1; 
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        return solve(in, post, 0, in.length - 1, inMap);
    }

    
    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        int in[] = {9, 3, 15, 20, 7};
        int post[] = {9, 15, 7, 20, 3};

        Node root = buildTree(in, post);

        
        printInorder(root);
    }
}

