#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

/*
Leetcode problem :
https://leetcode.com/problems/longest-consecutive-sequence/description/
*/

int main() {
    vector<int> arr;

    cout << "Enter the elements (enter -1 to stop):" << endl;
    int num;
    while (true) {
        cin >> num;
        if (num == -1) {
            break;
        }
        arr.push_back(num);
    }

    // Add all the elements of the vector into the unordered_set
    unordered_set<int> hs(arr.begin(), arr.end());

    int longest = 1;
    for (int iterator : arr) {
        if (hs.find(iterator - 1) == hs.end()) {
            int current = 1;
            int element = iterator;
            while (hs.find(element + 1) != hs.end()) {
                current++;
                element++;
            }
            longest = max(longest, current);
        }
    }
    cout << "Longest consecutive sequence length: " << longest << endl;

    return 0;
}
