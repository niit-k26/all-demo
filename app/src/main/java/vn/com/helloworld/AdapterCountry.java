package vn.com.helloworld;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView=inflater.inflate(this.resources,null);
            viewHolder= new ViewHolder();
            viewHolder.tvName =convertView.findViewById(R.id.tvName);
            viewHolder.tvPopulation=convertView.findViewById(R.id.tvPopulation);
            viewHolder.imgButton = convertView.findViewById(R.id.btnMenu);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        ModelCountry model = getItem(position);
        viewHolder.tvName.setText(model.getName());
        viewHolder.tvPopulation.setText(model.getPopulation());


        viewHolder.imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setTag(position);
                setMenu(view);
            }
        });

        return convertView;
    }

    class ViewHolder{
        TextView tvName ;
        TextView tvPopulation;
        ImageButton imgButton;
    }

    void setMenu(final View v){
        PopupMenu popupMenu  = new PopupMenu(context,v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                int position=(Integer)v.getTag();

                switch (id){
                    case R.id.item_add:
                        ModelCountry country = countries.get(position);
                        Toast ts= Toast.makeText(context,"You choose"+countries.get(position).getName(),Toast.LENGTH_SHORT);
                        ts.show();
                        break;

                    case R.id.item_edit:
                        break;

                    case R.id.item_delete:
                        break;
                }
                return false;
            }
        });

        popupMenu.inflate(R.menu.menu_countries);
        popupMenu.show();
    }
}
