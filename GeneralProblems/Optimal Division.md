Leetcode Question : [Optimal Division](https://leetcode.com/problems/optimal-division/)

```java
class Solution {
  public String optimalDivision(int[] nums) {
    StringBuilder sb = new StringBuilder(nums[0] + "");

    if (nums.length == 1) return sb.toString();
    if (nums.length == 2) return sb.append('/').append(nums[1]).toString();

    sb.append("/(").append(nums[1]);
    for (int i = 2; i < nums.length; ++i) {
        sb.append('/').append(nums[i]);
    }
      
    sb.append(')');
    return sb.toString();
  }
}
```

### Note - The Optimal solution will always be "nums[0] / (nums[1] / .... / nums[n - 1])"
