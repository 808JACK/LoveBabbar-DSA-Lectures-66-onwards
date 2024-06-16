
public class MorrisTraversalPreorder {

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

    static class BinaryTree {
        Node root;

        void morrisTraversalPreorder() {
            morrisTraversalPreorder(root);
        }

        void morrisTraversalPreorder(Node root) {
            while (root != null) {
                if (root.left == null) {
                    System.out.print(root.data + " ");
                    root = root.right;
                } else {
                    /* this thing is to find predecessor*/
                    Node current = root.left;
                    while (current.right != null && current.right != root) {
                        current = current.right;
                    }

                    if (current.right == root) {
                        current.right = null;
                        root = root.right;
                    } else {
                        System.out.print(root.data + " ");
                        current.right = root;
                        root = root.left;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MorrisTraversalPreorder morrisTraversalPreorder = new MorrisTraversalPreorder();
        BinaryTree tree = new BinaryTree();
        
        //u guys can do by writing the method (optional)
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        System.out.println("Morris Preorder Traversal:");
        tree.morrisTraversalPreorder();
        System.out.println();
    }
}
