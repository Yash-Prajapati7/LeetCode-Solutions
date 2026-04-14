Leetcode Question : [How Many Numbers Are Smaller Than the Current Number](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int counter = 0;
        int n = nums.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            counter = 0;
            for(int j = 0; j < n; j++) {
                if(j != i && nums[j] < nums[i]) {
                    counter++;
                }
            }

            result[i] = counter;
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
        int counter = 0;
        int n = nums.size();
        vector<int> result(n);

        for(int i = 0; i < n; i++) {
            counter = 0;
            for(int j = 0; j < n; j++) {
                if(j != i && nums[j] < nums[i]) {
                    counter++;
                }
            }

            result[i] = counter;
        }

        return result;
    }
};
```

## Method - 2 (Optimised)

### Java

```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] count = new int[101];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
        int n = nums.size();
        vector<int> count(101, 0);
        vector<int> result(n);

        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }

        return result;
    }
};
```
