//I tried to make a menu driven program to combine all the pascal triangle problems into a single file, 
//you can just copy-paste the particular method asked in the problem statement.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Method to get a single element located at a aprticular row & column
public class PascalTriangle {
    public static int element(int row, int col) {
        int answer = 1;
        for(int i = 0; i<col; i++) {
            answer = answer * (row - i);
            answer /= (i + 1);
        }
        return answer;
    }

  //Method to generate an entire row of pascal triangle
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Finding the element located at Row 'r' & Column 'c'\n" +
                "2 - Printing the entire Row of the triangle\n" +
                "3 - Printing the entire Pascal triangle");
        int choice = sc.nextInt();
        if(choice == 1) {
            System.out.println("Enter the row and column of the element :");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println(element(row - 1, col - 1));
        }
        else if (choice == 2) {
            System.out.println("Enter the row number : ");
            int row = sc.nextInt();
            System.out.println(listElements(row));
        }
        else if(choice == 3) {
            List<List<Integer>> ans = new ArrayList<>();
            System.out.println("Enter the number of rows :");
            int row = sc.nextInt();
            for(int i = 1; i<=row; i++) {
                ans.add(listElements(i));
            }
            System.out.println(ans);
        }
    }
}
