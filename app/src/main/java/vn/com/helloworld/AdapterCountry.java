package vn.com.helloworld;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView=inflater.inflate(this.resources,null);
            viewHolder= new ViewHolder();
            viewHolder.tvName =convertView.findViewById(R.id.tvName);
            viewHolder.tvPopulation=convertView.findViewById(R.id.tvPopulation);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        ModelCountry model = getItem(position);
        viewHolder.tvName.setText(model.getName());
        viewHolder.tvPopulation.setText(model.getPopulation());
        return convertView;
    }

    class ViewHolder{
        TextView tvName ;
        TextView tvPopulation;
    }
}
