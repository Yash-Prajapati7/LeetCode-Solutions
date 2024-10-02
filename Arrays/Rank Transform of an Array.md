Leetcode Question : [Rank Transform of an Array](https://leetcode.com/problems/rank-transform-of-an-array/)

### Java
```java
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        
        for(int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        
        HashMap<Integer, Integer> rank = new HashMap<>(n);
        int count = 1;
        for(int i = 0; i < n; i++) {
            if(!rank.containsKey(temp[i])) {
                rank.put(temp[i], count);
                count++;
            }            
        }

        for(int i = 0; i < n; i++) {
            temp[i] = rank.get(arr[i]);
        }

        System.gc();
        return temp;
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        int n = arr.size();
        vector<int> temp(n);
        
        for(int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        sort(temp.begin(), temp.end());
        
        unordered_map<int, int> rank;
        int count = 1;
        for(int i = 0; i < n; i++) {
            if(rank.find(temp[i]) == rank.end()) {
                rank[temp[i]] = count;
                count++;
            }            
        }

        for(int i = 0; i < n; i++) {
            temp[i] = rank[arr[i]];
        }

        return temp;
    }
};
```
