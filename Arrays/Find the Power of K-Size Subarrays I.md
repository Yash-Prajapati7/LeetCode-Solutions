Leetcode Question : [Find the Power of K-Size Subarrays I](https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/)

## Approach 1 : Brute Force

### Java
```java
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] power = new int[n - k + 1];
        
        for(int i = 0; i <= (n - k); i++) {
            boolean isSorted = true;
            
            for(int j = i; j < (i + k - 1); j++) {
                if(nums[j + 1] != nums[j] + 1) {
                    isSorted = false;
                    break;
                }
            }

            power[i] = isSorted ? nums[i + k - 1] : -1;
        }

        return power;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> resultsArray(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> power(n - k + 1);

        for(int i = 0; i <= (n - k); i++) {
            bool isSorted = true;

            for(int j = i; j < (i + k - 1); j++) {
                if(nums[j + 1] != nums[j] + 1) {
                    isSorted = false;
                    break;
                }
            }

            power[i] = isSorted ? nums[i + k - 1] : -1;
        }

        return power;
    }
};
```

## Approach 2 : Using Sliding Window

### Java
```java
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] power = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(k + 1);

        for(int i = 0; i < n; i++) {
            if(!dq.isEmpty() && dq.peekFirst() < (i - k + 1)) {
                int trash = dq.pollFirst();
            }
            if(!dq.isEmpty() && nums[i] != nums[i - 1] + 1) {
                dq.clear();
            }

            dq.offerLast(i);

            if(i >= k - 1) {
                power[i - k + 1] = dq.size() == k ? nums[dq.peekLast()] : -1;
            }
        }
        return power;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> resultsArray(vector<int>& nums, int k) {
        if(k == 1) {
            return nums;
        }
        int n = nums.size();
        vector<int> power(n - k + 1);
        deque<int> dq(k + 1);

        for(int i = 0; i < n; i++) {
            if(!dq.empty() && dq.front() < (i - k + 1)) {
                dq.pop_front();
            }
            if(!dq.empty() && nums[i] != nums[i - 1] + 1) {
                dq.clear();
            }

            dq.push_back(i);

            if(i >= k - 1) {
                power[i - k + 1] = dq.size() == k ? nums[dq.back()] : -1;
            }
        }
        return power;
    }
};
```
