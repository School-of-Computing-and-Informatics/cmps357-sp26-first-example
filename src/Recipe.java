
    // src/Recipe.java
import java.util.ArrayList;

public class Recipe {
    private final String name;
    private int servings;

    // Parallel lists to keep Day-1 Java simple (no extra classes required).
    private final ArrayList<String> ingredientNames = new ArrayList<>();
    private final ArrayList<Double> ingredientAmounts = new ArrayList<>();

    public Recipe(String name, int servings) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must be non-empty");
        }
        if (servings <= 0) {
            throw new IllegalArgumentException("servings must be positive");
        }
        this.name = name;
        this.servings = servings;
    }



    /**
     * Adds an ingredient and its amount to the recipe.
     *
     * <p>The ingredient is only added if both inputs are valid:
     * <ul>
     *   <li>{@code ingredientName} must be non-null and not blank</li>
     *   <li>{@code amount} must be greater than 0</li>
     * </ul>
     *
     * <p>If either input is invalid, this method leaves the recipe unchanged
     * and prints a debug message to standard output.
     *
     * @param ingredientName the name of the ingredient
     * @param amount the amount of the ingredient
     */
   public void addIngredient(String ingredientName, double amount) {
        // TODO:
        // - Validate ingredientName non-null and non-blank
        // - Validate amount > 0
        // - Add to ingredientNames and ingredientAmounts in matching positions
        // - done below
    if (ingredientName == null || ingredientName.trim().isEmpty()) {
        throw new IllegalArgumentException("Ingredient name cannot be null or blank");
    }
    if (amount <= 0) {
        throw new IllegalArgumentException("Amount must be greater than 0");
    }

    ingredientNames.add(ingredientName);
    ingredientAmounts.add(amount);
}


    public int totalIngredientCount() {
        // TODO: return number of ingredient entries
        return ingredientNames.size();
        //throw new UnsupportedOperationException("TODO");
    }

     
public void scaleToServings(int newServings) {

           // TODO:
        // - If newServings <= 0 throw IllegalArgumentException
        // - Compute factor = (double) newServings / servings
        // - Multiply each ingredient amount by factor
        // - Update servings
    if (newServings <= 0) {
        throw new IllegalArgumentException("Servings must be greater than 0");
    }

    double factor = (double) newServings / servings;

    for (int i = 0; i < ingredientAmounts.size(); i++) {
        double scaled = ingredientAmounts.get(i) * factor;
        ingredientAmounts.set(i, scaled);
    }

    servings = newServings;
}
     
    public String toString() {
           // TODO:
        // Return:
        // <name> (serves <servings>)
        // - <amount> <ingredient>
        // ...
        //
        // Use formatAmount(double) helper for printing amounts.
    StringBuilder sb = new StringBuilder();

    // First line: <name> (serves <servings>)
    sb.append(name).append(" (serves ").append(servings).append(")\n");

    // Each ingredient line:
    // - <amount> <ingredient>
    for (int i = 0; i < ingredientNames.size(); i++) {
        sb.append("- ")
          .append(formatAmount(ingredientAmounts.get(i)))
          .append(" ")
          .append(ingredientNames.get(i))
          .append("\n");
    }

    return sb.toString();
}

    

     private String formatAmount(double x) {
           // Spec:
        // - If x is an integer value, print without decimals.
        // - Else print with up to 2 decimals, trimming trailing zeros.
        //
        // Examples:
        // 200.0 -> "200"
        // 7.5 -> "7.5"
        // 0.625 -> "0.63"
        // 1.333 -> "1.33"
        //
        // TODO: implement.
    // If x is an integer (like 200.0, 3.0, etc)
    if (x == Math.floor(x)) {
        return String.valueOf((long) x);
    }

    // Otherwise round to 2 decimals
    double rounded = Math.round(x * 100.0) / 100.0;

    // Convert to string
    String s = String.valueOf(rounded);

    // Trim trailing zeros
    if (s.contains(".")) {
        while (s.endsWith("0")) {
            s = s.substring(0, s.length() - 1);
        }
        if (s.endsWith(".")) {
            s = s.substring(0, s.length() - 1);
        }
    }

    return s;
}

}
