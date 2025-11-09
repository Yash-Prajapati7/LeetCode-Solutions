Leetcode Question : [Count Operations to Obtain Zero](https://leetcode.com/problems/count-operations-to-obtain-zero/)

## Method - 1 (Brute force)

### Java

```java
class Solution {
    public int countOperations(int num1, int num2) {
        if(num1 == 0 && num2 == 0) {
            return 0;
        }

        if(num1 == num2) {
            return 1;
        }
        
        int count = 0;

        while(num1 != 0 && num2 != 0) {
            if(num1 >= num2) {
                num1 -= num2;
            }
            else {
                num2 -= num1;
            }

            count++;
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countOperations(int num1, int num2) {
        if(num1 == 0 && num2 == 0) {
            return 0;
        }

        if(num1 == num2) {
            return 1;
        }
        
        int count = 0;

        while(num1 != 0 && num2 != 0) {
            if(num1 >= num2) {
                num1 -= num2;
            } 
            else {
                num2 -= num1;
            }
            count++;
        }

        return count;
    }
};
```

## Method - 2 (Eucledian Algorithm)

### Java

```java
class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0;
        int temp = 0;

        while(num1 != 0 && num2 != 0) {
            count += (num1 / num2);
            num1 %= num2;
            
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countOperations(int num1, int num2) {
        int count = 0;
        int temp = 0;

        while(num1 != 0 && num2 != 0) {
            count += (num1 / num2);
            num1 %= num2;
            
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        return count;
    }
};
```
