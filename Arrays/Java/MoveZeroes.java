/*
Leetcode Question :
https://leetcode.com/problems/move-zeroes/description/
*/
import java.util.ArrayList;
import java.util.Scanner;

public class ShiftZerosToEnd {
    public static ArrayList<Integer> shiftZerosToEnd(ArrayList<Integer> al) {
        int nonZeroIndex = 0;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) != 0) {
                if (i != nonZeroIndex) {
                    // Swap non-zero element to the left
                    int temp = al.get(i);
                    al.set(i, al.get(nonZeroIndex));
                    al.set(nonZeroIndex, temp);
                }
                nonZeroIndex++;
            }
        }
        return al;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int val;
        System.out.println("Keep Entering Integers (Enter -1 to exit)");
        while (true) {
            val = sc.nextInt();
            if (val == -1) {
                break;
            }
            al.add(val);
        }

        System.out.println("Your modified array is: ");
        System.out.println(shiftZerosToEnd(al));
    }
}
