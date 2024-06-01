/*
Leetcode Question :
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
*/
import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(!(nums[index] < 0)) {
                nums[index] = -nums[index];
            }
        }
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] > 0) {
                answer.add(i+1);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int [] nums = {1};
        System.out.println(findDisappearedNumbers(nums));;
    }
}
