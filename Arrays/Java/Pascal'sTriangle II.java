/*
Leetcode Question :
leetcode.com/problems/pascals-triangle-ii/
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long temp = 1;
        row.add((int) temp); // Add the first element which is always 1
        for (int col = 1; col <= rowIndex; col++) {
            temp = temp * (rowIndex - col + 1) / col;
            row.add((int) temp);
        }
        return row;
    }
}
