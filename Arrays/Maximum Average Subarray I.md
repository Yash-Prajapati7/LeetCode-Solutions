Leetcode Question : [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)  

### Java  
```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double currentAvg = 0.0, max = 0.0;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        max = sum / k;

        for(int i = k; i < nums.length; i++) {
            sum += (nums[i] - nums[i - k]);
            currentAvg = sum / k;
            if(currentAvg > max) max = currentAvg;
        }

        return max;
    }
}
```  

### C++  
```cpp
class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        double sum = 0, currentAvg = 0.0, max = 0.0;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        max = sum / k;

        for(int i = k; i < nums.size(); i++) {
            sum += (nums[i] - nums[i - k]);
            currentAvg = sum / k;
            if(currentAvg > max) max = currentAvg;
        }

        return max;
    }
};
```
