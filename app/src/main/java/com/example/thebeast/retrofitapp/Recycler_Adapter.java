package com.example.thebeast.retrofitapp;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thebeast.retrofitapp.Model.Pojo;

import java.util.List;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.ViewHolder> {
    List<Pojo> bloglist;

    public Recycler_Adapter(List<Pojo> bloglist) {
        this.bloglist = bloglist;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String title_text = bloglist.get(position).getTitle();

        holder.setTitle(title_text);

    }



    @Override
    public int getItemCount() {
        return bloglist.size();//number of items to be populated in the recycler view
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView title;
        ConstraintLayout parentLayout;



        public ViewHolder(View itemView) {
            super(itemView);

            mView=itemView;
            parentLayout=mView.findViewById(R.id.parent_layout);
            title= mView.findViewById(R.id.title_text);

        }

        public  void setTitle(String title_text){

            title.setText(title_text);
        }






    }
}
