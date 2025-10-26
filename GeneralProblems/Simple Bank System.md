Leetcode Question : [Simple Bank System](https://leetcode.com/problems/simple-bank-system/)

### Java

```java
class Bank {
    private long[] balance;
    int n = 0;

    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 > n || account2 > n || balance[account1 - 1] < money) {
            return false;
        }

        balance[account2 - 1] += money;
        balance[account1 - 1] -= money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account > n) {
            return false;
        }

        balance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account > n || balance[account - 1] < money) {
            return false;
        }

        balance[account - 1] -= money;
        return true;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Bank {
private:
    vector<long long> balance;
    int n = 0;

public:
    Bank(vector<long long>& balance) {
        this->balance = balance;
        this->n = balance.size();
    }
    
    bool transfer(int account1, int account2, long long money) {
        if(account1 > n || account2 > n || balance[account1 - 1] < money) {
            return false;
        }

        balance[account2 - 1] += money;
        balance[account1 - 1] -= money;
        return true;
    }
    
    bool deposit(int account, long long money) {
        if(account > n) {
            return false;
        }

        balance[account - 1] += money;
        return true;
    }
    
    bool withdraw(int account, long long money) {
        if(account > n || balance[account - 1] < money) {
            return false;
        }

        balance[account - 1] -= money;
        return true;
    }
};
```
