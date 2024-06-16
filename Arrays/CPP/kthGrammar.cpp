/*
Leetcode Question :
https://leetcode.com/problems/k-th-symbol-in-grammar/

Intuition:
Convert to 0-Based Index:The input k is 1-based. Subtract 1 to make it 0-based for easier calculations.
Iterate While k is Greater than 0.
Use a while loop to repeatedly check and manipulate k until it becomes 0.
Flip the Value if k is odd (k % 2 == 1), flip the current value from 0 to 1 or from 1 to 0.
Update k to its parent index by dividing it by 2 (k /= 2).
Return the Final Value
*/
#include <iostream>

class KthSymbol {
public:
    static int kthGrammar(int n, int k) {
        int value = 0;
        k--;  // Convert 1-based index to 0-based
        while (k > 0) {
            if (k % 2 == 1) {  // If k is odd
                value = 1 - value;  // Flip the value
            }
            k /= 2;
        }
        return value;
    }
};

int main() {
    std::cout << KthSymbol::kthGrammar(3, 2) << std::endl;
    return 0;
}
