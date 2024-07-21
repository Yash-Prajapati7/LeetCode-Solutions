Leetcode Question : [Find Target Indices After Sorting Array](https://leetcode.com/problems/find-target-indices-after-sorting-array/)
### Java
```java
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                result.add(i);
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
    vector<int> targetIndices(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector<int> result;

        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == target) {
                result.push_back(i);
            }
        }

        return result;
    }
};
```
- Note : You can also solve this question using binary search's lower bound and upper bound. But looking at the constraints it is overkill. So I went with the linear search.
