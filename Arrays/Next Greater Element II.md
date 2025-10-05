Leetcode Question : [Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            boolean found = false;

            while(j != i) {
                if(nums[j] > nums[i]) {
                    answer[i] = nums[j];
                    found = true;
                    break;
                }
                j = (j + 1) % n;
            }

            if(!found) {
                answer[i] = -1;
            }
        }

        return answer;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> answer(n);

        for(int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            bool found = false;

            while(j != i) {
                if(nums[j] > nums[i]) {
                    answer[i] = nums[j];
                    found = true;
                    break;
                }
                j = (j + 1) % n;
            }

            if(!found) {
                answer[i] = -1;
            }
        }

        return answer;
    }
};
```

## Method - 2 (Monotonic Stack)

### Java

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int size = n << 1;

        for(int i = 0; i < n; i++) {
            answer[i] = -1;
        }

        int[] stack = new int[n];
        int top = -1;
        int num = 0, index = 0;

        for(int i = 0; i < size; i++) {
            num = nums[i % n];

            while(top >= 0 && num > nums[stack[top]]) {
                index = stack[top];
                answer[index] = num;
                top--;
            }

            if(i < n) {
                stack[++top] = i;
            }
        }

        return answer;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> answer(n, -1);
        int size = n << 1;
        vector<int> stack(n);
        int top = -1;
        int num = 0, index = 0;

        for(int i = 0; i < size; i++) {
            num = nums[i % n];

            while(top >= 0 && num > nums[stack[top]]) {
                index = stack[top];
                answer[index] = num;
                top--;
            }

            if(i < n) {
                stack[++top] = i;
            }
        }

        return answer;
    }
};
```
