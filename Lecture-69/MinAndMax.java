import java.util.Scanner;

public class MinAndMax {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
      this.data = d;
      this.left = null;
      this.right = null;
    }
  }

  public static Node takeInput() {
    Scanner sc = new Scanner(System.in);
    Node root = null;
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

  public static Node insertToBst(Node root, int data) {
    if (root == null) {
      return new Node(data);
    }
    if (data > root.data) {
      root.right = insertToBst(root.right, data);
    } else if (data < root.data) {
      root.left = insertToBst(root.left, data);
    }
    return root;
  }

  // Method to find the minimum value in the BST
  public static Node minValue(Node root) {
    if (root == null) {
      return null;
    }

    Node temp = root;
    while (temp.left != null) {
      temp = temp.left;
    }
    return temp;
  }

  // Method to find the maximum value in the BST
  public static Node maxValue(Node root) {
    if (root == null) {
      return null;
    }

    Node temp = root;
    while (temp.right != null) {
      temp = temp.right;
    }
    return temp;
  }
}
