import java.util.Scanner;

public class Deletion {

    public static class Node {
        int data;
        Node left, right;

        Node(int d) {
            this.data = d;
            this.right = this.left = null;
        }
    }

    public static Node takeInput(Node root) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int data = sc.nextInt();
            if (data == -1) {
                break;
            }
            root = insertToBst(root, data);
        }
        sc.close();
        return root;
    }

    public static Node insertToBst(Node root, int d) {
        if (root == null) {
            root = new Node(d);
            return root;
        }
        if (d > root.data) {
            root.right = insertToBst(root.right, d);
        } else if (d < root.data) {
            root.left = insertToBst(root.left, d);
        }
        return root;
    }

    public static Node deleteNode(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNode(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder predecessor (max in the left subtree)
            Node temp = maxValueNode(root.left);

            // Copy the inorder predecessor's content to this node
            root.data = temp.data;

            // Delete the inorder predecessor
            root.left = deleteNode(root.left, temp.data);
        }

        return root;
    }

    public static Node maxValueNode(Node root) {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public static void main(String[] args) {
        Node root = null;
        root = takeInput(root);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to delete: ");
        int value = sc.nextInt();
        root = deleteNode(root, value);
        sc.close();
    }
}
