Leetcode Question: [Check If Array Pairs Are Divisible by k](https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/)

## Method - 1 (Brute Force)

### Java
```java
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int count = 0;
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if((arr[i] + arr[j]) % k == 0) {
                    count++;
                }
                if(count == n / 2) {
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
    bool canArrange(vector<int>& arr, int k) {
        int count = 0;
        int n = arr.size();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if((arr[i] + arr[j]) % k == 0) {
                    count++;
                }
                if(count == n / 2) {
                    return true;
                }
            }
        }
        return false;
    }
};
```

## Method - 2 (Optimized Approach)

### Java
```java
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for(int i = 0; i < arr.length; i++) {
            int index = ((arr[i] % k) + k) % k;
            freq[index]++;
        }
        
        if(freq[0] % 2 != 0) {
            return false;
        }
        for(int i = 1; i <= k / 2; i++) {
            if(freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }
}
```

### C++
```cpp
class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        vector<int> freq(k, 0);
        for(int i = 0; i < arr.size(); i++) {
            int index = ((arr[i] % k) + k) % k;
            freq[index]++;
        }
        
        if(freq[0] % 2 != 0) {
            return false;
        }
        for(int i = 1; i <= k / 2; i++) {
            if(freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }
};
```
