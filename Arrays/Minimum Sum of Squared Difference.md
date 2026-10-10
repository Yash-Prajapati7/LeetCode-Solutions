Leetcode Question : [Minimum Sum of Squared Difference](https://leetcode.com/problems/minimum-sum-of-squared-difference/)

### Java

```
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            nums1[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = maxDiff < nums1[i] ? nums1[i] : maxDiff;
        }

        int l = 0, r = maxDiff, mid = 0;
        int commonValue = 0; // the common value at which we can bring all differences
        int num = 0;
        long sum = 0;
        long k = k1 + k2;

        while (l <= r) {
            mid = (l + r) >>> 1; // unsigned right shift
            sum = 0;

            for (int i = 0; i < n; i++) {
                num = nums1[i];
                if (num > mid) {
                    sum += num - mid;
                }
            }

            if (sum <= k) {
                r = mid - 1;
                commonValue = mid;
            } else {
                l = mid + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums1[i] > commonValue) {
                k -= (nums1[i] - commonValue);
            }
        }

        long difference = 0;
        Arrays.sort(nums1);
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            difference = nums1[i] < commonValue ? nums1[i] : commonValue;

            if (k > 0 && difference > 0) {
                difference--;
                k--;
            }

            ans += (difference * difference);
        }

        return ans;
    }
}
```

### C++

```
using namespace std;

class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        int n = nums1.size();
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            nums1[i] = abs(nums1[i] - nums2[i]);
            maxDiff = maxDiff < nums1[i] ? nums1[i] : maxDiff;
        }

        int l = 0, r = maxDiff, mid = 0;
        int commonValue = 0; // the common value at which we can bring all differences
        int num = 0;
        long long sum = 0;
        long long k = k1 + k2;

        while (l <= r) {
            mid = (l + r) >>> 1; // unsigned right shift
            sum = 0;

            for (int i = 0; i < n; i++) {
                num = nums1[i];
                if (num > mid) {
                    sum += num - mid;
                }
            }

            if (sum <= k) {
                r = mid - 1;
                commonValue = mid;
            } else {
                l = mid + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums1[i] > commonValue) {
                k -= (nums1[i] - commonValue);
            }
        }

        long long difference = 0;
        sort(nums1.begin(), nums1.end());
        long long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            difference = nums1[i] < commonValue ? nums1[i] : commonValue;

            if (k > 0 && difference > 0) {
                difference--;
                k--;
            }

            ans += (difference * difference);
        }

        return ans;
    }
};
```
