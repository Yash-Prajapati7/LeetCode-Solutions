Leetcode Question : [Count Complete Subarrays in an Array](https://leetcode.com/problems/count-complete-subarrays-in-an-array/)

## Method - 1 (Brute Force)

### Java
```java
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        Set<Integer> distincts = new HashSet<>();
        for(int num : nums) distincts.add(num);
        int distinct = distincts.size();
        int result = 0;

        for(int i = 0; i < n; i++) {
            distincts = new HashSet<>();
            for(int j = i; j < n; j++) {
                distincts.add(nums[j]);
                if(distincts.size() == distinct) {
                    result += (n - j);
                    break;
                }
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
    int countCompleteSubarrays(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return 1;

        set<int> distincts(nums.begin(), nums.end());
        int distinct = distincts.size();
        int result = 0;

        for(int i = 0; i < n; i++) {
            set<int> temp;
            for(int j = i; j < n; j++) {
                temp.insert(nums[j]);
                if(temp.size() == distinct) {
                    result += (n - j);
                    break;
                }
            }
        }

        return result;
    }
};
```

## Method - 2 (Optimized)

### Java
```java
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int res = 0;
        int n = nums.length;
        int right = 0;

        Set<Integer> distinctElements = new HashSet<>();
        for (int num : nums) {
            distinctElements.add(num);
        }
        int totalDistinct = distinctElements.size();

        Map<Integer, Integer> freq = new HashMap<>();

        for (int left = 0; left < n; left++) {
            if (left > 0) {
                int remove = nums[left - 1];
                freq.put(remove, freq.get(remove) - 1);
                if (freq.get(remove) == 0) {
                    freq.remove(remove);
                }
            }

            while (right < n && freq.size() < totalDistinct) {
                int add = nums[right];
                freq.put(add, freq.getOrDefault(add, 0) + 1);
                right++;
            }

            if (freq.size() == totalDistinct) {
                res += (n - right + 1);
            }
        }

        return res;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countCompleteSubarrays(vector<int>& nums) {
        int res = 0;
        int n = nums.size();
        int right = 0;

        set<int> distinctElements(nums.begin(), nums.end());
        int totalDistinct = distinctElements.size();

        unordered_map<int, int> freq;

        for(int left = 0; left < n; left++) {
            if(left > 0) {
                int remove = nums[left - 1];
                freq[remove]--;
                if(freq[remove] == 0) {
                    freq.erase(remove);
                }
            }

            while(right < n && freq.size() < totalDistinct) {
                int add = nums[right];
                freq[add]++;
                right++;
            }

            if(freq.size() == totalDistinct) {
                res += (n - right + 1);
            }
        }

        return res;
    }
};
```
