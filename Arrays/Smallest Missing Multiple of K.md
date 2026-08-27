### Leetcode Question : [Smallest Missing Multiple of K](https://leetcode.com/problems/smallest-missing-multiple-of-k/)

### Java

```java
class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>(nums.length);

        // Store all elements in the HashSet
        for (int num : nums) {
            set.add(num);
        }

        // Check multiples of k
        int multiple = k;

        while (set.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        unordered_set<int> set;

        // Store all elements in the HashSet
        for (int num : nums) {
            set.insert(num);
        }

        // Check multiples of k
        int multiple = k;

        while (set.count(multiple)) {
            multiple += k;
        }

        return multiple;
    }
};
```
