# Leetcode Question : [Find Missing Elements](https://leetcode.com/problems/find-missing-elements/)

### Java

```java
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int number = nums[0];
        List<Integer> result = new ArrayList<>(100);
        int counter = 0;

        for (int i = nums[0]; i <= 100; i++) {
            if (nums[counter] != i) {
                result.add(i);
            } else {
                counter++;
                if (counter == nums.length) break;
            }
        }

        return result;
    }
}
```

### C++

```cpp
class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int number = nums[0];
        vector<int> result;
        result.reserve(100);
        int counter = 0;

        for (int i = nums[0]; i <= 100; i++) {
            if (nums[counter] != i) {
                result.push_back(i);
            } else {
                counter++;
                if (counter == nums.size()) break;
            }
        }

        return result;
    }
};
```
