/*
Leetcode Question :
https://leetcode.com/problems/find-a-peak-element-ii/
*/
class Solution {
    public static int[] findPeakGrid(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
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
            boolean isLeftHigher = (midCol > 0 && matrix[maxRow][midCol - 1] > matrix[maxRow][midCol]);
            boolean isRightHigher = (midCol < cols - 1 && matrix[maxRow][midCol + 1] > matrix[maxRow][midCol]);

            if (!isLeftHigher && !isRightHigher) {
                return new int[]{maxRow, midCol};
            } else if (isLeftHigher) {
                // Search in the left half
                right = midCol - 1;
            } else {
                // Search in the right half
                left = midCol + 1;
            }
        }

        return new int[]{-1, -1};  // This line should theoretically never be reached
    }
}
