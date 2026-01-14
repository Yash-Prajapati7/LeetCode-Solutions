Leetcode Question : [Day of the Year](https://leetcode.com/problems/day-of-the-year/)

### Java

```java
class Solution {
    public int dayOfYear(String date) {
        int[] monthdays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        String[] d = date.split("-");
        int year = Integer.valueOf(d[0]);
        int month = Integer.valueOf(d[1]);
        int day = Integer.valueOf(d[2]);

        int ans = day + monthdays[month - 1];
        boolean isLeapYear = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);

        return (isLeapYear && month > 2) ? ans + 1 : ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int dayOfYear(string date) {
        vector<int> monthdays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

        int year = stoi(date.substr(0, 4));
        int month = stoi(date.substr(5, 2));
        int day = stoi(date.substr(8, 2));

        int ans = day + monthdays[month - 1];
        bool isLeapYear = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);

        return (isLeapYear && month > 2) ? ans + 1 : ans;
    }
};
```
