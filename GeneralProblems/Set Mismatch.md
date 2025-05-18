Leetcode Question : [Set Mismatch](https://leetcode.com/problems/set-mismatch/)

## Method - 1: HashMap Count Approach

### Java

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int duplicate = -1, missing = -1;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            int count = countMap.getOrDefault(i, 0);
            if (count == 2) duplicate = i;
            if (count == 0) missing = i;
        }

        return new int[]{duplicate, missing};
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        unordered_map<int, int> countMap;
        int duplicate = -1, missing = -1;

        for (int num : nums) {
            countMap[num]++;
        }

        for (int i = 1; i <= nums.size(); i++) {
            int count = countMap[i];
            if (count == 2) duplicate = i;
            if (count == 0) missing = i;
        }

        return {duplicate, missing};
    }
};
```

---

## Method - 2: Math Formula Approach

### Java

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int actualSum = 0, actualSquareSum = 0;
        int expectedSum = n * (n + 1) / 2;
        int expectedSquareSum = n * (n + 1) * (2 * n + 1) / 6;

        for (int num : nums) {
            actualSum += num;
            actualSquareSum += num * num;
        }

        int diff = expectedSum - actualSum; // missing - duplicate
        int squareDiff = expectedSquareSum - actualSquareSum; // missing^2 - duplicate^2

        int sum = squareDiff / diff; // missing + duplicate

        int missing = (diff + sum) / 2;
        int duplicate = sum - missing;

        return new int[]{duplicate, missing};
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int n = nums.size();
        long long actualSum = 0, actualSquareSum = 0;
        long long expectedSum = 1LL * n * (n + 1) / 2;
        long long expectedSquareSum = 1LL * n * (n + 1) * (2 * n + 1) / 6;

        for (int num : nums) {
            actualSum += num;
            actualSquareSum += 1LL * num * num;
        }

        long long diff = expectedSum - actualSum; // missing - duplicate
        long long squareDiff = expectedSquareSum - actualSquareSum; // missing^2 - duplicate^2

        long long sum = squareDiff / diff; // missing + duplicate

        int missing = (diff + sum) / 2;
        int duplicate = sum - missing;

        return {duplicate, missing};
    }
};
```

---

## Method - 3: Marking Visited Elements (In-Place Negation)

### Java

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;

        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                dup = Math.abs(num);
            } else {
                nums[idx] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[]{dup, missing};
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int dup = -1, missing = -1;

        for (int num : nums) {
            int idx = abs(num) - 1;
            if (nums[idx] < 0) {
                dup = abs(num);
            } else {
                nums[idx] *= -1;
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return {dup, missing};
    }
};
```
