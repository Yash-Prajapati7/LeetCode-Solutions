Leetcode Question : [Generate a String With Characters That Have Odd Counts](https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/)

### Java

```java
class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n - 1; i++) {
            sb.append('a');
        }

        sb.append((n % 2 == 0) ? 'b' : 'a');
        return new String(sb);
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    string generateTheString(int n) {
        string result;
        result.reserve(n);

        for (int i = 0; i < n - 1; i++) {
            result += 'a';
        }

        result += (n % 2 == 0) ? 'b' : 'a';

        return result;
    }
};
```
