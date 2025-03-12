package Recipes_Domain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchenwizard2.R;

import java.util.List;

public class RecipeAdaptor extends RecyclerView.Adapter<RecipeAdaptor.RecipeViewHolder> {

    private final List<Recipes> recipes;
    private final OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public RecipeAdaptor(List<Recipes> recipes, OnItemClickListener listener) {
        this.recipes = recipes;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredients_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipes recipe = recipes.get(position);

        holder.recipeName.setText(recipe.getName());
        holder.recipeCalories.setText(recipe.getCalories() + " kcal");
        // To load from a resource ID
        int imageResourceId = holder.itemView.getContext().getResources().getIdentifier(
             recipe.getImag(), "drawable", holder.itemView.getContext().getPackageName());
holder.recipeImage.setImageResource(imageResourceId);
        int imageResourceId2 = holder.itemView.getContext().getResources().getIdentifier(
                recipe.getImag(), "drawable", holder.itemView.getContext().getPackageName());
        holder.Fundal.setImageResource(imageResourceId2);


        // Set click listener for each item
        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public Recipes getRecipe(int position) {
        return recipes.get(position);
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;
        TextView recipeCalories;

       ImageView recipeImage;
       ImageView Fundal;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.ingredient); // TextView ID in recipe_item.xml
            recipeCalories = itemView.findViewById(R.id.quantiy); // TextView ID in recipe_item.xml
            recipeImage=itemView.findViewById(R.id.imageView);
            Fundal=itemView.findViewById(R.id.fundal);
        }
    }
}
