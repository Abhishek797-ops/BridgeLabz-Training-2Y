class CharNode {
    char data;
    CharNode left;
    CharNode right;

    public CharNode(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class CharTree {

    public static void preOrder(CharNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(CharNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(CharNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        CharNode root = new CharNode('A');
        root.left = new CharNode('B');
        root.right = new CharNode('C');
        root.left.left = new CharNode('D');
        root.left.right = new CharNode('E');
        root.right.left = new CharNode('G');
        root.right.right = new CharNode('H');
        root.left.right.left = new CharNode('I');
        root.left.right.right = new CharNode('J');
        root.right.left.left = new CharNode('K');

        System.out.println("Preorder Traversal:");
        preOrder(root);

        System.out.println("\nInorder Traversal:");
        inOrder(root);

        System.out.println("\nPostorder Traversal:");
        postOrder(root);
    }
}