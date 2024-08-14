Leetcode Question : [Sum of Unique Elements](https://leetcode.com/problems/sum-of-unique-elements/)

### Java
```java
class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for(int num : nums) {
            if(map.get(num) == 1) {
                sum += num;
            }
        }
        
        return sum;
    }
}
```

### C++
```cpp
class Solution {
public:
    int sumOfUnique(vector<int>& nums) {
        unordered_map<int, int> map;
        for(int num : nums) {
            map[num] = map[num] + 1;
        }

        int sum = 0;
        for(int num : nums) {
            if(map[num] == 1) {
                sum += num;
            }
        }
        
        return sum;
    }
};
```
