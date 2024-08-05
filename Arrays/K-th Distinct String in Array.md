Leetcode Question : [K-th Distinct String in Array](https://leetcode.com/problems/kth-distinct-string-in-an-array/)
### Java
```java
class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> hm = new HashMap<>();

        // Count occurrences of each string
        for (String s : arr) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }

        int distinctElements = 0;

        for(String s : arr) {
            if(hm.get(s) == 1) {
                distinctElements++;
            }
            if(distinctElements == k) {
                return s;
            }
        }

        return "";
    }
}
```

### C++
```cpp
#include <unordered_map>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        unordered_map<string, int> hm;

        // Count occurrences of each string
        for (const string& s : arr) {
            hm[s] = hm.get(s, 0) + 1;
        }

        int distinctElements = 0;

        for(const string& s : arr) {
            if(hm[s] == 1) {
                distinctElements++;
            }
            if(distinctElements == k) {
                return s;
            }
        }

        return "";
    }
};
```
