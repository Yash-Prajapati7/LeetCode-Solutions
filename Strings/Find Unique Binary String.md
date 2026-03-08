Leetcode Question : [Find Unique Binary String](https://leetcode.com/problems/find-unique-binary-string/)

## Approach - 1

### Java

```java
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = (1 << n) - 1;
        String num = "";

        for(int i = n - 1; i >= 0; i--) {
            num = Integer.toBinaryString(start);
            if(!num.equals(nums[i])) {
                return num;
            }
            start--;
        }

        num = "";
        for(int i = 0; i < n; i++) {
            num += "0";
        }

        return num;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int start = (1 << n) - 1;
        string num = "";

        for(int i = n - 1; i >= 0; i--) {
            num = bitset<32>(start).to_string();
            num = num.substr(num.find('1'));
            if(num != nums[i]) {
                return num;
            }
            start--;
        }

        num = "";
        for(int i = 0; i < n; i++) {
            num += "0";
        }

        return num;
    }
};
```

## Approach - 2

### Java

```java
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }
        
        return ans.toString();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        string ans = "";
        for (int i = 0; i < nums.size(); i++) {
            char curr = nums[i][i];
            ans += (curr == '0' ? '1' : '0');
        }
        
        return ans;
    }
};
```
