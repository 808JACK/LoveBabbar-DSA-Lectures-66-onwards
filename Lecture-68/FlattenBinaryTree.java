
static class BinaryTree {
        Node root;

        public void flatten(Node root) {
            if (root == null) {
                return;
            }

            Node current = root;
            while (current != null) {
                if (current.left != null) {
                    // Find the rightmost node in the left subtree
                    Node rightmost = current.left;
                    while (rightmost.right != null) {
                        rightmost = rightmost.right;
                    }
                    // Reconnect the rightmost node of the left subtree to the right subtree
                    rightmost.right = current.right;
                    // Move the left subtree to the right
                    current.right = current.left;
                    current.left = null;
                }
                // Move to the next node
                current = current.right;
            }
        }

        public void flattenTree() {
            flatten(root);
        }

        //  method to print the flattened tree
        public void printFlattenedTree() {
            Node current = root;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.right;
            }
            System.out.println();
        }
    }
