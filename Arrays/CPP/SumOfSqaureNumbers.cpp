/*
Leetcode Question :
https://leetcode.com/problems/sum-of-square-numbers/
*/
#include <iostream>
#include <cmath>

using namespace std;

bool judgeSquareSum(long long c) {
    long long left = 0;
    long long right = static_cast<long long>(sqrt(c));
    
    while (left <= right) {
        long long sumOfSquares = left * left + right * right;
        if (sumOfSquares > c) {
            right--;
        } else if (sumOfSquares < c) {
            left++;
        } else {
            return true;
        }
    }
    return false;
}

int main() {
    cout << boolalpha << judgeSquareSum(2147483600) << endl; // Should output true
    return 0;
}
