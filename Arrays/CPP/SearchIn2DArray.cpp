/*
Leetcode Question :
https://leetcode.com/problems/search-a-2d-matrix/
*/
#include <iostream>
#include <vector>

using namespace std;

class SearchIn2DArray {
public:
    static bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int left = 0, right = (rows * cols) - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
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
};

int main() {
    vector<vector<int>> matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int target = 14;
    cout << (SearchIn2DArray::searchMatrix(matrix, target) ? "true" : "false") << endl;
    return 0;
}

/*
In the above solution we are converting a 2D array into its 1D equivalent array (imaginary). 
In this way, we can apply binary search to the matrix and achieve the time complexity of O(log(rows * cols)).
*/