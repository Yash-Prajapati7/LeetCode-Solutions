/*
Leetcode Question :
https://leetcode.com/problems/majority-element/submissions/1267495668/
*/
import java.util.List;

public class MajorityElement {

    public static int majorityElement(List<Integer> nums) {
        int candidate = nums.get(0);
        int count = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == candidate) {
                count++;
            } else if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else {
                count--;
            }
        }

        // Second pass to verify the candidate
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.size() / 2) {
            return candidate;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        List<Integer> vec = List.of(1, 1, 1, 1);
        System.out.println(majorityElement(vec));
    }
}
