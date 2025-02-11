Leetcode Question : [Perfect Number](https://leetcode.com/problems/perfect-number/)

### Method - 1  
```java
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num % 2 != 0) return false;

        int sum = 0;
        for(int i = 1; i < num; i++) {
            if(num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }
}
```

### Method - 2 (Using Euclid's formula for [Mersenne primes](https://en.wikipedia.org/wiki/Mersenne_prime#:~:text=The%20exponents%20n%20which%20give,sequence%20A000668%20in%20the%20OEIS).))  
This method uses known Mersenne primes to generate perfect numbers using the formula:  
\[
P = 2^{p-1} * (2^p - 1)
\]  
If `num` matches any generated number, it is a perfect number.  

```java
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num % 2 != 0) return false;
        int[] primes = {2, 3, 5, 7, 13, 17, 19, 31};
        int calculated = 0;

        for(int prime : primes) {
            calculated = ( (1 << (prime - 1)) * ((1 << prime) - 1) );
            if(calculated == num) return true;
        }

        return false;
    }
}
```

### Method - 3 (Hardcoding known perfect numbers)  

```java
class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] perfects = {6,28,496,8128,33550336};
        for(int perfect : perfects) {
            if(num == perfect) return true;
        }
        return false;
    }
}
```
