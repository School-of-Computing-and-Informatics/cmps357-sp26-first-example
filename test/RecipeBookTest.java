// test/RecipeBookTest.java

/**
 * Tests for the RecipeBook class.
 */
public class RecipeBookTest {

    public static void main(String[] args) {
        testAddRecipe();
        testRemoveRecipe();
        testRemoveNonExistentRecipe();
        testGetAllRecipes();
        testGetRecipeCount();
        testRemoveWithNullName();
        testAddNullRecipe();
        testRemoveDuplicateNames();
        
        System.out.println("\nAll RecipeBook tests passed!");
    }

    private static void testAddRecipe() {
        RecipeBook book = new RecipeBook();
        Recipe r = new Recipe("Pasta", 2);
        book.addRecipe(r);
        
        assertEquals(1, book.getRecipeCount(), "Recipe count after add");
        assertEquals(1, book.getAllRecipes().size(), "getAllRecipes size");
        assertEquals("Pasta", book.getAllRecipes().get(0).getName(), "Recipe name");
        
        System.out.println("✓ testAddRecipe passed");
    }

    private static void testRemoveRecipe() {
        RecipeBook book = new RecipeBook();
        Recipe r1 = new Recipe("Pasta", 2);
        Recipe r2 = new Recipe("Pizza", 4);
        book.addRecipe(r1);
        book.addRecipe(r2);
        
        boolean removed = book.removeRecipe("Pasta");
        assertTrue(removed, "removeRecipe should return true");
        assertEquals(1, book.getRecipeCount(), "Recipe count after remove");
        assertEquals("Pizza", book.getAllRecipes().get(0).getName(), "Remaining recipe");
        
        System.out.println("✓ testRemoveRecipe passed");
    }

    private static void testRemoveNonExistentRecipe() {
        RecipeBook book = new RecipeBook();
        Recipe r = new Recipe("Pasta", 2);
        book.addRecipe(r);
        
        boolean removed = book.removeRecipe("Pizza");
        assertFalse(removed, "removeRecipe should return false for non-existent recipe");
        assertEquals(1, book.getRecipeCount(), "Recipe count should not change");
        
        System.out.println("✓ testRemoveNonExistentRecipe passed");
    }

    private static void testGetAllRecipes() {
        RecipeBook book = new RecipeBook();
        Recipe r1 = new Recipe("Pasta", 2);
        Recipe r2 = new Recipe("Pizza", 4);
        Recipe r3 = new Recipe("Salad", 1);
        book.addRecipe(r1);
        book.addRecipe(r2);
        book.addRecipe(r3);
        
        java.util.List<Recipe> recipes = book.getAllRecipes();
        assertEquals(3, recipes.size(), "getAllRecipes size");
        
        // Verify insertion order is preserved
        assertEquals("Pasta", recipes.get(0).getName(), "First recipe");
        assertEquals("Pizza", recipes.get(1).getName(), "Second recipe");
        assertEquals("Salad", recipes.get(2).getName(), "Third recipe");
        
        System.out.println("✓ testGetAllRecipes passed");
    }

    private static void testGetRecipeCount() {
        RecipeBook book = new RecipeBook();
        assertEquals(0, book.getRecipeCount(), "Initial count");
        
        book.addRecipe(new Recipe("Pasta", 2));
        assertEquals(1, book.getRecipeCount(), "Count after one add");
        
        book.addRecipe(new Recipe("Pizza", 4));
        assertEquals(2, book.getRecipeCount(), "Count after two adds");
        
        book.removeRecipe("Pasta");
        assertEquals(1, book.getRecipeCount(), "Count after remove");
        
        System.out.println("✓ testGetRecipeCount passed");
    }

    private static void testRemoveWithNullName() {
        RecipeBook book = new RecipeBook();
        book.addRecipe(new Recipe("Pasta", 2));
        
        boolean removed = book.removeRecipe(null);
        assertFalse(removed, "removeRecipe with null should return false");
        assertEquals(1, book.getRecipeCount(), "Recipe count should not change");
        
        System.out.println("✓ testRemoveWithNullName passed");
    }

    private static void testAddNullRecipe() {
        RecipeBook book = new RecipeBook();
        
        try {
            book.addRecipe(null);
            fail("Adding null recipe should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected
        }
        
        assertEquals(0, book.getRecipeCount(), "Recipe count should remain 0");
        
        System.out.println("✓ testAddNullRecipe passed");
    }

    private static void testRemoveDuplicateNames() {
        RecipeBook book = new RecipeBook();
        Recipe r1 = new Recipe("Pasta", 2);
        Recipe r2 = new Recipe("Pasta", 4);  // Same name, different servings
        book.addRecipe(r1);
        book.addRecipe(r2);
        
        assertEquals(2, book.getRecipeCount(), "Count before remove");
        
        // Should remove only the first one
        boolean removed = book.removeRecipe("Pasta");
        assertTrue(removed, "removeRecipe should return true");
        assertEquals(1, book.getRecipeCount(), "Count after remove");
        
        // Verify the second one remains (it should have 4 servings)
        // We can't directly check servings without a getter, but we can verify the name
        assertEquals("Pasta", book.getAllRecipes().get(0).getName(), "Remaining recipe name");
        
        System.out.println("✓ testRemoveDuplicateNames passed");
    }

    // Helper assertion methods
    private static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + ": expected " + expected + " but got " + actual);
        }
    }

    private static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + ": expected '" + expected + "' but got '" + actual + "'");
        }
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }

    private static void fail(String message) {
        throw new AssertionError(message);
    }
}
