package Recipes_Domain;

public class Recipes {
    private final String name;
    private final String ingredients;
    private final String steps;
    private final String calories;
   // private final int difficulty;

    private final String imag;
   //private final String imag_mic;
//    private final String imag_stanga1;
//    private final String imag_stanga2;

    public Recipes(String name, String ingredients,String steps, String calories, String imag) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.calories = calories;
       // this.difficulty = difficulty;
        this.imag=imag;
//        this.imag_mic=imag_mic;
//        this.imag_stanga1=imag_stanga1;
//        this.imag_stanga2=imag_stanga2;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public String getCalories() {
        return calories;
    }

//    public int getDifficulty() {
//        return difficulty;
//    }

    public String getImag() {
        return imag;
    }

//    public String getImag_mic() {
//        return imag_mic;
//    }
//
//    public String getImag_stanga1() {
//        return imag_stanga1;
//    }
//
//    public String getImag_stanga2() {
//        return imag_stanga2;
//    }
}
