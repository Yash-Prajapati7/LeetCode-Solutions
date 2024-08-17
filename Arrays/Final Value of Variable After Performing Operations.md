Leetcode Question: [Final Value of Variable After Performing Operations](https://leetcode.com/problems/final-value-of-variable-after-performing-operations/)

### Java
```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String s : operations) {
            if(s.charAt(0) == '-') {
                x = x - 1;
            }
            else if(s.charAt(0) == '+'){
                x = x + 1;
            }
            else if(s.charAt(1) == '-') {
                x = x - 1;
            }
            else {
                x = x + 1;
            }
        }
        return x;
    }
}
```

### C++
```cpp
class Solution {
public:
    int finalValueAfterOperations(vector<string>& operations) {
        int x = 0;
        for(string s : operations) {
            if(s[0] == '-') {
                x = x - 1;
            }
            else if(s[0] == '+') {
                x = x + 1;
            }
            else if(s[1] == '-') {
                x = x - 1;
            }
            else {
                x = x + 1;
            }
        }
        return x;
    }
};
```
