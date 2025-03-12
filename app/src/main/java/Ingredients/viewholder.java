package Ingredients;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchenwizard2.R;

public class viewholder extends RecyclerView.ViewHolder {
    public TextView ingredientText;
    public viewholder(View itemView) {
        super(itemView);
        ingredientText = itemView.findViewById(R.id.ingredient_text_view); // Your TextView ID for ingredient
    }
}
