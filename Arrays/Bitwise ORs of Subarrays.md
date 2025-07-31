Leetcode Question : [Bitwise ORs of Subarrays](https://leetcode.com/problems/bitwise-ors-of-subarrays)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        if(n == 1) return 1;
        HashSet<Integer> distinct = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int or = 0;
            for(int j = i; j < n; j++) {
                or |= arr[j];
                distinct.add(or);
            }
        }

        return distinct.size();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        int n = arr.size();
        if(n == 1) return 1;
        unordered_set<int> distinct;

        for(int i = 0; i < n; i++) {
            int orVal = 0;
            for(int j = i; j < n; j++) {
                orVal |= arr[j];
                distinct.insert(orVal);
            }
        }

        return distinct.size();
    }
};
```

## Method - 2

### Java

```java
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();

        for(int x : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(x);
            
            for(int y : current) {
                next.add(x | y);
            }

            result.addAll(next);
            current = next;
        }

        return result.size();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        unordered_set<int> result, current;

        for(int x : arr) {
            unordered_set<int> next;
            next.insert(x);

            for(int y : current) {
                next.insert(x | y);
            }

            for(int val : next) {
                result.insert(val);
            }

            current = next;
        }

        return result.size();
    }
};
```

## Method - 3

### Java

```java
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] == (arr[j] | arr[i])) {
                    break;
                }

                arr[j] |= arr[i];
                result.add(arr[j]);
            }
        }

        return result.size();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        unordered_set<int> result;

        for(int i = 0; i < arr.size(); i++) {
            result.insert(arr[i]);
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] == (arr[j] | arr[i])) {
                    break;
                }

                arr[j] |= arr[i];
                result.insert(arr[j]);
            }
        }

        return result.size();
    }
};
```
