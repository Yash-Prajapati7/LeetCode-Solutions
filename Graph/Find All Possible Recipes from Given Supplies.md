Leetcode Question : [Find All Possible Recipes from Given Supplies](https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/)

### Java
```java
class Solution {

    public List<String> findAllRecipes(String[] recipeList, List<List<String>> ingredientList, String[] availableSupplies) {
        List<String> possibleRecipes = new ArrayList<>();
        Map<String, Boolean> canPrepare = new HashMap<>();
        Map<String, Integer> recipeIndexMap = new HashMap<>();

        for (String supply : availableSupplies) {
            canPrepare.put(supply, true);
        }

        for (int i = 0; i < recipeList.length; i++) {
            recipeIndexMap.put(recipeList[i], i);
        }

        for (String recipe : recipeList) {
            evaluateRecipe(recipe, ingredientList, new HashSet<>(), canPrepare, recipeIndexMap);
            if (canPrepare.get(recipe)) {
                possibleRecipes.add(recipe);
            }
        }

        return possibleRecipes;
    }

    private void evaluateRecipe(String recipe, List<List<String>> ingredientList, Set<String> processingRecipes, 
                                Map<String, Boolean> canPrepare, Map<String, Integer> recipeIndexMap) {
        if (canPrepare.containsKey(recipe) && canPrepare.get(recipe)) {
            return;
        }

        if (!recipeIndexMap.containsKey(recipe) || processingRecipes.contains(recipe)) {
            canPrepare.put(recipe, false);
            return;
        }

        processingRecipes.add(recipe);
        List<String> requiredIngredients = ingredientList.get(recipeIndexMap.get(recipe));
        for (String ingredient : requiredIngredients) {
            evaluateRecipe(ingredient, ingredientList, processingRecipes, canPrepare, recipeIndexMap);
            if (!canPrepare.get(ingredient)) {
                canPrepare.put(recipe, false);
                return;
            }
        }

        canPrepare.put(recipe, true);
    }
}
```
