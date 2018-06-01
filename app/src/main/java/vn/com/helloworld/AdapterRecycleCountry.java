package vn.com.helloworld;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lrandom on 5/29/18.
 */

public class AdapterRecycleCountry extends RecyclerView.Adapter<AdapterRecycleCountry.RecyclerViewHolder> {
    Context context;
    ArrayList<ModelCountry> countries;
    int resources;
    OnItemClickListener onItemClickListener;

    AdapterRecycleCountry(Context context, ArrayList<ModelCountry> countries, int resources){
        this.context=context;
        this.countries=countries;
        this.resources=resources;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View v= inflater.inflate(this.resources,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tvName.setText(this.countries.get(position).getName());
        holder.tvPopulation.setText(this.countries.get(position).getPopulation());
    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvPopulation;


        public RecyclerViewHolder(final View itemView) {
            super(itemView);
            tvName=(TextView)itemView.findViewById(R.id.tvName);
            tvPopulation=(TextView)itemView.findViewById(R.id.tvPopulation);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick(view,getAdapterPosition());
                    }
                }
            });
        }
    }

    interface OnItemClickListener{
        public void onItemClick(View v, int position);
    }

}
