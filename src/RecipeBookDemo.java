// src/RecipeBookDemo.java

/**
 * Demonstrates the RecipeBook functionality.
 */
public class RecipeBookDemo {
    public static void main(String[] args) {
        RecipeBook book = new RecipeBook();

        // Create some recipes
        Recipe pasta = new Recipe("Pasta Aglio e Olio", 2);
        pasta.addIngredient("spaghetti (g)", 200);
        pasta.addIngredient("garlic cloves", 3);
        pasta.addIngredient("olive oil (cup)", 0.25);
        pasta.addIngredient("red pepper flakes (tsp)", 0.5);
        pasta.addIngredient("parsley (cup)", 0.25);

        Recipe pizza = new Recipe("Margherita Pizza", 4);
        pizza.addIngredient("pizza dough (g)", 400);
        pizza.addIngredient("tomato sauce (cup)", 0.5);
        pizza.addIngredient("mozzarella (g)", 200);
        pizza.addIngredient("basil leaves", 10);

        Recipe salad = new Recipe("Caesar Salad", 2);
        salad.addIngredient("romaine lettuce (head)", 1);
        salad.addIngredient("parmesan cheese (g)", 50);
        salad.addIngredient("croutons (cup)", 0.5);
        salad.addIngredient("caesar dressing (tbsp)", 3);

        // Add recipes to the book
        book.addRecipe(pasta);
        book.addRecipe(pizza);
        book.addRecipe(salad);

        System.out.println("=== Recipe Book ===");
        System.out.println("Total recipes: " + book.getRecipeCount());
        System.out.println();

        // Display all recipes
        System.out.println("All recipes:");
        System.out.println("-".repeat(50));
        for (Recipe recipe : book.getAllRecipes()) {
            System.out.print(recipe.toString());
            System.out.println();
        }

        // Remove a recipe
        System.out.println("Removing 'Margherita Pizza'...");
        boolean removed = book.removeRecipe("Margherita Pizza");
        System.out.println("Removed: " + removed);
        System.out.println("Total recipes: " + book.getRecipeCount());
        System.out.println();

        // Display remaining recipes
        System.out.println("Remaining recipes:");
        System.out.println("-".repeat(50));
        for (Recipe recipe : book.getAllRecipes()) {
            System.out.print(recipe.toString());
            System.out.println();
        }

        // Try to remove a non-existent recipe
        System.out.println("Attempting to remove 'Sushi'...");
        removed = book.removeRecipe("Sushi");
        System.out.println("Removed: " + removed);
        System.out.println("Total recipes: " + book.getRecipeCount());
    }
}
