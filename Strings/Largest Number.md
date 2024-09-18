### LeetCode Question: [Largest Number](https://leetcode.com/problems/largest-number/)

### Java
```java
public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0] + "";
        }
        
        String[] numStrs = new String[n];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = nums[i] + "";
        }

        // Sort the string array with a custom comparator
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", the entire result should be "0"
        if (numStrs[0].equals("0")) {
            return "0";
        }

        // Join all the numbers to form the largest number
        String largestNumber = "";
        for(String s : numStrs) {
            largestNumber += s;
        }

        return largestNumber;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string largestNumber(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) {
            return to_string(nums[0]);
        }
        
        vector<string> numStrs(n);
        for (int i = 0; i < n; i++) {
            numStrs[i] = to_string(nums[i]);
        }

        // Sort the string array with a custom comparator
        sort(numStrs.begin(), numStrs.end(), [](string a, string b) {
            return (b + a) < (a + b);
        });

        // If the largest number is "0", the entire result should be "0"
        if (numStrs[0] == "0") {
            return "0";
        }

        // Join all the numbers to form the largest number
        string largestNumber;
        for (auto s : numStrs) {
            largestNumber += s;
        }

        return largestNumber;
    }
};

```
