Leetcode Question : [Design Movie Rental System](https://leetcode.com/problems/design-movie-rental-system)

### Java

```java
class MovieRentingSystem {
    Map<Integer, TreeSet<int[]>> movieMap; // movie -> available shops
    TreeSet<int[]> rented; // all rented movies. stored as [price, shop, movie]
    Map<String, Integer> priceMap; // (shop,movie) -> price
    
    public MovieRentingSystem(int n, int[][] entries) {
        movieMap = new HashMap<>();
        priceMap = new HashMap<>();
        
        rented = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // price
            if (a[1] != b[1]) return a[1] - b[1]; // shop
            return a[2] - b[2]; // movie
        });
        
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "#" + movie, price);
            movieMap.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // price
                return a[1] - b[1]; // shop
            })).add(new int[]{price, shop});
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!movieMap.containsKey(movie)) return res;
        
        TreeSet<int[]> set = movieMap.get(movie);
        Iterator<int[]> it = set.iterator();
        
        while (it.hasNext() && res.size() < 5) {
            res.add(it.next()[1]); // shop
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        movieMap.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }
    
    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        rented.remove(new int[]{price, shop, movie});
        movieMap.get(movie).add(new int[]{price, shop});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<int[]> it = rented.iterator();
        
        while (it.hasNext() && res.size() < 5) {
            int[] cur = it.next();
            res.add(Arrays.asList(cur[1], cur[2])); // [shop, movie]
        }
        return res;
    }
}
```
