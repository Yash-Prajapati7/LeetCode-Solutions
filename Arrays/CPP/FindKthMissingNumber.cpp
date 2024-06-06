/*
Leetcode Question :
https://leetcode.com/problems/kth-missing-positive-number/description/
*/

#include <iostream>
#include <vector>

using namespace std;

class FindKthMissingNumber {
public:
    static int findKthPositive(vector<int>& arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }
};

int main() {
    vector<int> arr = {1, 2, 3, 4};
    int k = 2;
    cout << FindKthMissingNumber::findKthPositive(arr, k) << endl;
    return 0;
}

/*
The explaination behind returning low + k is that the answer will be arr[high] + extra,
now we are required to find what this 'extra' is. 
Extra = k - missing,
but missing = arr[high] - (high + 1)
Therefore, 
return = arr[high] + extra
= arr[high] + k - missing
= arr[high] + k - arr[high] + high + 1
= k + high + 1
= k + low (Since if you look back the algorithm you will notice that low = high + 1)
*/
