Leetcode Question : [Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)
```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(30);
        for(int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            int sum = 1;

            for(int j = 0; j <= i; j++) {
                temp.add(sum);
                sum = sum * (i - j) / (j + 1);
            }

            result.add(temp);
        }
        return result;
    }
}
```
For Dynamic Programming approach [visit here](https://github.com/Yash-Prajapati7/LeetCode-Solutions/blob/main/Dynamic%20Programming/Pascal's%20Triangle.md)
