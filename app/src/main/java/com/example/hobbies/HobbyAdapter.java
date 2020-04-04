package com.example.hobbies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HobbyAdapter extends RecyclerView.Adapter<HobbyAdapter.ViewHolder> {
    List<Hobby> hobbies;
    public HobbyAdapter(List<Hobby> hobbies){this.hobbies = hobbies;};
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hobbies_row, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(hobbies.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return hobbies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.hobby);
        }
    }
}
