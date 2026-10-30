Leetcode Question : [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)

### Java

```
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] minCost = new int[n];
        List<List<int[]>> adj = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            minCost[i] = Integer.MAX_VALUE;
        }

        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[] { flight[1], flight[2] }); // [src] : [dest, cost]
        }

        Queue<int[]> q = new LinkedList<>();
        int stops = 0, size = 0;
        int price = 0, neighbourNode = 0;
        int[] current;
        q.offer(new int[] {src, 0});    // stores {node, totalCost}

        while(!q.isEmpty() && stops <= k) {
            size = q.size();

            while(size-- > 0) {
                current = q.poll();
                for(int[] neighbour : adj.get(current[0])) {
                    neighbourNode = neighbour[0];
                    price = neighbour[1];

                    if(price + current[1] < minCost[neighbourNode]) {
                        minCost[neighbourNode] = price + current[1];
                        q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
                    }
                }
            }

            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
```

### C++

```
using namespace std;

class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<int> minCost(n, INT_MAX);
        vector<vector<vector<int>>> adj(n);

        for(int i = 0; i < n; i++) {
            minCost[i] = INT_MAX;
        }

        for(vector<int>& flight : flights) {
            adj[flight[0]].push_back({flight[1], flight[2]}); // [src] : [dest, cost]
        }

        queue<vector<int>> q;
        int stops = 0, size = 0;
        int price = 0, neighbourNode = 0;
        vector<int> current;
        q.push({src, 0});    // stores {node, totalCost}

        while(!q.empty() && stops <= k) {
            size = q.size();

            while(size-- > 0) {
                current = q.front();
                q.pop();

                for(vector<int>& neighbour : adj[current[0]]) {
                    neighbourNode = neighbour[0];
                    price = neighbour[1];

                    if(price + current[1] < minCost[neighbourNode]) {
                        minCost[neighbourNode] = price + current[1];
                        q.push({neighbourNode, minCost[neighbourNode]});
                    }
                }
            }

            stops++;
        }

        return minCost[dst] == INT_MAX ? -1 : minCost[dst];
    }
};
```
