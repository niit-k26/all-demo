package vn.com.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Lrandom on 5/26/18.
 */

public class ActivityDemoListView extends Activity {
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
    }
}
