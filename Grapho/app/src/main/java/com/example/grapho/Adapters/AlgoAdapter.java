package com.example.grapho.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grapho.BfsActivity;
import com.example.grapho.BsicActivity;
import com.example.grapho.CycleActivity;
import com.example.grapho.DfsActivity;
import com.example.grapho.Models.algoModel;
import com.example.grapho.R;
import com.example.grapho.TopoActivity;

import java.util.ArrayList;

public class AlgoAdapter extends RecyclerView.Adapter<AlgoAdapter.viewHolder> {
    public AlgoAdapter(ArrayList<algoModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    ArrayList<algoModel>list;
Context context;
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.sample_recyclarview,parent,false);


        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        algoModel model=list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());

        switch(position){
            case 0:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Graph basics is clicked",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, BsicActivity.class);
                        context.startActivity(intent);



                    }
                });

                break;
            case 1:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"DFS is clicked",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, DfsActivity.class);
                        context.startActivity(intent);



                    }
                });

                break;


            case 2:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"BFS is clicked",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, BfsActivity.class);
                        context.startActivity(intent);



                    }
                });

                break;



            case 3:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Cycle detection is clicked",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, CycleActivity.class);
                        context.startActivity(intent);



                    }
                });

                break;


            case 4:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Topological sort is clicked",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, TopoActivity.class);
                        context.startActivity(intent);



                    }
                });
                break;

        }

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imv);
            textView=itemView.findViewById(R.id.tv);

        }
    }
}
