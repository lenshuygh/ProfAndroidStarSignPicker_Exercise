package com.lens.profandroidbook.mystarsignpicker;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StarSignPickerAdapter extends RecyclerView.Adapter<StarSignPickerAdapter.ViewHolder> {
    private String[] starSigns = {"Aries","Taurus","Gemini","Cancer","Leo","Virgo","Libra","Scorpio","Sagittarius","Capricorn","Aquarius","Pisces"};

    public StarSignPickerAdapter() {
    }

    @Override
    public int getItemCount() {
        return starSigns == null ? 0 : starSigns.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public View.OnClickListener myListener;

        public ViewHolder (View view,View.OnClickListener listener){
            super(view);
            myListener = listener;
            textView = view.findViewById(R.id.itemTextView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(myListener != null){
                myListener.onClick(view);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,parent,false);
        return new ViewHolder(view, null);
    }

    public interface IAdapterItemClick {
        void onItemClicked(String selectedItem);
    }

    IAdapterItemClick myAdapterItemClickListener;

    public void settOnAdapterItemClick(IAdapterItemClick adapterItemClickHandler){
        myAdapterItemClickListener = adapterItemClickHandler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(starSigns[position]);
        holder.myListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(myAdapterItemClickListener != null){
                    myAdapterItemClickListener.onItemClicked(starSigns[position]);
                }
            }
        };
    }
}
