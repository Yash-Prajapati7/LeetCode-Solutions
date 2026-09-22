Leetcode Question : [Create Target Array in the Given Order](https://leetcode.com/problems/create-target-array-in-the-given-order/)

### Java

```java id="7x4mqp"
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> target = new ArrayList<>(index.length);

        for (int i = 0; i < index.length; i++) {
            target.add(index[i], nums[i]);
        }

        return target.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

### C++

```cpp id="k9v2ws"
using namespace std;

class Solution {
public:
    vector<int> createTargetArray(vector<int>& nums, vector<int>& index) {
        vector<int> target;

        for (int i = 0; i < index.size(); i++) {
            target.insert(target.begin() + index[i], nums[i]);
        }

        return target;
    }
};
```
