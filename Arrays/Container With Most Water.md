Leetcode Question : [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

## Approach - 1 (Brute Force)

### Java

```java
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = Integer.MIN_VALUE, currentArea = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(height[j] >= height[i]) {
                    currentArea = height[i] * (j - i);
                }
                else {
                    currentArea = height[j] * (j - i);
                }
                maxArea = currentArea > maxArea ? currentArea : maxArea;
            }
        }

        return maxArea;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int n = height.size();
        int maxArea = INT_MIN, currentArea = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(height[j] >= height[i]) {
                    currentArea = height[i] * (j - i);
                }
                else {
                    currentArea = height[j] * (j - i);
                }
                maxArea = currentArea > maxArea ? currentArea : maxArea;
            }
        }

        return maxArea;
    }
};
```

## Approach - 2 (Optimised)

### Java

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentArea = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(maxArea, currentArea);

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
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentArea = min(height[left], height[right]) * width;
            maxArea = max(maxArea, currentArea);

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
