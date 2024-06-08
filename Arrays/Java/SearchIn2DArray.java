/*
Leetcode Question :
https://leetcode.com/problems/search-a-2d-matrix/
*/
public class SearchIn2DArray {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = (rows * cols) - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int rowIndex = mid / cols;
            int colIndex = mid % cols;
            if(matrix[rowIndex][colIndex] == target) {
                return true;
            }
            else if (matrix[rowIndex][colIndex] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int target = 14;
        System.out.println(searchMatrix(matrix, target));
    }
}

/*
In the above solution we are converting a 2D array into its 1D equivalent array(imaginary). 
In this way we can apply binary search to the matrix and achieve the time complexity of O(log (rows x cols))

*/