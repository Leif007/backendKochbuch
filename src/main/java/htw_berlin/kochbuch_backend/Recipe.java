package htw_berlin.kochbuch_backend;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String picture;
    private String description;
    private int preparationTime;
    private int cookingTime;
    @ElementCollection
    private List<String> ingredients;
    @ElementCollection
    private List<String> instructions;
    private String dishType;
    private String mealTime;
    private String dietType;







    public Recipe(Long id,String name, String picture, String description, int preparationTime, int cookingTime, List<String> ingredients, List<String> instructions, String dishType, String mealTime, String dietType) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.preparationTime = preparationTime;
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

    public int getPrepTime() {
        return preparationTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public List<String> getIngredients() { return ingredients; }
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public List<String> getInstructions() { return instructions; }
    public void setInstructions(List<String> instructions) { this.instructions = instructions; }

    public String getDishType() {
        return dishType;
    }

    public String getMealTime() {
        return mealTime;
    }

    public String getDietType() {
        return dietType;
    }



}


