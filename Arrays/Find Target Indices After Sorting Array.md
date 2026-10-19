Leetcode Question : [Find Target Indices After Sorting Array](https://leetcode.com/problems/find-target-indices-after-sorting-array/?utm_source=chatgpt.com)

### Java

```
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int numLessThanTarget = 0, targetCount = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < target) {
                numLessThanTarget++;
            } else if (nums[i] == target) {
                targetCount++;
            }
        }

        List<Integer> result = new ArrayList<>(targetCount);
        for (int i = numLessThanTarget; i < numLessThanTarget + targetCount; i++) {
            result.add(i);
        }

        return result;
    }
}
```

### C++

```
using namespace std;

class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        int numLessThanTarget = 0, targetCount = 0, n = nums.size();

        for (int i = 0; i < n; i++) {
            if (nums[i] < target) {
                numLessThanTarget++;
            } else if (nums[i] == target) {
                targetCount++;
            }
        }

        vector<int> result;
        result.reserve(targetCount);

        for (int i = numLessThanTarget; i < numLessThanTarget + targetCount; i++) {
            result.push_back(i);
        }

        return result;
    }
};
```
