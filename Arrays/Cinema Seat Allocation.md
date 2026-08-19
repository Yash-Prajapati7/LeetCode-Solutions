Leetcode Question : [Cinema Seat Allocation](https://leetcode.com/problems/cinema-seat-allocation/)

### Java

```java
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        final int LEFT_BLOCK = 0b0000111100;    // Seats 2-5
        final int RIGHT_BLOCK = 0b1111000000;   // Seats 6-9
        final int MIDDLE_BLOCK = 0b0011110000;  // Seats 4-7

        Arrays.sort(reservedSeats, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int totalFamilies = n << 1;
        int reservedMask = 0;

        for (int i = 0; i < reservedSeats.length; i++) {
            int seat = reservedSeats[i][1];
            reservedMask |= (1 << seat);

            if (i == reservedSeats.length - 1 ||
                reservedSeats[i][0] != reservedSeats[i + 1][0]) {

                int allocable = 0;

                if ((reservedMask & LEFT_BLOCK) == 0) {
                    allocable++;
                }

                if ((reservedMask & RIGHT_BLOCK) == 0) {
                    allocable++;
                }

                if (allocable == 0 &&
                    (reservedMask & MIDDLE_BLOCK) == 0) {
                    allocable = 1;
                }

                totalFamilies -= 2 - allocable;
                reservedMask = 0;
            }
        }

        return totalFamilies;
    }
}
```

### C++

```cpp
class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        const int LEFT_BLOCK = 0b0000111100;    // Seats 2-5
        const int RIGHT_BLOCK = 0b1111000000;   // Seats 6-9
        const int MIDDLE_BLOCK = 0b0011110000;  // Seats 4-7

        sort(reservedSeats.begin(), reservedSeats.end());

        int totalFamilies = n << 1;
        int reservedMask = 0;

        for (int i = 0; i < reservedSeats.size(); i++) {
            int seat = reservedSeats[i][1];
            reservedMask |= (1 << seat);

            if (i == reservedSeats.size() - 1 ||
                reservedSeats[i][0] != reservedSeats[i + 1][0]) {

                int allocable = 0;

                if ((reservedMask & LEFT_BLOCK) == 0) {
                    allocable++;
                }

                if ((reservedMask & RIGHT_BLOCK) == 0) {
                    allocable++;
                }

                if (allocable == 0 &&
                    (reservedMask & MIDDLE_BLOCK) == 0) {
                    allocable = 1;
                }

                totalFamilies -= 2 - allocable;
                reservedMask = 0;
            }
        }

        return totalFamilies;
    }
};
```
