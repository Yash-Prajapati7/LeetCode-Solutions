Leetcode Question: [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)

### Java
```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> index = new HashMap<>();
        int n1 = nums1.length, n2 = nums2.length;
        int[] answer = new int[n1];

        for(int i = 0; i < n2; i++) {
            index.put(nums2[i], i);
        }

        for(int i = 0; i < n1; i++) {
            int j = index.get(nums1[i]);
            while(j < n2 && nums2[j] <= nums1[i]) {
                j++;
            }

            answer[i] = j != n2 ? nums2[j] : -1;
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
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> index;
        int n1 = nums1.size(), n2 = nums2.size();
        vector<int> answer(n1);

        for(int i = 0; i < n2; i++) {
            index[nums2[i]] = i;
        }

        for(int i = 0; i < n1; i++) {
            int j = index[nums1[i]];
            while(j < n2 && nums2[j] <= nums1[i]) {
                j++;
            }

            answer[i] = j != n2 ? nums2[j] : -1;
        }

        return answer;
    }
};
```
