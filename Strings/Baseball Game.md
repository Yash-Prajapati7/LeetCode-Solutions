Leetcode Question : [Baseball Game](https://leetcode.com/problems/baseball-game/)

### Java

```java
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String op : operations) {
            if(op.charAt(0) == '-') {
                st.push(Integer.valueOf(op));
            }
            else {
                if(op.equals("C")) st.pop();
                else if(op.equals("D")) {
                    st.push(st.peek() << 1);
                }
                else if(op.equals("+")) {
                    int rec2 = st.pop();
                    int rec1 = st.pop();
                    st.push(rec1);
                    st.push(rec2);
                    st.push(rec1 + rec2);
                }
                else {
                    st.push(Integer.valueOf(op));
                }
            }
        }

        int result = 0;
        while(!st.isEmpty()) result += st.pop();
        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int calPoints(vector<string>& operations) {
        stack<int> st;
        for (string& op : operations) {
            if (op[0] == '-') {
                st.push(stoi(op));
            }
            else {
                if (op == "C") st.pop();
                else if (op == "D") {
                    st.push(st.top() << 1);
                }
                else if (op == "+") {
                    int rec2 = st.top(); st.pop();
                    int rec1 = st.top(); st.pop();
                    st.push(rec1);
                    st.push(rec2);
                    st.push(rec1 + rec2);
                }
                else {
                    st.push(stoi(op));
                }
            }
        }

        int result = 0;
        while (!st.empty()) {
            result += st.top();
            st.pop();
        }
        return result;
    }
};
```
