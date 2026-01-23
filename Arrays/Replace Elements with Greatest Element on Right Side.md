LeetCode Question : [Replace Elements with Greatest Element on Right Side](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side)

### Java

```java
class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        
        for(int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = max < temp ? temp : max;
        }

        return arr;
    }
}
```

### C++

```cpp
class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        int max = -1;
        
        for (int i = arr.size() - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = max < temp ? temp : max;
        }
        
        return arr;
    }
};
```
