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

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.onItemClickListener=mItemClickListener;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvName;
        TextView tvPopulation;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvName=(TextView)itemView.findViewById(R.id.tvName);
            tvPopulation=(TextView)itemView.findViewById(R.id.tvPopulation);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(onItemClickListener!=null){
                onItemClickListener.OnItemClick(view,getAdapterPosition());
            }
        }
    }

    public interface OnItemClickListener{
        public void OnItemClick(View v, int position);
    }
}
