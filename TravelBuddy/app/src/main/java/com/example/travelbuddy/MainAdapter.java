package com.example.travelbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<RecyclerViewAdapter> mainModels;
    Context context;

    public MainAdapter(Context context, ArrayList<RecyclerViewAdapter> mainModels) {
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.photo.setImageResource(mainModels.get(position).getPhoto());
        holder.namechar.setText(mainModels.get(position).getChardham());
    }


    @Override
    public int getItemCount() {
        return mainModels.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
      TextView namechar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            namechar=itemView.findViewById(R.id.namechar);


        }

    }
}
