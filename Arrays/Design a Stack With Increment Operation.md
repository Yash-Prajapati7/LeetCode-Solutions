Leetcode Question : [Design a Stack With Increment Operation](https://leetcode.com/problems/design-a-stack-with-increment-operation/)

### Java
```java
class CustomStack {
    public int size;
    public int top = -1;
    public int[] s;
    
    public CustomStack(int maxSize) {
        size = maxSize;
        s = new int[size];
    }
    
    public void push(int x) {
        if(top != size - 1) {
            s[++top] = x;
        }
    }
    
    public int pop() {
        if(top == -1) {
            return -1;
        }
        int val = s[top--];
        return val;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; (i < k) && (i < size); i++) {
            s[i] += val;
        }
    }
}
```

### C++
```cpp
class CustomStack {
public:
    int size;
    int top = -1;
    int* s;

    CustomStack(int maxSize) {
        size = maxSize;
        s = new int[size];
    }

    void push(int x) {
        if(top != size - 1) {
            s[++top] = x;
        }
    }

    int pop() {
        if(top == -1) {
            return -1;
        }
        int val = s[top--];
        return val;
    }

    void increment(int k, int val) {
        for(int i = 0; (i < k) && (i < size); i++) {
            s[i] += val;
        }
    }
};
```
