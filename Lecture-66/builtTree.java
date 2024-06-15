//creating tree from inorder and preorder
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
    static int index = 0;

    public static Node solve(int pre[], int in[], int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (index >= pre.length || inStart > inEnd) {
            return null;
        }

        int element = pre[index++];
        Node root = new Node(element);
        int position = inMap.get(element);

        root.left = solve(pre, in, inStart, position - 1, inMap);
        root.right = solve(pre, in, position + 1, inEnd, inMap);

        return root;
    }

    public static Node buildTree(int[] pre, int[] in) {
        index = 0;  // Reset the index before building the tree
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        return solve(pre, in, 0, in.length - 1, inMap);
    }

    // Helper function to print the tree in inorder fashion for testing
    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        int pre[] = {3, 9, 20, 15, 7};
        int in[] = {9, 3, 15, 20, 7};

        Node root = buildTree(pre, in);

        // Print the inorder traversal of the constructed tree
        printInorder(root);
    }
}

