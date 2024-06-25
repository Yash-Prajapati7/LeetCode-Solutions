Leetcode Question : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
## Method - 1 Using Stack
```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.offer(root);

        // Flag to keep track of the direction of traversal
        boolean rightToLeft = false;

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if(temp != null) {
                    if(rightToLeft) {
                        s.push(temp.val);
                    }
                    else {
                        level.add(temp.val);
                    }
                    // Offer the left child to the queue if it exists
                    if(temp.left != null) {
                        q.offer(temp.left);
                    }
                    // Offer the right child to the queue if it exists
                    if(temp.right != null) {
                        q.offer(temp.right);
                    }
                }
            }
            // Adding back elements from the stack to the list
            if(rightToLeft) {
                while(!s.isEmpty()){
                    level.add(s.pop());
                }
            }
            result.add(level);
            rightToLeft = !rightToLeft;
        }
        return result;
    }
}
```

## Method - 2 Without using Stack
```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        // Flag to keep track of the direction of traversal
        boolean leftToRight = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if(temp != null) {
                    if(leftToRight) {
                        level.add(temp.val);
                    }
                    else {
                        level.add(0, temp.val);
                    }
                    
                    // Offer the left child to the queue if it exists
                    if(temp.left != null) {
                        q.offer(temp.left);
                    }
                    // Offer the right child to the queue if it exists
                    if(temp.right != null) {
                        q.offer(temp.right);
                    }
                }
            }
            // change the direction
            leftToRight = !leftToRight;
            result.add(level);
        }
        return result;
    }
}
```
----
Another approach you can try it for yourself is that when the leftToRight variable is false(or rightToLeft is true) send the list 'level'
to a method which reverses it and returns the reversed list.
```java
ArrayList<Integer> reverse (ArrayList<Integer> arr) {
  int size = arr.size();
  for(int i = 0; i < size/2; i++) {
    int temp = arr.get(i);
    arr.set(i, arr.get(size - 1 - i));
    arr.set((size - 1 - i), temp);
  }
  return arr;
}
```
Add this reversed list into the result.
