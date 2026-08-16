Leetcode Question : [Stone Game IX](https://leetcode.com/problems/stone-game-ix)

## Explanation

We don't care about the actual values of the stones. We only care about their remainder when divided by `3`.

* `0` → does not change the current sum's remainder
* `1` → increases the remainder by `1`
* `2` → increases the remainder by `2`

Alice cannot start with a remainder-`0` stone because `0 + 0 = 0`, so she would immediately lose.

So Alice must start with either `1` or `2`.

Suppose Alice starts with `1`:

* Alice takes `1` → sum remainder is `1`
* Bob cannot take `2`, because `1 + 2 = 3`, so Bob would lose
* Therefore, Bob is forced to take `1`
* Now the remainder is `2`
* Alice cannot take `1`, because `2 + 1 = 3`, so Alice must take `2`

Therefore, the sequence is forced:

```text
1, 1, 2, 1, 2, 1, 2, ...
```

Similarly, if Alice starts with `2`, the sequence is:

```text
2, 2, 1, 2, 1, 2, 1, ...
```

So the game is essentially a battle between the number of `1` and `2` stones.

A remainder-`0` stone does not change the sum's remainder. If there are two `0` stones:

```text
Alice takes 0
Bob takes 0
```

we return to the same game state, with the turn passed. Therefore, an **even number of `0` stones effectively cancels out**.

When `count0` is even, Alice wins if there is at least one `1` and at least one `2`.

When `count0` is odd, all pairs of `0` stones cancel, leaving one extra `0` stone. This changes whose turn gets the important position in the forced `1/2` sequence.

In this case, Alice can win only when one type has more than `2` extra stones:

```text
abs(count1 - count2) > 2
```

Therefore:

```text
count0 even → count1 > 0 && count2 > 0
count0 odd  → abs(count1 - count2) > 2
```

### Java

```java
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n = stones.length;

        // With only 1 stone, Alice has to take it and loses.
        if (n == 1) {
            return false;
        }

        int count0 = 0, count1 = 0, count2 = 0;

        for (int stone : stones) {
            int remainder = stone % 3;

            if (remainder == 0) {
                count0++;
            } else if (remainder == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        if (count0 % 2 == 0) {
            return count1 >= 1 && count2 >= 1;
        }

        return Math.abs(count1 - count2) > 2;
    }
}
```

### C++

```cpp
class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        int n = stones.size();

        // With only 1 stone, Alice has to take it and loses.
        if (n == 1) {
            return false;
        }

        int count0 = 0, count1 = 0, count2 = 0;

        for (int stone : stones) {
            int remainder = stone % 3;

            if (remainder == 0) {
                count0++;
            } else if (remainder == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        if (count0 % 2 == 0) {
            return count1 >= 1 && count2 >= 1;
        }

        return abs(count1 - count2) > 2;
    }
};
```
