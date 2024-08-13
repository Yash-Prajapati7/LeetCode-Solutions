Leetcode Question : [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

### Java
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[] { left + 1, right + 1 };
            }
            else if(numbers[left] + numbers[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return new int[] { -1, -1 };
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int left = 0;
        int right = numbers.size() - 1;

        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return { left + 1, right + 1 };
            }
            else if(numbers[left] + numbers[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return { -1, -1 };
    }
};
```
