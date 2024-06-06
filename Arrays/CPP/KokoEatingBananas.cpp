/*
Leetcode Question :
https://leetcode.com/problems/koko-eating-bananas/
*/
#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

class KokoEatingBananas {
public:
    static int findMax(const vector<int>& piles) {
        int maxVal = INT_MIN;
        int n = piles.size();
        // Find the maximum value:
        for (int i = 0; i < n; i++) {
            maxVal = max(maxVal, piles[i]);
        }
        return maxVal;
    }

    static int calculateTotalHours(const vector<int>& piles, int hourly) {
        int totalHours = 0;
        int n = piles.size();
        // Calculate total hours needed:
        for (int i = 0; i < n; i++) {
            totalHours += ceil((double)piles[i] / (double)hourly);
        }
        return totalHours;
    }

    static int minEatingSpeed(const vector<int>& piles, int h) {
        int low = 1, high = findMax(piles);

        // Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHours = calculateTotalHours(piles, mid);
            if (totalHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};

int main() {
    vector<int> piles1 = {312884470};
    int h1 = 968709470;
    cout << KokoEatingBananas::minEatingSpeed(piles1, h1) << endl; // Expected output: 1

    vector<int> piles2 = {805306368, 805306368, 805306368};
    int h2 = 1000000000;
    cout << KokoEatingBananas::minEatingSpeed(piles2, h2) << endl; // Expected output: 3

    return 0;
}
