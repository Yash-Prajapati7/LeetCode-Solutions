Leetcode Question : [Majority Element II](https://leetcode.com/problems/majority-element-ii/description/)
### Java
```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = -1;
        int count1 = 0;
        int element2 = -1;
        int count2 = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(count1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                count2 = 1;
            }
            else if(nums[i] == element1) {
                count1++;
            }
            else if(nums[i] == element2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for(int num : nums) {
            if(num == element1) {
                count1++;
            }
            else if(num == element2) {
                count2++;
            }
        }

        List<Integer> answer = new ArrayList<>();
        if(count1 > n / 3) {
            answer.add(element1);
        }
        if(count2 > n / 3) {
            answer.add(element2);
        }

        return answer;
    }
}
```
### C++
```cpp
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int element1 = -1, count1 = 0;
        int element2 = -1, count2 = 0;
        int n = nums.size();

        for(int i = 0; i < n; i++) {
            if(count1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                count1 = 1;
            } else if(count2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                count2 = 1;
            } else if(nums[i] == element1) {
                count1++;
            } else if(nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for(int num : nums) {
            if(num == element1) {
                count1++;
            } else if(num == element2) {
                count2++;
            }
        }

        vector<int> answer;
        if(count1 > n / 3) {
            answer.push_back(element1);
        }
        if(count2 > n / 3) {
            answer.push_back(element2);
        }

        return answer;
    }
};
```
