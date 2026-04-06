class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BasicTrees{

    void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

     void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

     void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.right = new Node(20);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        root.right.right = new Node(50);
        root.right.left = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
        root.right.left.right = new Node(90);

            BasicTrees tree = new BasicTrees();
            System.out.print("Preorder Traversal: ");
            tree.preOrder(root);
            System.out.println();
            System.out.print("Inorder Traversal: ");
            tree.inOrder(root);
            System.out.println();
            System.out.print("Postorder Traversal: ");
            tree.postOrder(root);

        
    }
}