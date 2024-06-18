/*
Leetcode Question :
https://leetcode.com/problems/merge-intervals/
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        //Sort the intervals based on the value at 0-th index
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        ArrayList<int []> result = new ArrayList<>();
        int [] newInterval = intervals[0];
        for(int [] interval : intervals) {
            if(interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            else {
                result.add(newInterval);
                newInterval = interval;
            }
        }
        // Don't forget to add the last merged interval to the result
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int [][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] mergedIntervals = merge(intervals);

        // Print the merged intervals
        System.out.print("[");
        for (int i = 0; i < mergedIntervals.length; i++) {
            System.out.print(Arrays.toString(mergedIntervals[i]));
            if (i < mergedIntervals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
