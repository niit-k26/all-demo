package vn.com.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Lrandom on 5/29/18.
 */

public class ActivityDemoRecycleView extends AppCompatActivity{
    RecyclerView.Adapter adapter;
    ArrayList<ModelCountry> countries = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_recycle_view);
        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        for(int i = 0; i<50; i++){
            ModelCountry model = new ModelCountry();
            model.setName("Country"+i);
            model.setPopulation(i+"");
            countries.add(model);
        }
        adapter = new AdapterRecycleCountry(ActivityDemoRecycleView.this,countries,R.layout.row_country_item);
        //LinearLayoutManager linearLayoutManager =new LinearLayoutManager(ActivityDemoRecycleView.this);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(ActivityDemoRecycleView.this,3);
        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(ActivityDemoRecycleView.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        


    }
}
