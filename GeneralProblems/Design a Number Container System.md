Leetcode Question : [Design a Number Container System](https://leetcode.com/problems/design-a-number-container-system/)

```java
class NumberContainers {
    HashMap<Integer, Integer> container;
    HashMap<Integer, TreeSet<Integer>> indices;
    public NumberContainers() {
        container = new HashMap<>();
        indices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        int prevNum = container.getOrDefault(index, -1);
        container.put(index, number);

        if(prevNum == number) return;

        if(prevNum != -1) {
            indices.get(prevNum).remove(index);
            if(indices.get(prevNum).isEmpty()) {
                indices.remove(prevNum);
            }
        }

        if(indices.containsKey(number)) {
            indices.get(number).add(index);
        }
        else {
            TreeSet<Integer> ts = new TreeSet<>();
            ts.add(index);
            indices.put(number, ts);
        }
    }
    
    public int find(int number) {
        if(indices.containsKey(number)) {
            return indices.get(number).first();
        }
        return -1;
    }
}
```
