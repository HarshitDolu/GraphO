package com.example.grapho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.example.grapho.Adapters.AlgoAdapter;
import com.example.grapho.Models.algoModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclarview);
        ArrayList<algoModel> list=new ArrayList<>();
        list.add(new algoModel(R.drawable.dfs,"Graph basics"));
        list.add(new algoModel(R.drawable.dfs,"Depth first Traversal"));
        list.add(new algoModel(R.drawable.bfs,"Breadth first Traversal"));
        list.add(new algoModel(R.drawable.cycle,"Cycle detection"));
        list.add(new algoModel(R.drawable.topo,"Topological sort"));



        AlgoAdapter adapter=new AlgoAdapter(list,this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

       //StaggeredGridLayoutManager stag=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(stag);
        //LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);


    }
}
