package vn.com.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
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
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_listview);
        listView =(ListView)findViewById(R.id.lstView);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeLayout);

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
        //listView.setOnScrollListener(this);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 15; i<30; i++){
                            ModelCountry model = new ModelCountry();
                            model.setName("Country"+i);
                            model.setPopulation(i+"");
                            countries.add(0,model);
                        }
                        adapter.notifyDataSetChanged();
                        listView.setSelection(0);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
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
