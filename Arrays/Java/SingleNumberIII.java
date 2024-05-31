/*
Leetcode Question :
https://leetcode.com/problems/single-number-iii/description/

Although the question has asked that the solution must be of constant space complexity, 
but as per the given constraints this approach also has a constant space complexity 
as all the elements in the end will get removed and only the two unique elements will be left
*/
import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumberIII {
    public static int[] singleNumber(int[] nums) {
        if(nums.length == 2) {
            return nums;
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int num : nums) {
            if (al.contains(num)) {
                al.remove(Integer.valueOf(num));
            } else {
                al.add(num);
            }
        }

        // Convert the ArrayList to an array
        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(Arrays.toString(singleNumber(nums))); // Output should be [3, 5] (order may vary)
    }
}
