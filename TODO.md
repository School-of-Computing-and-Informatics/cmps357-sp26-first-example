# TODO: cmps357-sp26-first-example

## Implementation Plan (from initial outline)
- Create implementation plan for `src/Recipe.java`.
- Inspect `src/Recipe.java` to identify TODOs and missing methods.
- Design ingredient storage (parallel lists used for Day-1 simplicity).
- Implement methods one at a time:
  - `addIngredient(String, double)` (already present)
  - `totalIngredientCount()`
  - `scaleToServings(int)`
  - `toString()` / `toPrettyString()` (print formatted recipe)
  - `formatAmount(double)` (helper for printing amounts)
- Verify by compiling and running `Main` and matching `SPEC.md` expected output.

## Work completed
- Added Javadoc to `Recipe` constructor and public methods (`totalIngredientCount()`, `scaleToServings(int)`, `toString()`) and to `Main.main`.
- Implemented `totalIngredientCount()`.
- Implemented `scaleToServings(int)` with validation and scaling.
- Implemented `toString()` (prints name, servings, and ingredient lines) and `formatAmount(double)` for compact amount formatting.
- Preserved original `// TODO` inline comments inside `src/Recipe.java` while adding Javadoc.
- Updated `addIngredient(String,double)` to ignore invalid inputs (null/blank name or non-positive amount) rather than throwing; the method prints a brief debug message when ignoring an entry to aid debugging.
- Added and ran tests in [test/RecipeTest.java](test/RecipeTest.java); all tests passed.

## Remaining / Suggested tasks
- Consider adding a `toPrettyString()` if you want a separate pretty-print API (optional; currently `toString()` is used).
- Optionally change `addIngredient` debug prints from `System.out` to `System.err` or return a boolean to signal ignored entries.
- Replace the parallel lists with an `Ingredient` value object for clarity when the project grows.
- Add more unit tests for edge cases and any future public API changes.

## Verification commands
To compile and run locally:

```bash
javac -d bin src/*.java
java -cp bin Main

# compile and run tests (no external deps)
javac -d bin src/*.java test/*.java
java -cp bin RecipeTest
```

## File references
- Implementation: [src/Recipe.java](src/Recipe.java)
- Runner: [src/Main.java](src/Main.java)
- Spec: [SPEC.md](SPEC.md)
- README: [README.md](README.md)


---

If you want, I can (pick one):
- update `SPEC.md` to match the current implementation,
- change `addIngredient` to return a boolean instead of printing when rejecting invalid input,
- commit the changes to git with a clear message, or
- add more unit tests or CI integration.
