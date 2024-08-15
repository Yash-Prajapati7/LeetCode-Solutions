Leetcode Question : [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

### Java
```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the area with current left and right bars
            int width = right - left;
            int currentArea = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter bar
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
```

### C++
```cpp
class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the area with current left and right bars
            int width = right - left;
            int currentArea = min(height[left], height[right]) * width;
            maxArea = max(maxArea, currentArea);

            // Move the pointer pointing to the shorter bar
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
};
```
