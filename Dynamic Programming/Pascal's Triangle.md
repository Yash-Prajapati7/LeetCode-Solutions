Leetcode Question : [Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)
```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(30);
        List<Integer> list = new ArrayList<>(30);
        list.add(1);
        result.add(list);

        if (numRows-- == 1) {
            return result;
        }

        for (int i = 1; i <= numRows; i++) {
            List<Integer> list1 = new ArrayList<>();
            list = result.get(i - 1);
            int k = 0;
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list1.add(1);
                } else {
                    list1.add(list.get(k) + list.get(k + 1));
                    k++;
                }

            }
            result.add(list1);
        }
        return result;
    }
}
```
For Maths based approach [visit here]()
