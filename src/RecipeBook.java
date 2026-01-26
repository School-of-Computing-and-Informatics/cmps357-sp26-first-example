// src/RecipeBook.java
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of recipes.
 * 
 * Supports add, remove, and retrieval operations.
 * Recipes are stored in insertion order.
 */
public class RecipeBook {
    private final ArrayList<Recipe> recipes = new ArrayList<>();

    /**
     * Create a new, empty RecipeBook.
     */
    public RecipeBook() {
        // recipes list is initialized above
    }

    /**
     * Add a recipe to the book.
     *
     * @param recipe the recipe to add; must not be null
     * @throws IllegalArgumentException if {@code recipe} is null
     */
    public void addRecipe(Recipe recipe) {
        if (recipe == null) {
            throw new IllegalArgumentException("Recipe cannot be null");
        }
        recipes.add(recipe);
    }

    /**
     * Remove a recipe by name.
     * 
     * Removal is based on exact name matching (case-sensitive).
     * If multiple recipes have the same name, only the first one is removed.
     *
     * @param name the name of the recipe to remove
     * @return true if a recipe was removed, false otherwise
     */
    public boolean removeRecipe(String name) {
        if (name == null) {
            return false;
        }
        
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getName().equals(name)) {
                recipes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Get all recipes in the book.
     * 
     * @return a new list containing all recipes in insertion order
     */
    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipes);
    }

    /**
     * Get the number of recipes in the book.
     *
     * @return the count of recipes
     */
    public int getRecipeCount() {
        return recipes.size();
    }
}
