package com.example.hobbies;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HobbyAdapter extends RecyclerView.Adapter<HobbyAdapter.ViewHolder> {
    private List<Hobby> hobbies;
    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(Hobby hobby);
    }
    void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    HobbyAdapter(List<Hobby> hobbies){this.hobbies = hobbies;};
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hobbies_row, null);
        return new ViewHolder(view, mListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(hobbies.get(position).getName());
        holder.hours.setText(String.valueOf(hobbies.get(position).getHours()));
    }

    @Override
    public int getItemCount() {
        return hobbies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, hours;
        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.hobby);
            hours = itemView.findViewById(R.id.hobbyHours);
            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int position = getAdapterPosition();
                            if(listener!= null && position != RecyclerView.NO_POSITION){
                                listener.onItemClick(hobbies.get(position));
                            }
                        }
                    }
            );
        }
    }
}
