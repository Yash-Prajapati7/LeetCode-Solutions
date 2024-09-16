Leetcode Question : [Minimum Time Difference](https://leetcode.com/problems/minimum-time-difference/)

### Java
```java
class Solution {
    private int toMins(String[] time) {
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        return h * 60 + m;
    }

    public int findMinDifference(List<String> timePoints) {
        boolean[] exists = new boolean[1440];
        int first = 1440, last = 0; // keeping track of first and last mins
        for(String time : timePoints) {
            String[] parts = time.split(":");
            int m = toMins(parts);
            if(exists[m]) {
                return 0;
            }
            exists[m] = true;
            first = Math.min(m, first);
            last = Math.max(m, last);
        }

        int result = (1440 - last + first);
        int prev = first;

        for(int i = first + 1; i < 1440; i++) {
            // i = first + 1 is to make sure that the diff does not become zero in the first iteration itself
            if(exists[i]) {
                int diff = i - prev;
                result = Math.min(result, diff);
                prev = i;
            }
        }

        return result;
    }
}
```

### C++
```cpp
class Solution {
    int toMins(vector<string>& time) {
        int h = stoi(time[0]);
        int m = stoi(time[1]);
        return h * 60 + m;
    }

public:
    int findMinDifference(vector<string>& timePoints) {
        bool exists[1440] = {false};
        int first = 1440, last = 0; // keeping track of first and last mins
        for(string time : timePoints) {
            vector<string> parts;
            stringstream ss(time);
            string part;
            while (getline(ss, part, ':')) {
                parts.push_back(part);
            }
            int m = toMins(parts);
            if(exists[m]) {
                return 0;
            }
            exists[m] = true;
            first = min(m, first);
            last = max(m, last);
        }

        int result = (1440 - last + first);
        int prev = first;

        for(int i = first + 1; i < 1440; i++) {
            // i = first + 1 is to make sure that the diff does not become zero in the first iteration itself
            if(exists[i]) {
                int diff = i - prev;
                result = min(result, diff);
                prev = i;
            }
        }

        return result;
    }
};
```
