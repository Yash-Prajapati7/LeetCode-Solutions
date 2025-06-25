Leetcode Question : [Kth Smallest Product of Two Sorted Arrays](https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/)

## Method - 1

### Java

```java
class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        List<Long> products = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                products.add((long) (nums1[i] * nums2[j]));
            }
        }

        Collections.sort(products);
        return products.get((int)(k - 1));
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        vector<long long> products;
        for(int i = 0; i < nums1.size(); i++) {
            for(int j = 0; j < nums2.size(); j++) {
                products.push_back(1LL * nums1[i] * nums2[j]);
            }
        }

        sort(products.begin(), products.end());
        return products[k - 1];
    }
};
```

## Method - 2

### Java

```java
class Solution {
    private long helper(int[] nums2, long x1, long v) {
        int n2 = nums2.length;
        int left = 0, right = n2 - 1, mid = 0;
        long product = 0;

        while(left <= right) {
            mid = (left + right) >> 1;
            product = (long)nums2[mid] * x1;
            if((x1 >= 0 && product <= v) || (x1 < 0 && product > v)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return x1 >= 0 ? left : n2 - left;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length;
        long left = -10000000000L, right = 10000000000L, mid = 0;
        long count = 0;

        while(left <= right) {
            mid = (left + right) >> 1;
            count = 0;
            for(int i = 0; i < n1; i++) {
                count += helper(nums2, nums1[i], mid);
            }

            if(count < k) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
    long long helper(vector<int>& nums2, long long x1, long long v) {
        int n2 = nums2.size();
        int left = 0, right = n2 - 1, mid = 0;
        long long product = 0;

        while(left <= right) {
            mid = (left + right) >> 1;
            product = 1LL * nums2[mid] * x1;
            if((x1 >= 0 && product <= v) || (x1 < 0 && product > v)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return x1 >= 0 ? left : n2 - left;
    }

public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        int n1 = nums1.size();
        long long left = -1e10, right = 1e10, mid = 0, count = 0;

        while(left <= right) {
            mid = (left + right) >> 1;
            count = 0;
            for(int i = 0; i < n1; i++) {
                count += helper(nums2, nums1[i], mid);
            }

            if(count < k) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
};
```
