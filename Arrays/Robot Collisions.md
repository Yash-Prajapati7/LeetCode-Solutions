Leetcode Question : [Robot Collisions](https://leetcode.com/problems/robot-collisions/)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    class Robot {
        int position;
        int health;
        char direction;
        int originalIndex;

        Robot(int position, int health, char direction, int originalIndex) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.originalIndex = originalIndex;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robots, (a, b) -> a.position - b.position);

        Stack<Robot> stack = new Stack<>();

        for (Robot currentRobot : robots) {
            if (currentRobot.direction == 'R') {
                stack.push(currentRobot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot topRobot = stack.pop();

                    if (topRobot.health > currentRobot.health) {
                        topRobot.health--;
                        stack.push(topRobot);
                        currentRobot = null;
                        break;
                    } else if (topRobot.health < currentRobot.health) {
                        currentRobot.health--;
                    } else {
                        currentRobot = null;
                        break;
                    }
                }

                if (currentRobot != null) {
                    stack.push(currentRobot);
                }
            }
        }

        List<Robot> survivors = new ArrayList<>(stack);
        Collections.sort(survivors, (a, b) -> a.originalIndex - b.originalIndex);

        List<Integer> result = new ArrayList<>();
        for (Robot robot : survivors) {
            result.add(robot.health);
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    class Robot {
    public:
        int position;
        int health;
        char direction;
        int originalIndex;

        Robot(int position, int health, char direction, int originalIndex) {
            this->position = position;
            this->health = health;
            this->direction = direction;
            this->originalIndex = originalIndex;
        }
    };

    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int n = positions.size();
        vector<Robot> robots;
        
        for (int i = 0; i < n; i++) {
            robots.push_back(Robot(positions[i], healths[i], directions[i], i));
        }

        sort(robots.begin(), robots.end(), [](Robot& a, Robot& b) {
            return a.position < b.position;
        });

        stack<Robot> st;

        for (auto& currentRobot : robots) {
            if (currentRobot.direction == 'R') {
                st.push(currentRobot);
            } else {
                while (!st.empty() && st.top().direction == 'R') {
                    Robot topRobot = st.top();
                    st.pop();

                    if (topRobot.health > currentRobot.health) {
                        topRobot.health--;
                        st.push(topRobot);
                        currentRobot.health = -1;
                        break;
                    } else if (topRobot.health < currentRobot.health) {
                        currentRobot.health--;
                    } else {
                        currentRobot.health = -1;
                        break;
                    }
                }

                if (currentRobot.health != -1) {
                    st.push(currentRobot);
                }
            }
        }

        vector<Robot> survivors;
        while (!st.empty()) {
            survivors.push_back(st.top());
            st.pop();
        }

        sort(survivors.begin(), survivors.end(), [](Robot& a, Robot& b) {
            return a.originalIndex < b.originalIndex;
        });

        vector<int> result;
        for (auto& robot : survivors) {
            result.push_back(robot.health);
        }

        return result;
    }
};
```

---

## Method - 2 (Optimized)

### Java

```java
class Solution {

    public List<Integer> survivedRobotsHealths(
        int[] positions,
        int[] healths,
        String directions
    ) {
        int n = positions.length;
        Integer[] sortedIndices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            sortedIndices[i] = i;
        }

        Arrays.sort(
            sortedIndices,
            (a, b) -> Integer.compare(positions[a], positions[b])
        );

        for (int currentIndex : sortedIndices) {
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.pop();

                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> survivedRobotsHealths(
        vector<int>& positions,
        vector<int>& healths,
        string directions
    ) {
        int n = positions.size();
        vector<int> sortedIndices(n);
        vector<int> result;
        stack<int> st;

        for (int i = 0; i < n; i++) {
            sortedIndices[i] = i;
        }

        sort(sortedIndices.begin(), sortedIndices.end(), [&](int a, int b) {
            return positions[a] < positions[b];
        });

        for (int currentIndex : sortedIndices) {
            if (directions[currentIndex] == 'R') {
                st.push(currentIndex);
            } else {
                while (!st.empty() && healths[currentIndex] > 0) {
                    int topIndex = st.top();
                    st.pop();

                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        st.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.push_back(healths[i]);
            }
        }

        return result;
    }
};
```
