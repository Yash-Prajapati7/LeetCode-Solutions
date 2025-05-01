Leetcode Question : [Student Attendance Record I](https://leetcode.com/problems/student-attendance-record-i/)

### Java
```java
class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        char[] attendance = s.toCharArray();
        for(char day : attendance) if(day == 'A') absent++;
        if(absent >= 2) return false;

        for(int i = 0; i <= attendance.length - 3; i++) {
            if(attendance[i] == 'L') {
                if(attendance[i + 1] == 'L' && attendance[i + 2] == 'L') return false;
            }
        }

        return true;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool checkRecord(string s) {
        int absent = 0;
        for(char day : s) if(day == 'A') absent++;
        if(absent >= 2) return false;

        for(int i = 0; i <= s.size() - 3; i++) {
            if(s[i] == 'L') {
                if(s[i + 1] == 'L' && s[i + 2] == 'L') return false;
            }
        }

        return true;
    }
};
```
