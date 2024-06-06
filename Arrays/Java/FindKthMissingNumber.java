/*
Leetcode Question :
https://leetcode.com/problems/kth-missing-positive-number/description/
*/
public class FindKthMissingNumber {
    public static int findKthPositive(int[] arr, int k) {
        if(arr[0] > k) {
            return k;
        }
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low + k;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        int k = 2;
        System.out.println(findKthPositive(arr, k));
    }
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
