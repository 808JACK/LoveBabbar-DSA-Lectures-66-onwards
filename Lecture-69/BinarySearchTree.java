//this code is about insertation in BST and printing by Level order Traversal

public class BinarySearchTree{

  public static class Node{

    int data;
    Node left;
    Node right;

      Node(int d){
      this.data = d;
      this.right = null;
      this.left = null;
    }
}
public static Node takeInput(Node root){

    Scanner sc = new Scanner(System.in);

    while(true){
      int data = sc.nextInt();
      if(data == -1){
        break;
      }
      root = insertToBst(root,data);
    }
    sc.close();
    return root;
}

public static Node insertToBst(Node root,int d){

  if(root == null){
    root = new Node(d);
    return root;
  }
  if(d > root.data){

    root.right = insertToBst(root.right, d);
  }
  else if(d < root.data){

    root.left = insertToBst(root.left,d);
  }
  return root;
}
public static void printByLevelOrder(Node root){
      if(root == null){

        return;
      }
      Queue<Node>q = new LinkedList<>();
      q.add(root);

      while(!q.isEmpty()){

        Node current = q.poll();
        System.out.print(current.data +" ");

        if(current.left != null){

          q.add(current.left);
        }
        if(current.right !=  null){

          q.add(current.right);

        }
    }
}

public static void main(String[] args){

  Node root = null;
  root = takeInput(root);
  printByLevelOrder(root);
  
  }
}

