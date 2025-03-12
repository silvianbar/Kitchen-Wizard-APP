package Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kitchenwizard2.R;

import java.util.ArrayList;

import Domain.CategoryDomain;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {
 ArrayList<CategoryDomain>categoryDomains;
 private final OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
 public CategoryAdaptor(ArrayList<CategoryDomain> categoryDomains, OnItemClickListener listener)
 {
     this.categoryDomains=categoryDomains;
     this.listener=listener;
 }
 @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate;
        inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate,listener);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdaptor.ViewHolder holder, int position) {
        CategoryDomain category = categoryDomains.get(position);
        holder.categoryName.setText(categoryDomains.get(position).GetTitle());
        String picUrl="";
        switch (position){
            case 0:{
                picUrl="rata";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background));
           break;
            }
            case 1: {
                picUrl="ic_launcher_background";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background));
            break;
            }
        }
        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);
    }
    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public CategoryDomain getCategory(int position) {
        if (position >= 0 && position < categoryDomains.size()) {
            return categoryDomains.get(position); // Returns the category if the index is valid
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView,OnItemClickListener listener){
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);
            mainLayout=itemView.findViewById(R.id.mainLayout);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }

}
