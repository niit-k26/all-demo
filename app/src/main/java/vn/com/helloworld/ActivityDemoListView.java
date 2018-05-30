package vn.com.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Lrandom on 5/26/18.
 */

public class ActivityDemoListView extends Activity implements AbsListView.OnScrollListener{
    ListView listView;
    AdapterCountry adapter;
    ArrayList<ModelCountry> countries = new ArrayList<ModelCountry>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_listview);
        listView =(ListView)findViewById(R.id.lstView);
        for(int i = 0; i<15; i++){
            ModelCountry model = new ModelCountry();
            model.setName("Country"+i);
            model.setPopulation(i+"");
            countries.add(model);
        }
        adapter = new AdapterCountry(ActivityDemoListView.this,R.layout.row_country_item,countries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("TAG","You choose "+countries.get(i).getName());
            }
        });
        listView.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        Log.e("I1",i+"");
        Log.e("I2",i1+"");
        Log.e("I3",i2+"");
        //adapter.notifyDataSetChanged();

        //loadMore
        if(i+i1==i2){
            for(int j = 0; j<15; j++){
                ModelCountry model = new ModelCountry();
                model.setName("Country"+j);
                model.setPopulation(j+"");
                countries.add(model);
            }
            adapter.notifyDataSetChanged();
        }
    }
}
