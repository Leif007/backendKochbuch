package htw_berlin.kochbuch_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeService service;

    Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @CrossOrigin
    @PostMapping("/recipe")
    public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe) {
        try {
            logger.info("Creating recipe: {}", recipe);

            // Log each field individually to verify
            logger.info("Name: {}", recipe.getName());
            logger.info("Description: {}", recipe.getDescription());
            // Add similar logs for other fields...

            Recipe savedRecipe = service.save(recipe);
            return ResponseEntity.ok(savedRecipe);
        } catch (Exception e) {
            logger.error("Error creating recipe", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create recipe: " + e.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable String id) {
        logger.info("GET request on route things with {}" + id);
        Long recipeId = Long.parseLong(id);
        return service.get(recipeId);
    }

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        try {
            Iterable<Recipe> recipesIterable = service.getAllRecipes();
            List<Recipe> recipesList = new ArrayList<>();
            recipesIterable.forEach(recipesList::add); // Convert Iterable to List
            return ResponseEntity.ok(recipesList);
        } catch (Exception e) {
            logger.error("Error fetching all recipes", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // You can customize the error response as needed
        }
    }




}
