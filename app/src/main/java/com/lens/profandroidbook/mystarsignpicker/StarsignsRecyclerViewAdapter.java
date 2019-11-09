package com.lens.profandroidbook.mystarsignpicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lens.profandroidbook.mystarsignpicker.databinding.ListItemStarsignsBinding;

import java.util.List;

public class StarsignsRecyclerViewAdapter extends RecyclerView.Adapter<StarsignsRecyclerViewAdapter.ViewHolder>  {
    private final List<Starsign> starSigns;

    public StarsignsRecyclerViewAdapter(List<Starsign> starSigns) {
        this.starSigns = starSigns;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemStarsignsBinding binding = ListItemStarsignsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Starsign starsign = starSigns.get(position);

        holder.binding.setStarsign(starsign);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return starSigns.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final ListItemStarsignsBinding binding;

        public ViewHolder(ListItemStarsignsBinding listItemStarsignsBinding) {
            super(listItemStarsignsBinding.getRoot());
            this.binding = listItemStarsignsBinding;
        }
    }
}
