public class TreeTraversals {
    public static void preorder (TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }
    public static void inorder (TreeNode node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    public static void postorder (TreeNode node) {
        if(node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(5);

        preorder(rootNode);
        System.out.println();
        inorder(rootNode);
        System.out.println();
        postorder(rootNode);
    }
}
