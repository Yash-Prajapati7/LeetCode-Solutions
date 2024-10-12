Leetcode Question: [H-Index](https://leetcode.com/problems/h-index/)

### Java
```java
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length, h = 0;
        for(int i = 0; i < n; i++) {
            h = n - i;
            if(citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
```

### C++
```cpp
class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end());
        int n = citations.size(), h = 0;
        for(int i = 0; i < n; i++) {
            h = n - i;
            if(citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
};
```
