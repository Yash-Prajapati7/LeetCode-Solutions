Leetcode Question : [Maximum Size of a Set After Removals](https://leetcode.com/problems/maximum-size-of-a-set-after-removals)

### Java
```java
class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        HashSet<Integer> common = new HashSet<>();

        for(int num : nums1) {
            s1.add(num);
        }

        for(int num : nums2) {
            s2.add(num);
            if(s1.contains(num)) {
                common.add(num);
            }
        }

        int n = nums1.length, n1 = s1.size(), n2 = s2.size(), c = common.size();
        int min = Math.min(n / 2, n1 - c) + Math.min(n / 2, n2 - c) + c;
        return Math.min(min, n);
    }
}
```

### C++
```cpp
class Solution {
public:
    int maximumSetSize(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> s1, s2, common;

        for(int num : nums1) {
            s1.insert(num);
        }

        for(int num : nums2) {
            s2.insert(num);
            if(s1.count(num)) {
                common.insert(num);
            }
        }

        int n = nums1.size(), n1 = s1.size(), n2 = s2.size(), c = common.size();
        int minSetSize = min(n / 2, n1 - c) + min(n / 2, n2 - c) + c;
        return min(minSetSize, n);
    }
};
```
