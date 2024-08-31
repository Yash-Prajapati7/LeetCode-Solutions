Leetcode Question : [Make Array Zero by Subtracting Equal Amounts](https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/)

### Method - 1
```java
class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int prev = -1;
        int operations = 0;
        for(int num : nums) {
            if(num == 0 || prev == num) {
                continue;
            }
            else {
                prev = num;
                operations++;
            }
        }
        return operations;
    }
}
```

### Method - 2
```java
class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> uniques = new HashSet<>();
        for(int num : nums) {
            if(num != 0) {
                uniques.add(num);
            }
        }  
        return uniques.size();
    }
}
```
