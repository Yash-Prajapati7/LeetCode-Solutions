Leetcode Question : https://leetcode.com/problems/add-binary/
```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(j >= 0) {
                sum = sum + b.charAt(j) - '0';
                j--;
            }
            if(i >= 0) {
                sum = sum + a.charAt(i) - '0';
                i--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
```
## Dry Run of `addBinary` Method

### Input:
- a = "1010"
- b = "1101"

### Initial State:
- result = ""
- i = 3, j = 3, carry = 0

### Iterations:

1. **First Iteration:**
   - sum = carry → sum = 0
   - sum += b[3] - '0' → sum = 1 (b[3] = '1')
   - sum += a[3] - '0' → sum = 1 (a[3] = '0')
   - result.append(sum % 2) → result = "1"
   - carry = sum / 2 → carry = 0
   - i = 2, j = 2

2. **Second Iteration:**
   - sum = carry → sum = 0
   - sum += b[2] - '0' → sum = 0 (b[2] = '0')
   - sum += a[2] - '0' → sum = 1 (a[2] = '1')
   - result.append(sum % 2) → result = "11"
   - carry = sum / 2 → carry = 0
   - i = 1, j = 1

3. **Third Iteration:**
   - sum = carry → sum = 0
   - sum += b[1] - '0' → sum = 1 (b[1] = '1')
   - sum += a[1] - '0' → sum = 1 (a[1] = '0')
   - result.append(sum % 2) → result = "111"
   - carry = sum / 2 → carry = 0
   - i = 0, j = 0

4. **Fourth Iteration:**
   - sum = carry → sum = 0
   - sum += b[0] - '0' → sum = 1 (b[0] = '1')
   - sum += a[0] - '0' → sum = 2 (a[0] = '1')
   - result.append(sum % 2) → result = "0111"
   - carry = sum / 2 → carry = 1
   - i = -1, j = -1

### Post-Loop:
- carry != 0 → result.append(carry) → result = "10111"

### Final Result:
- result.reverse().toString() → "11101"

**Output:**
- Return "11101"


