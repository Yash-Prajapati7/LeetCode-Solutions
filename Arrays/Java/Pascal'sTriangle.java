/*
Leetcode Question :
leetcode.com/problems/pascals-triangle/
*/
class Solution {
    public static List<Integer> listElements(int row) {
        ArrayList<Integer> answer = new ArrayList<>();
        long temp = 1;
        answer.add(1);
        for(int col = 1; col < row; col++) {
            temp = temp * (row - col);
            temp /= col;
            answer.add((int) temp);
        }
        return answer;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++) {
            ans.add(listElements(i));
        }
        return ans;
    }
}
