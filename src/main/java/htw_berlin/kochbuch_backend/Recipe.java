package htw_berlin.kochbuch_backend;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int cookingTime;
    @ElementCollection
    private List<String> ingredients;
    @ElementCollection
    private List<String> instructions;
    private String dishType;
    private String mealTime;
    private String dietType;
    public Recipe(String name, String description, int cookingTime, List<String>
            ingredients, List<String> instructions, String dishType, String mealTime, String
                          dietType) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.dishType = dishType;
        this.mealTime = mealTime;
        this.dietType = dietType;
    }
    public Recipe() {} // leerer Konstruktor von Hibernate benötigt
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getCookingTime() {
        return cookingTime;
    }
    public List<String> getIngredients() { return ingredients; }
    public void setIngredients(List<String> ingredients) { this.ingredients =
            ingredients; }
    public List<String> getInstructions() { return instructions; }
    public void setInstructions(List<String> instructions) { this.instructions =
            instructions; }
    public String getDishType() {
        return dishType;
    }
    public String getMealTime() {
        return mealTime;
    }
    public String getDietType() {
        return dietType;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDietType(String dietType) {
        this.dietType = dietType;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }
    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }
    public void setDishType(String dishType) {
        this.dishType = dishType;
    }
}