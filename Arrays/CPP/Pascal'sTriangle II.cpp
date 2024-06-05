/*
Leetcode Question:
https://leetcode.com/problems/pascals-triangle-ii/
*/
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> row;
        long long temp = 1;
        row.push_back(static_cast<int>(temp)); // Add the first element which is always 1
        for (int col = 1; col <= rowIndex; col++) {
            temp = temp * (rowIndex - col + 1) / col;
            row.push_back(static_cast<int>(temp));
        }
        return row;
    }
};
