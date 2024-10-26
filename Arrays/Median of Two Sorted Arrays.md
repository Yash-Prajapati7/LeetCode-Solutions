Leetcode Question: [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)

### Approach - 1 (Brute Force)
- Time Complexity : 𝑂(𝑚 + 𝑛)
- Space Complexity : O(m + n)

#### Java
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                merged[k] = nums1[i++];
            }
            else {
                merged[k] = nums2[j++];
            }
            k++;
        }

        while(i < m) {
            merged[k++] = nums1[i++];
        }
        while(j < n) {
            merged[k++] = nums2[j++];
        }

        int ind = (m + n) / 2;
        if((m + n) % 2 == 0) {
            return (merged[ind] + merged[ind - 1]) / 2.0;
        }
        else {
            return merged[ind];
        }
    }
}
```

#### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size();
        vector<int> merged(m + n);

        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                merged[k] = nums1[i++];
            }
            else {
                merged[k] = nums2[j++];
            }
            k++;
        }

        while(i < m) {
            merged[k++] = nums1[i++];
        }
        while(j < n) {
            merged[k++] = nums2[j++];
        }

        int ind = (m + n) / 2;
        if((m + n) % 2 == 0) {
            return (merged[ind] + merged[ind - 1]) / 2.0;
        }
        else {
            return merged[ind];
        }
    }
};
```

### Approach - 2 (Better)
- Time Complexity : 𝑂(𝑚 + 𝑛)
- Space Complexity : O(1)

#### Java
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int size = m + n;
        int ind2 = size / 2;
        int ind1 = ind2 - 1;
        int e1 = -1, e2 = -1;
        int count = 0;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                if (count == ind1)
                    e1 = nums1[i];
                if (count == ind2) {
                    e2 = nums1[i];
                }
                count++;
                i++;
            } else {
                if (count == ind1)
                    e1 = nums2[j];
                if (count == ind2) {
                    e2 = nums2[j];
                }
                count++;
                j++;
            }
        }

        while (i < m) {
            if (count == ind1)
                e1 = nums1[i];
            if (count == ind2) {
                e2 = nums1[i];
            }
            count++;
            i++;
        }
        while (j < n) {
            if (count == ind1)
                e1 = nums2[j];
            if (count == ind2) {
                e2 = nums2[j];
            }
            count++;
            j++;
        }

        if(size % 2 == 0) {
            return (e1 + e2) / 2.0; 
        }
        else {
            return e2;
        }
    }
}
```

#### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size();
        int size = m + n;
        int ind2 = size / 2;
        int ind1 = ind2 - 1;
        int e1 = -1, e2 = -1;
        int count = 0;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                if (count == ind1) e1 = nums1[i];
                if (count == ind2) e2 = nums1[i];
                count++;
                i++;
            } else {
                if (count == ind1) e1 = nums2[j];
                if (count == ind2) e2 = nums2[j];
                count++;
                j++;
            }
        }

        while (i < m) {
            if (count == ind1) e1 = nums1[i];
            if (count == ind2) e2 = nums1[i];
            count++;
            i++;
        }
        while (j < n) {
            if (count == ind1) e1 = nums2[j];
            if (count == ind2) e2 = nums2[j];
            count++;
            j++;
        }

        if(size % 2 == 0) {
            return (e1 + e2) / 2.0; 
        } else {
            return e2;
        }
    }
};
```

### Approach - 3 (Optimal)
- Time Complexity : O(log min(n1, n2))
- Space Complexity : O(1)

#### Java
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;
        int low = 0, high = n1;
        int left = (n + 1) / 2;

        while(low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;
            int l1 = (mid1 - 1 >= 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1 >= 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                }
                return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            else if(l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }
}
```

#### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size(), n2 = nums2.size();
        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;
        int low = 0, high = n1;
        int left = (n + 1) / 2;

        while(low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            int r1 = (mid1 < n1) ? nums1[mid1] : INT_MAX;
            int r2 = (mid2 < n2) ? nums2[mid2] : INT_MAX;
            int l1 = (mid1 - 1 >= 0) ? nums1[mid1 - 1] : INT_MIN;
            int l2 = (mid2 - 1 >= 0) ? nums2[mid2 - 1] : INT_MIN;

            if(l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return max(l1, l2);
                }
                return (double)(max(l1, l2) + min(r1, r2)) / 2.0;
            }
            else if(l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }
};
```
