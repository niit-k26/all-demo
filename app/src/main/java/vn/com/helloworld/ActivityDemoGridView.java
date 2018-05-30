package vn.com.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Lrandom on 5/29/18.
 */

public class ActivityDemoGridView extends AppCompatActivity {
    GridView gridView;
    AdapterCountry adapter;
    ArrayList<ModelCountry> countries = new ArrayList<ModelCountry>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_grid_view);
        gridView = (GridView)findViewById(R.id.gridView);
        for(int i = 0; i<15; i++){
            ModelCountry model = new ModelCountry();
            model.setName("Country"+i);
            model.setPopulation(i+"");
            countries.add(model);
        }
        adapter = new AdapterCountry(ActivityDemoGridView.this,R.layout.row_country_item,countries);
        gridView.setAdapter(adapter);
    }
}
