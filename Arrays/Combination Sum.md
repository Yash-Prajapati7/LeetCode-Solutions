Leetcode Question : [Combination Sum](https://leetcode.com/problems/combination-sum/)
### Java
```java
class Solution {
    private void getCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> memory) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(memory));
            }
            return;
        }

        if (arr[index] <= target) {
            memory.add(arr[index]);
            getCombinations(index, arr, target - arr[index], ans, memory);
            memory.remove(memory.size() - 1);
        }
        getCombinations(index + 1, arr, target, ans, memory);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        getCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
```

### C++
```cpp
#include <vector>
using namespace std;

class Solution {
private:
    void getCombinations(int index, vector<int>& arr, int target, vector<vector<int>>& ans, vector<int>& memory) {
        if (index == arr.size()) {
            if (target == 0) {
                ans.push_back(memory);
            }
            return;
        }

        if (arr[index] <= target) {
            memory.push_back(arr[index]);
            getCombinations(index, arr, target - arr[index], ans, memory);
            memory.pop_back();
        }
        getCombinations(index + 1, arr, target, ans, memory);
    }

public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> memory;
        getCombinations(0, candidates, target, ans, memory);
        return ans;
    }
};
```
