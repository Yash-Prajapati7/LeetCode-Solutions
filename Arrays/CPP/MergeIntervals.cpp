/*
Leetcode Question :
https://leetcode.com/problems/merge-intervals/
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> merge(vector<vector<int>>& intervals) {
    // Sort the intervals based on the value at 0-th index
    sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
        return a[0] < b[0];
    });

    vector<vector<int>> result;
    vector<int> newInterval = intervals[0];
    
    for (auto& interval : intervals) {
        if (interval[0] <= newInterval[1]) {
            newInterval[1] = max(interval[1], newInterval[1]);
        } else {
            result.push_back(newInterval);
            newInterval = interval;
        }
    }
    
    // Don't forget to add the last merged interval to the result
    result.push_back(newInterval);
    
    return result;
}

int main() {
    vector<vector<int>> intervals = {
        {1, 3},
        {2, 6},
        {8, 10},
        {15, 18}
    };

    vector<vector<int>> mergedIntervals = merge(intervals);

    // Print the merged intervals
    cout << "[";
    for (int i = 0; i < mergedIntervals.size(); i++) {
        cout << "[" << mergedIntervals[i][0] << ", " << mergedIntervals[i][1] << "]";
        if (i < mergedIntervals.size() - 1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;

    return 0;
}
