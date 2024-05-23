/*
Leetcode problem :
https://leetcode.com/problems/longest-consecutive-sequence/description/
*/

import java.util.*;

public class LongestSequenceInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements (enter -1 to stop):");
        int num;
        while (true) {
            num = sc.nextInt();
            if (num == -1) {
                break;
            }
            arr.add(num);
        }

        // Add all the elements of the ArrayList into the HashSet
        HashSet<Integer> hs = new HashSet<>(arr);

        int longest = 1;
        for (int iterator : arr) {
            if (!hs.contains(iterator - 1)) {
                int current = 1;
                int element = iterator;
                while (hs.contains(element + 1)) {
                    current++;
                    element++;
                }
                longest = Math.max(longest, current);
            }
        }
        System.out.println("Longest consecutive sequence length: " + longest);
    }
}
