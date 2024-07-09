```java
public class CeilAndFloorInBST {
    public int ceil(TreeNode root, int key) {
        int ceil = 0;
        while(root != null) {
            if(root.val == key) {
                return root.val;
            }
            if(root.val > key) {
                ceil = root.val;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return ceil;
    }

    public int floor(TreeNode root, int key) {
        int floor = 0;
        while(root != null) {
            if(root.val == key) {
                return root.val;
            }
            if(root.val > key) {
                floor = root.val;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return floor;
    }
}

```
