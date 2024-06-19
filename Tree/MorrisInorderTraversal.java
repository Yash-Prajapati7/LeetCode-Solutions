class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTree {
    public static void morrisTraversal(TreeNode root) {
        TreeNode current, pre;
        
        if (root == null) {
            return;
        }
        
        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                // Find the inorder predecessor of current
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                // Make current as the right child of its inorder predecessor
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    // Revert the changes made in the 'if' part to restore the original tree
                    // i.e., fix the right child of predecessor
                    pre.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }

    public static void main(String args[]) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Inorder traversal using Morris Traversal:");
        morrisTraversal(root);
    }
}
