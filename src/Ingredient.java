// src/Ingredient.java

/**
 * Represents a single ingredient entry with a name and amount.
 */
public class Ingredient {
    private final String name;
    private double amount;

    /**
     * Create a new Ingredient.
     *
     * @param name the ingredient name; must be non-null and not blank after trimming
     * @param amount the amount of the ingredient; must be greater than 0
     * @throws IllegalArgumentException if {@code name} is null/blank or {@code amount} <= 0
     */
    public Ingredient(String name, double amount) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingredient name must be non-null and non-blank");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Ingredient amount must be greater than 0");
        }
        this.name = name.trim();
        this.amount = amount;
    }

    /**
     * Get the ingredient name.
     *
     * @return the ingredient name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the ingredient amount.
     *
     * @return the ingredient amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Set the ingredient amount.
     *
     * @param amount the new amount; must be greater than 0
     * @throws IllegalArgumentException if {@code amount} <= 0
     */
    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Ingredient amount must be greater than 0");
        }
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + ": " + amount;
    }
}
