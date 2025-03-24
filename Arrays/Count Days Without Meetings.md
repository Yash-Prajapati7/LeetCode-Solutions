Leetcode Question : [Count Days Without Meetings](https://leetcode.com/problems/count-days-without-meetings/)

### Method - 1  
**Time Complexity:** O(n log n + n)  
**Space Complexity:** O(log n) or O(n)  

#### Java  
```java
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Merge Intervals
        int[] newInterval = meetings[0];
        List<int[]> intervals = new ArrayList<>();

        for (int[] interval : meetings) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = interval[1] > newInterval[1] ? interval[1] : newInterval[1];
            } else {
                intervals.add(newInterval);
                newInterval = interval;
            }
        }
        intervals.add(newInterval);

        int noMeetings = 0;
        int n = intervals.size();

        if (intervals.get(0)[0] != 1)
            noMeetings = intervals.get(0)[0] - 1;

        for (int i = 0; i < n - 1; i++) {
            if (intervals.get(i)[1] < intervals.get(i + 1)[0]) {
                noMeetings += (intervals.get(i + 1)[0] - intervals.get(i)[1] - 1);
            }
        }
        if (intervals.get(n - 1)[1] < days) {
            noMeetings += (days - intervals.get(n - 1)[1]);
        }

        return noMeetings;
    }
}
```

#### C++  
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countDays(int days, vector<vector<int>>& meetings) {
        sort(meetings.begin(), meetings.end());

        // Merge Intervals
        vector<int> newInterval = meetings[0];
        vector<vector<int>> intervals;

        for (auto& interval : meetings) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = max(newInterval[1], interval[1]);
            } else {
                intervals.push_back(newInterval);
                newInterval = interval;
            }
        }
        intervals.push_back(newInterval);

        int noMeetings = 0;
        int n = intervals.size();

        if (intervals[0][0] != 1)
            noMeetings = intervals[0][0] - 1;

        for (int i = 0; i < n - 1; i++) {
            if (intervals[i][1] < intervals[i + 1][0]) {
                noMeetings += (intervals[i + 1][0] - intervals[i][1] - 1);
            }
        }
        if (intervals[n - 1][1] < days) {
            noMeetings += (days - intervals[n - 1][1]);
        }

        return noMeetings;
    }
};
```

---

### Method - 2  
**Time Complexity:** O(n log n + n)  
**Space Complexity:** O(1)  

#### Java  
```java
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int freeDays = 0;
        
        // Count free days before the first meeting, if any.
        if (meetings[0][0] > 1) {
            freeDays += meetings[0][0] - 1;
        }
        
        int prevEnd = meetings[0][1];
        
        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            
            // If current meeting does not overlap with the previous one,
            // count the free days in between.
            if (start > prevEnd + 1) {
                freeDays += start - prevEnd - 1;
            }
            // Merge overlapping intervals.
            prevEnd = prevEnd < end ? end : prevEnd;
        }
        
        // Count free days after the last meeting, if any.
        if (prevEnd < days) {
            freeDays += days - prevEnd;
        }
        
        return freeDays;
    }
}
```

#### C++  
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countDays(int days, vector<vector<int>>& meetings) {
        sort(meetings.begin(), meetings.end());
        int freeDays = 0;

        // Count free days before the first meeting, if any.
        if (meetings[0][0] > 1) {
            freeDays += meetings[0][0] - 1;
        }

        int prevEnd = meetings[0][1];

        for (int i = 1; i < meetings.size(); i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            // If current meeting does not overlap with the previous one,
            // count the free days in between.
            if (start > prevEnd + 1) {
                freeDays += start - prevEnd - 1;
            }
            // Merge overlapping intervals.
            prevEnd = max(prevEnd, end);
        }

        // Count free days after the last meeting, if any.
        if (prevEnd < days) {
            freeDays += days - prevEnd;
        }

        return freeDays;
    }
};
```
