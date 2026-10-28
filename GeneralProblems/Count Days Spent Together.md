Leetcode Question : [Count Days Spent Together](https://leetcode.com/problems/count-days-spent-together/)

### Java

```
class Solution {

    public int countDaysTogether(
            String arriveAlice,
            String leaveAlice,
            String arriveBob,
            String leaveBob) {

        int[] prefixSum = { // prefix sum of days in months
                0, 31, 59, 90, 120, 151, 181,
                212, 243, 273, 304, 334, 365
        };

        int arriveAliceDay = calculateDayOfYear(arriveAlice, prefixSum);
        int leaveAliceDay = calculateDayOfYear(leaveAlice, prefixSum);
        int arriveBobDay = calculateDayOfYear(arriveBob, prefixSum);
        int leaveBobDay = calculateDayOfYear(leaveBob, prefixSum);

        return Math.max(
                0,
                Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1);
    }

    private int calculateDayOfYear(String day, int[] prefixSum) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date = Integer.parseInt(day.substring(3));
        return prefixSum[month - 1] + date;
    }
}
```

### C++

```
using namespace std;

class Solution {
public:
    int countDaysTogether(
            string arriveAlice,
            string leaveAlice,
            string arriveBob,
            string leaveBob) {

        vector<int> prefixSum = { // prefix sum of days in months
                0, 31, 59, 90, 120, 151, 181,
                212, 243, 273, 304, 334, 365
        };

        int arriveAliceDay = calculateDayOfYear(arriveAlice, prefixSum);
        int leaveAliceDay = calculateDayOfYear(leaveAlice, prefixSum);
        int arriveBobDay = calculateDayOfYear(arriveBob, prefixSum);
        int leaveBobDay = calculateDayOfYear(leaveBob, prefixSum);

        return max(
                0,
                min(leaveAliceDay, leaveBobDay) - max(arriveAliceDay, arriveBobDay) + 1);
    }

private:
    int calculateDayOfYear(string day, vector<int>& prefixSum) {
        int month = stoi(day.substr(0, 2));
        int date = stoi(day.substr(3));
        return prefixSum[month - 1] + date;
    }
};
```
