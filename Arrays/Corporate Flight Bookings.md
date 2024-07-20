[Leetcode Question](https://leetcode.com/problems/corporate-flight-bookings/)
### Java
```java
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int [] result = new int[n];
        for(int [] booking : bookings) {
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int seats = booking[2];

            result[start] += seats;
            if(end + 1 < n) {
                result[end + 1] -= seats;
            }
        }

        for(int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}
```
### C++
```cpp
class Solution {
public:
    vector<int> corpFlightBookings(vector<vector<int>>& bookings, int n) {
        vector<int> result(n, 0);
        for(const auto& booking : bookings) {
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int seats = booking[2];

            result[start] += seats;
            if(end + 1 < n) {
                result[end + 1] -= seats;
            }
        }

        for(int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
};

```
## Dry Run for Input `[[1, 2, 10], [2, 3, 20], [2, 5, 25]]` and `n = 5`

### Initialization:
- `result = [0, 0, 0, 0, 0]`

### Processing the first booking `[1, 2, 10]`:
- `start = 1 - 1 = 0`
- `end = 2 - 1 = 1`
- `seats = 10`
- Apply changes:
  - `result[start] += seats -> result[0] += 10 -> result = [10, 0, 0, 0, 0]`
  - `if (end + 1 < n) result[end + 1] -= seats -> result[2] -= 10 -> result = [10, 0, -10, 0, 0]`

### Processing the second booking `[2, 3, 20]`:
- `start = 2 - 1 = 1`
- `end = 3 - 1 = 2`
- `seats = 20`
- Apply changes:
  - `result[start] += seats -> result[1] += 20 -> result = [10, 20, -10, 0, 0]`
  - `if (end + 1 < n) result[end + 1] -= seats -> result[3] -= 20 -> result = [10, 20, -10, -20, 0]`

### Processing the third booking `[2, 5, 25]`:
- `start = 2 - 1 = 1`
- `end = 5 - 1 = 4`
- `seats = 25`
- Apply changes:
  - `result[start] += seats -> result[1] += 25 -> result = [10, 45, -10, -20, 0]`
  - `if (end + 1 < n)` (this condition is false, so no change)

### Calculate the number of seats for each flight:
- Initial `result = [10, 45, -10, -20, 0]`
- `result[1] += result[0] -> result[1] += 10 -> result = [10, 55, -10, -20, 0]`
- `result[2] += result[1] -> result[2] += 55 -> result = [10, 55, 45, -20, 0]`
- `result[3] += result[2] -> result[3] += 45 -> result = [10, 55, 45, 25, 0]`
- `result[4] += result[3] -> result[4] += 25 -> result = [10, 55, 45, 25, 25]`

### Final Result:
The final array representing the number of seats booked for each flight is:
- `[10, 55, 45, 25, 25]`
