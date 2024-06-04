/*
Leetcode Question :
https://leetcode.com/problems/3sum/
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            //Handle the case of duplicates :
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                if((nums[i] + nums[j] + nums[k]) > 0) {
                    k--;
                }
                else if ((nums[i] + nums[j] + nums[k]) < 0) {
                    j++;
                }
                else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    answer.add(temp);
                    j++;
                    k--;

                    //Handle the case of duplicates :
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, -2, -1, 3};
        System.out.println(threeSum(nums));
    }
}
