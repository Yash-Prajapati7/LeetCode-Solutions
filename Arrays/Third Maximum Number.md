Leetcode Question: [Third Maximum Number](https://leetcode.com/problems/third-maximum-number/)

## Method - 1 (Using PriorityQueue) 

### Java
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for(int num : nums) {
            if(pq.size() < k) {
                pq.offer(num);
            }
            else if(num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }
}
```

### C++
```cpp
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;

        for(int num : nums) {
            if(pq.size() < k) {
                pq.push(num);
            }
            else if(num > pq.top()) {
                pq.pop();
                pq.push(num);
            }
        }
        return pq.top();
    }
};
```

## Method - 2 (Using TreeSet) 

### Java
```java
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.pollFirst(); // Remove the smallest element if we have more than 3 elements
            }
        }
        if (set.size() < 3) {
            return set.last(); // Return the largest element if there are less than 3 distinct elements
        }
        return set.first(); // The third largest element
    }
}
```

### C++
```cpp
class Solution {
public:
    int thirdMax(vector<int>& nums) {
        set<int> s;
        for (int num : nums) {
            s.insert(num);
            if (s.size() > 3) {
                s.erase(s.begin()); // Remove the smallest element if we have more than 3 elements
            }
        }
        if (s.size() < 3) {
            return *s.rbegin(); // Return the largest element if there are less than 3 distinct elements
        }
        return *s.begin(); // The third largest element
    }
};
```

## Method - 3 (Using Traditional Comparision) 

### Java
```java
class Solution {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max3 = max2;
                max2 = num;
            } else if (num > max3 && num < max2) {
                max3 = num;
            }
        }

        return max3 != Long.MIN_VALUE ? (int) max3 : (int) max1;
    }
}
```

### C++
```cpp
class Solution {
public:
    int thirdMax(vector<int>& nums) {
        long max1 = LONG_MIN;
        long max2 = LONG_MIN;
        long max3 = LONG_MIN;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max3 = max2;
                max2 = num;
            } else if (num > max3 && num < max2) {
                max3 = num;
            }
        }

        return max3 != LONG_MIN ? (int) max3 : (int) max1;
    }
};
```
