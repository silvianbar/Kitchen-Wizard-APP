package Ingredients;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchenwizard2.R;

import java.util.List;

public class adapter extends RecyclerView.Adapter<viewholder> {
    private final List<String> ingredients;

    public adapter(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingredient, parent, false);
        return new viewholder(view);
    }


    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.ingredientText.setText(ingredients.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}