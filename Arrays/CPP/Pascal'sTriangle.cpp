/*
Leetcode Question:
https://leetcode.com/problems/pascals-triangle/
*/
#include <vector>
using namespace std;

class Solution {
public:
    static vector<int> listElements(int row) {
        vector<int> answer;
        long long temp = 1;
        answer.push_back(1);
        for (int col = 1; col < row; col++) {
            temp = temp * (row - col);
            temp /= col;
            answer.push_back(static_cast<int>(temp));
        }
        return answer;
    }

    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        for (int i = 1; i <= numRows; i++) {
            ans.push_back(listElements(i));
        }
        return ans;
    }
};
