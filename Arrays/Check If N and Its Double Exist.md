Leetcode Question : [Check If N and Its Double Exist](https://leetcode.com/problems/check-if-n-and-its-double-exist/)

### Java
```java
class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>(n);
        for(int i = 0; i < n; i++) {
            hm.put(arr[i], i);
        }

        for(int i = 0; i < n; i++) {
            int doubled = arr[i] << 1;
            int divided = arr[i] >> 1;
            if(hm.containsKey(doubled) && hm.get(doubled) != i) {
                return true;
            }
            else if(arr[i] % 2 == 0) {
                if(hm.containsKey(divided) && hm.get(divided) != i) {
                    return true;
                }
            }
        }

        return false;
    }
}
```

### C++
```cpp
class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        int n = arr.size();
        unordered_map<int, int> hm;
        for(int i = 0; i < n; i++) {
            hm[arr[i]] = i;
        }

        for(int i = 0; i < n; i++) {
            int doubled = arr[i] << 1;
            int divided = arr[i] >> 1;
            if(hm.count(doubled) && hm[doubled] != i) {
                return true;
            }
            else if(arr[i] % 2 == 0) {
                if(hm.count(divided) && hm[divided] != i) {
                    return true;
                }
            }
        }

        return false;
    }
};
```
