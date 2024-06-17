// this code to delete the Node in BST
public static class Deletation {
  
  public static class Node{
  int data;
  Node left,right;
    
  Node(int d){

    this.data = d;
    this.right = this.left = null;
  }
}
public static Node takeInput(Node root){

  Scanner sc = new Scanner(System.in);
  while(true){
    
    int data  = sc.nextInt();
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
      root.right = insertToBst(root.right,d);
    }
    if(d < root.data){
      root.left = insertToBst(root.left,d);
    }
    return root;
  }
  
  public static Node deleteNode(Node root, int value){

    if(root == null){
      return root;
    }

    if(value < root.data){
      root.left = deleteNode(root.left , value);
    }
    else if(value > root.data){
      root.right = deleteNode(root.right,value);
    }
    else{

      //case 1: Node has no children 

      if(root.left == null && root.right == null){
        return null;
      }

      //case 2:Node has one child
      if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
      }

      // case 3: Node has two childrens

      // inorder pred
      root.data = maxValue(root.left);
      
      // Delete the in-order predecessor
      root.left = deleteNode(root.left,root.data);

    }

    return root;
}
public static int maxValue(Node root) {
        int maxval = root.data;
        while (root.right != null) {
            maxval = root.right.data;
            root = root.right;
        }
        return maxval;
}
