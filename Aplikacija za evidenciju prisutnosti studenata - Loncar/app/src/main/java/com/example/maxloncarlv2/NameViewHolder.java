package com.example.maxloncarlv2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView ivCross;
    private TextView textName;
    private NameClickListener clickListener;
    private int position;

    public NameViewHolder(@NonNull View itemView, NameClickListener listener) {
        super(itemView);
        this.clickListener = listener;
        ivCross = itemView.findViewById(R.id.ivCross);
        textName = itemView.findViewById(R.id.tvName);
        ivCross.setOnClickListener(this);
    }

    public void setName(String name){
        textName.setText(name);
    }

    @Override
    public void onClick(View view) {
        position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION){
            clickListener.onCrossClick(position);
        }
    }
}
