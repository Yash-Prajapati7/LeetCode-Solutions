Leetcode Question : [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
       
        for(int i = 0; i < temperatures.length; i++) {
            for(int j = i + 1; j < temperatures.length; j++) {
                if(temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
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
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> answer(temperatures.size());

        for(int i = 0; i < temperatures.size(); i++) {
            for(int j = i + 1; j < temperatures.size(); j++) {
                if(temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }
};
```

## Method - 2 (Monotonic Stack)

### Java

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int index = st.pop();
                answer[index] = i - index;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            answer[st.pop()] = 0;
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
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        stack<int> st;
        vector<int> answer(n, 0);

        for(int i = 0; i < n; i++) {
            while(!st.empty() && temperatures[i] > temperatures[st.top()]) {
                int index = st.top();
                st.pop();
                answer[index] = i - index;
            }
            st.push(i);
        }

        while(!st.empty()) {
            answer[st.top()] = 0;
            st.pop();
        }

        return answer;
    }
};
```
