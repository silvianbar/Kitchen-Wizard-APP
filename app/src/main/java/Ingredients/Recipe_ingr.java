package Ingredients;

import java.util.List;

public class Recipe_ingr {
    private String name;
    private String image;
    private final List<String> ingredients;

    public Recipe_ingr( List<String> ingredients) {
       // this.name = name;
        //this.image = image;
        this.ingredients = ingredients;
    }

//    public String getName() {
//        return name;
//    }

//    public String getImage() {
//        return image;
//    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
