Leetcode Question : [Divide Players Into Teams of Equal Skill](https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/)

### Method - 1
- **Time Complexity**: O(n log n)
- **Space Complexity**: O(1)

### Java
```java
class Solution {
    public long dividePlayers(int[] skill) {
        long sum = 0;
        int n = skill.length;
        if(n == 2) {
            return skill[0] * skill[1];
        }
        Arrays.sort(skill);
        int target = skill[0] + skill[n - 1];
        sum += skill[0] * skill[n - 1];

        int left = 1, right = n - 2;
        while(left < right) {
            if(skill[left] + skill[right] != target) {
                return -1;
            }
            sum += skill[left] * skill[right];
            left++;
            right--;
        }
        return sum;
    }
}
```

### C++
```cpp
class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        long long sum = 0;
        int n = skill.size();
        if(n == 2) {
            return skill[0] * skill[1];
        }
        sort(skill.begin(), skill.end());
        int target = skill[0] + skill[n - 1];
        sum += skill[0] * skill[n - 1];

        int left = 1, right = n - 2;
        while(left < right) {
            if(skill[left] + skill[right] != target) {
                return -1;
            }
            sum += (long long)skill[left] * skill[right];
            left++;
            right--;
        }
        return sum;
    }
};
```

---

### Method - 2
- **Time Complexity**: O(n)
- **Space Complexity**: O(1) (ignoring frequency array size since it is constant)

### Java
```java
class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int[] freq = new int[1001];
        int total = 0;
        for(int val : skill) {
            total += val;
            freq[val]++;
        }

        if(total % (n / 2) != 0) {
            return -1;
        }

        long result = 0;
        int target = total / (n / 2);
        for(int val : skill) {
            int required = target - val;
            if(freq[required]-- == 0) {
                return -1;
            }
            result += val * required;
        }

        return result / 2;
    }
}
```

### C++
```cpp
class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        int n = skill.size();
        vector<int> freq(1001, 0);
        int total = 0;
        for(int val : skill) {
            total += val;
            freq[val]++;
        }

        if(total % (n / 2) != 0) {
            return -1;
        }

        long long result = 0;
        int target = total / (n / 2);
        for(int val : skill) {
            int required = target - val;
            if(freq[required]-- == 0) {
                return -1;
            }
            result += (long long)val * required;
        }

        return result / 2;
    }
};
```
