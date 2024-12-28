Leetcode Question : [Number of Burgers with No Waste of Ingredients](https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/)

```java
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>(2);
        int t = tomatoSlices, c = cheeseSlices;
        if((c > t) || (t % 2 != 0)) {
            return ans;
        }

        int jumbo = (t - (c << 1)) >> 1;
        if(jumbo < 0 || jumbo > c) return ans;
        int small = c - jumbo;
        ans.add(jumbo);
        ans.add(small);
        return ans;
    }
}
```

## Note - Make use of this condition
```
X = Jumbo
Y = Small
        
4X + 2Y = tomato
X + Y = cheese
```
