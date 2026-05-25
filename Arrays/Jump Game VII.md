Leetcode Question : [Jump Game VII](https://leetcode.com/problems/jump-game-vii/)

## Explanation

This approach uses **Dynamic Programming + Prefix Sum Optimization**. 

We define: 
`func[i]` to represent whether index `i` is reachable from index `0`.

If:

```java
s.charAt(i) == '1'
```

then index `i` cannot be visited.

For every index `i`, we need to check whether there exists a previously reachable index `j` such that:

```text
i - maxJump <= j <= i - minJump
```

Instead of iterating through the whole range every time, we use a **prefix sum array** to quickly determine whether any reachable index exists in that interval.

The prefix sum array stores:

```text
prefixSum[i] = func[0] + func[1] + ... + func[i]
```

Using this, range queries can be answered in O(1):

```text
sum(left -> right)
```

which is computed as:

```java
prefixSum[right] - prefixSum[left - 1]
```

If this value is greater than `0`, then at least one valid reachable index exists, so the current index is also reachable.

This reduces the overall complexity from O(n²) to O(n).

### Java

```java
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] func = new int[n];
        int[] prefixSum = new int[n];
        int left = 0, right = 0, total = 0;

        func[0] = 1;

        for(int i = 0; i < minJump; i++) {
            prefixSum[i] = 1;
        }

        for(int i = minJump; i < n; i++) {
            left = i - maxJump;
            right = i - minJump;

            if(s.charAt(i) == '0') {
                total = prefixSum[right] - ((left <= 0) ? 0 : prefixSum[left - 1]);
                func[i] = total != 0 ? 1 : 0;
            }

            prefixSum[i] = prefixSum[i - 1] + func[i];
        }

        return func[n - 1] == 1;
    }
}
```

### C++

```cpp
class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        int n = s.length();
        vector<int> func(n);
        vector<int> prefixSum(n);

        int left = 0, right = 0, total = 0;

        func[0] = 1;

        for(int i = 0; i < minJump; i++) {
            prefixSum[i] = 1;
        }

        for(int i = minJump; i < n; i++) {
            left = i - maxJump;
            right = i - minJump;

            if(s[i] == '0') {
                total = prefixSum[right] - ((left <= 0) ? 0 : prefixSum[left - 1]);
                func[i] = total != 0 ? 1 : 0;
            }

            prefixSum[i] = prefixSum[i - 1] + func[i];
        }

        return func[n - 1] == 1;
    }
};
```
