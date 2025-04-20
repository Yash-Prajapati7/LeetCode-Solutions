Leetcode Question : [Rabbits in Forest](https://leetcode.com/problems/rabbits-in-forest/)

### Java
```java
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int answer : answers) freq.put(answer, freq.getOrDefault(answer, 0) + 1);

        int total = 0;
        for(int key : freq.keySet()) {
            int value = freq.get(key);
            total += ((value + key) / (key + 1)) * (key + 1);   // taking the ceil value of (value/key + 1)
        }

        return total;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numRabbits(vector<int>& answers) {
        unordered_map<int, int> freq;
        for(int answer : answers) {
            freq[answer]++;
        }

        int total = 0;
        for(auto& entry : freq) {
            int value = entry.second;
            total += ((value + entry.first) / (entry.first + 1)) * (entry.first + 1);
        }

        return total;
    }
};
```

# Explaination
---

## 1. What each answer means

- If a rabbit says `x`, it’s telling you “there are exactly **x other** rabbits the same color as me.”
- So each such rabbit belongs to a color‑group of size `(x + 1)` (itself plus the `x` others).

---

## 2. Counting how many rabbits give each answer

1. **Build `freq`**, a map from `answer → count of rabbits answering that number`.  
   ```java
   // e.g. answers = [1,1,2,2,2,3]  
   // freq = { 1→2,  2→3,  3→1 }
   ```

---

## 3. Figuring out how many groups of size (answer+1) you need

For each distinct answer `key` with `value = freq.get(key)` rabbits:

1. **Group size** = `key + 1`.  
2. **Number of full groups needed** =  
   `value / groupSize`
   — because if you have, say, 5 rabbits all saying “2”, each group holds 3 rabbits, and 5/3 = 1.66, so you need **2** groups to accommodate those 5.

3. **Code trick for ceiling**:  
   ```java
   // ceil(value / (key+1)) 
   //    == (value + (key+1) - 1) / (key+1)
   // here (key+1)-1 is just key
   int groups = (value + key) / (key + 1);
   ```

4. **Rabbits contributed** by this answer =  
   `groups * group size` =  
   ```java
   ((value + key) / (key + 1)) * (key + 1)
   ```
   — even if the last group isn’t “full,” you still must count all `(key+1)` slots, because those “missing” rabbits could exist (we only know a lower bound).

---

## 4. Summing across all answer‐values

You then add up each answer’s contribution to get the **minimum total rabbits** possible:

```java
int total = 0;
for (int key : freq.keySet()) {
    int value     = freq.get(key);
    int groupSize = key + 1;
    int groups    = (value + key) / groupSize;      // ceil of value / groupSize
    total        += groups * groupSize;
}
return total;
```

---

## 5. Concrete example

```text
answers = [1, 1, 2]
```
- Rabbits saying “1”: freq=2, groupSize=2 → groups = (2 + 1) / 2 = 1 → contributes 1×2 = 2 rabbits  
- Rabbits saying “2”: freq=1, groupSize=3 → groups = (1 + 2) / 3 = 1 → contributes 1×3 = 3 rabbits  
**Total = 2 + 3 = 5**, which is indeed the smallest possible forest population consistent with those answers.

---
