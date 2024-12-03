Leetcode Question : [Adding Spaces to a String](https://leetcode.com/problems/adding-spaces-to-a-string/)

## Approach - 1

### Java
```java
class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int size = spaces.length;
        int newLength = n + size;
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder(newLength + 1);
        
        while(i < newLength && j < size) {
            sb.append(s.substring(i, spaces[j]) + " ");
            i = spaces[j];
            j++;
        }

        if(i < newLength) {
            sb.append(s.substring(i, n));
        }

        return sb.toString();
    }
}
```

### C++
```cpp
class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        int n = s.length();
        int size = spaces.size();
        int newLength = n + size;
        int i = 0, j = 0;
        string result;
        result.reserve(newLength + 1);

        while (i < n && j < size) {
            result += s.substr(i, spaces[j] - i) + " ";
            i = spaces[j];
            j++;
        }

        if (i < n) {
            result += s.substr(i);
        }

        return result;
    }
};
```

---

## Approach - 2

### Java
```java
class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int i = 0, j = 0;

        char[] ch = s.toCharArray();  
        char[] result = new char[n + spaces.length];

        for(int sp : spaces) {
            while(i < sp) {
                result[j] = ch[i];
                i++;
                j++;
            }
            result[j] = ' ';
            j++;
        }

        while(i < n) {
            result[j] = ch[i];
            i++;
            j++;
        }

        return new String(result);
    }
}
```

### C++
```cpp
class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        int n = s.length();
        int i = 0, j = 0;

        vector<char> result(n + spaces.size());
        
        for (int sp : spaces) {
            while (i < sp) {
                result[j++] = s[i++];
            }
            result[j++] = ' ';
        }

        while (i < n) {
            result[j++] = s[i++];
        }

        return string(result.begin(), result.end());
    }
};
```
