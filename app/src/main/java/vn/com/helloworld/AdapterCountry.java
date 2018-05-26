package vn.com.helloworld;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Lrandom on 5/26/18.
 */

public class AdapterCountry extends ArrayAdapter<ModelCountry> {
    ArrayList<ModelCountry> countries;
    Context context;
    int resources;

    public AdapterCountry(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<ModelCountry> objects) {
        super(context, resource, objects);
        this.context=context;
        this.countries=objects;
        this.resources=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView=inflater.inflate(this.resources,null);
        }
        TextView tvName= (TextView)convertView.findViewById(R.id.tvName);
        TextView tvPopulation=(TextView)convertView.findViewById(R.id.tvPopulation);
        ModelCountry model = getItem(position);
        tvName.setText(model.getName());
        tvPopulation.setText(model.getPopulation());
        return convertView;
    }
}
