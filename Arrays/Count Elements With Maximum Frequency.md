Leetcode Question : [Count Elements With Maximum Frequency](https://leetcode.com/problems/count-elements-with-maximum-frequency)

### Java

```java
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = -1;

        for(int num : nums) {
            freq[num]++;
            max = (max < freq[num]) ? freq[num] : max;
        }

        int answer = 0;
        for(int f : freq) {
            if(f == max) {
                answer += f;
            }
        }

        return answer;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        int freq[101] = {0};
        int maxFreq = -1;

        for(int num : nums) {
            freq[num]++;
            maxFreq = (maxFreq < freq[num]) ? freq[num] : maxFreq;
        }

        int answer = 0;
        for(int f : freq) {
            if(f == maxFreq) {
                answer += f;
            }
        }

        return answer;
    }
};
```
