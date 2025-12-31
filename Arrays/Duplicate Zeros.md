Leetcode Question : [Duplicate Zeros](https://leetcode.com/problems/duplicate-zeros/)

## Approach 1

### Java

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;
        int[] result = new int[n];

        while (j < n) {
            if (arr[i] == 0) {
                result[j++] = 0;
            }
            if (j == n) {
                break;
            }
            result[j++] = arr[i++];
        }

        for (i = 0; i < n; i++) {
            arr[i] = result[i];
        }
        return;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        int n = arr.size();
        int i = 0, j = 0;
        vector<int> result(n);

        while (j < n) {
            if (arr[i] == 0) {
                result[j++] = 0;
            }
            if (j == n) {
                break;
            }
            result[j++] = arr[i++];
        }

        for (i = 0; i < n; i++) {
            arr[i] = result[i];
        }
        return;
    }
};
```

## Approach 2

### Java

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length - 1;

        for(int i = 0; i <= (n - zeros); i++) {
            if(arr[i] == 0) {
                // edge case
                if(i == (n - zeros)) {
                    arr[n] = 0;
                    n--;
                    break;
                }

                zeros++;
            }
        }

        int last = (n - zeros);
        for(int i = last; i >= 0; i--) {
            if(arr[i] == 0) {
                // copying the 0 twice
                arr[i + zeros] = 0;
                zeros--;
                arr[i + zeros] = 0;
            }
            else {
                arr[i + zeros] = arr[i];
            }
        }

        return;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        int zeros = 0;
        int n = arr.size() - 1;

        for (int i = 0; i <= (n - zeros); i++) {
            if (arr[i] == 0) {
                // edge case
                if (i == (n - zeros)) {
                    arr[n] = 0;
                    n--;
                    break;
                }
                zeros++;
            }
        }

        int last = (n - zeros);
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                // copying the 0 twice
                arr[i + zeros] = 0;
                zeros--;
                arr[i + zeros] = 0;
            } else {
                arr[i + zeros] = arr[i];
            }
        }

        return;
    }
};
```
