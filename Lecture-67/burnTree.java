//This is the code is to Burn the tree 
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;              

// To create parent node mapping and returning target node
Node createParentMap(Node root, int target, Map<Node, Node> nodeToParent) {
    Node result = null;
    Queue<Node> q = new LinkedList<>(); 
    q.add(root);
    nodeToParent.put(root, null);

    while (!q.isEmpty()) {
        Node front = q.poll();

        if (front.data == target) {
            result = front;
        }

        if (front.left != null) {
            nodeToParent.put(front.left, front);
            q.add(front.left);
        }
        if (front.right != null) {
            nodeToParent.put(front.right, front);
            q.add(front.right);
        }
    }
    return result;    
}

int burnTree(Node root, Map<Node, Node> nodeToParent) {
    Map<Node, Boolean> visited = new HashMap<>();
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    visited.put(root, true);
    int ans = 0;

    while (!q.isEmpty()) {
        boolean flag = false;
        int size = q.size();

        for (int i = 0; i < size; i++) {
            Node front = q.poll();

            if (front.left != null && !visited.getOrDefault(front.left, false)) {
                flag = true;
                q.add(front.left);
                visited.put(front.left, true);
            }
            if (front.right != null && !visited.getOrDefault(front.right, false)) {
                flag = true;
                q.add(front.right);
                visited.put(front.right, true);
            }
            Node parent = nodeToParent.get(front);
            if (parent != null && !visited.getOrDefault(parent, false)) {
                flag = true;
                q.add(parent);
                visited.put(parent, true);
            }
        }
        if (flag) {
            ans++;
        }
    }
    return ans;
}


