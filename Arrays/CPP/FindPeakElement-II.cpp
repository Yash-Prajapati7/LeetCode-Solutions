#include <vector>
using namespace std;

class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int left = 0;
        int right = cols - 1;

        while (left <= right) {
            int midCol = (left + right) / 2;
            int maxRow = 0;

            // Find the maximum element in the middle column
            for (int i = 0; i < rows; i++) {
                if (matrix[i][midCol] > matrix[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            // Check if the maximum element in the middle column is a peak
            bool isLeftHigher = (midCol > 0 && matrix[maxRow][midCol - 1] > matrix[maxRow][midCol]);
            bool isRightHigher = (midCol < cols - 1 && matrix[maxRow][midCol + 1] > matrix[maxRow][midCol]);

            if (!isLeftHigher && !isRightHigher) {
                return {maxRow, midCol};
            } else if (isLeftHigher) {
                // Search in the left half
                right = midCol - 1;
            } else {
                // Search in the right half
                left = midCol + 1;
            }
        }

        return {-1, -1};  // This line should theoretically never be reached
    }
};