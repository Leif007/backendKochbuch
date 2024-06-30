package htw_berlin.kochbuch_backend;
import htw_berlin.kochbuch_backend.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class RecipeService {
    @Autowired
    RecipeRepository repo;
    public Recipe save(Recipe recipe) {
        return repo.save(recipe);
    }
    public Recipe get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }
    public Iterable<Recipe> getAllRecipes() {
        return repo.findAll();
    }
    public Recipe update(Long id, Recipe updatedRecipe) {
        Recipe existingRecipe = repo.findById(id).orElseThrow(() -> new
                RuntimeException("Recipe not found"));
        existingRecipe.setName(updatedRecipe.getName());
        existingRecipe.setDescription(updatedRecipe.getDescription());
        existingRecipe.setCookingTime(updatedRecipe.getCookingTime());
        existingRecipe.setIngredients(updatedRecipe.getIngredients());
        existingRecipe.setInstructions(updatedRecipe.getInstructions());
        existingRecipe.setDishType(updatedRecipe.getDishType());
        existingRecipe.setMealTime(updatedRecipe.getMealTime());
        existingRecipe.setDietType(updatedRecipe.getDietType());
        return repo.save(existingRecipe);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
