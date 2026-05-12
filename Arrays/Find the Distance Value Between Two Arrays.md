Leetcode Question : [Find the Distance Value Between Two Arrays](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/)

## Approach - 1 (Brute Force)

### Java

```java
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        boolean incrementCount = true;

        for(int i = 0; i < arr1.length; i++) {
            incrementCount = true;
            
            for(int j = 0; j < arr2.length; j++) {
                if(Math.abs(arr1[i] - arr2[j]) <= d) {
                    incrementCount = false;
                    break;
                }
            }

            if(incrementCount) count++;
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
        int count = 0;
        bool incrementCount = true;

        for(int i = 0; i < arr1.size(); i++) {
            incrementCount = true;

            for(int j = 0; j < arr2.size(); j++) {
                if(abs(arr1[i] - arr2[j]) <= d) {
                    incrementCount = false;
                    break;
                }
            }

            if(incrementCount) count++;
        }

        return count;
    }
};
```

## Approach - 2 (Optimised)

### Java

```java
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for(int num : arr1) {
            int left = 0;
            int right = arr2.length - 1;
            boolean valid = true;

            while(left <= right) {
                int mid = left + (right - left) / 2;

                if(Math.abs(arr2[mid] - num) <= d) {
                    valid = false;
                    break;
                }
                else if(arr2[mid] < num) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            if(valid) count++;
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
        sort(arr2.begin(), arr2.end());
        int count = 0;

        for(int num : arr1) {
            int left = 0;
            int right = arr2.size() - 1;
            bool valid = true;

            while(left <= right) {
                int mid = left + (right - left) / 2;

                if(abs(arr2[mid] - num) <= d) {
                    valid = false;
                    break;
                }
                else if(arr2[mid] < num) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            if(valid) count++;
        }

        return count;
    }
};
```
