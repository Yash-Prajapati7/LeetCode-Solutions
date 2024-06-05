//I tried to make a menu driven program to combine all the pascal triangle problems into a single file, 
//you can just copy-paste the particular method asked in the problem statement.

#include <iostream>
#include <vector>
using namespace std;

// Function to get a single element located at a particular row & column
int element(int row, int col) {
    int answer = 1;
    for (int i = 0; i < col; i++) {
        answer = answer * (row - i);
        answer /= (i + 1);
    }
    return answer;
}

// Function to generate an entire row of Pascal's Triangle
vector<int> listElements(int row) {
    vector<int> answer;
    long long temp = 1;
    answer.push_back(1); // Add the first element which is always 1
    for (int col = 1; col < row; col++) {
        temp = temp * (row - col);
        temp /= col;
        answer.push_back(static_cast<int>(temp));
    }
    return answer;
}

int main() {
    int choice;
    cout << "1 - Finding the element located at Row 'r' & Column 'c'\n"
         << "2 - Printing the entire Row of the triangle\n"
         << "3 - Printing the entire Pascal triangle\n";
    cin >> choice;

    if (choice == 1) {
        int row, col;
        cout << "Enter the row and column of the element: ";
        cin >> row >> col;
        cout << element(row - 1, col - 1) << endl;
    }
    else if (choice == 2) {
        int row;
        cout << "Enter the row number: ";
        cin >> row;
        vector<int> result = listElements(row);
        for (int num : result) {
            cout << num << " ";
        }
        cout << endl;
    }
    else if (choice == 3) {
        int numRows;
        cout << "Enter the number of rows: ";
        cin >> numRows;
        vector<vector<int>> ans;
        for (int i = 1; i <= numRows; i++) {
            ans.push_back(listElements(i));
        }
        for (const auto& row : ans) {
            for (int num : row) {
                cout << num << " ";
            }
            cout << endl;
        }
    }
    return 0;
}
