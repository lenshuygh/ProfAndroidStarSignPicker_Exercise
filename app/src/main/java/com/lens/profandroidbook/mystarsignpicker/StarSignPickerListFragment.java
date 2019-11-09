package com.lens.profandroidbook.mystarsignpicker;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Predicate;

import java.util.ArrayList;
import java.util.List;

public class StarSignPickerListFragment extends Fragment {
    private List<Starsign> starSigns = new ArrayList<>();
    private StarsignsRecyclerViewAdapter starsignsRecyclerViewAdapter = new StarsignsRecyclerViewAdapter(starSigns);

    private RecyclerView recyclerView;

    public StarSignPickerListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_star_signs_list, container, false);
        recyclerView = view.findViewById(R.id.list_star_signs);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = view.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(starsignsRecyclerViewAdapter);
    }

    public void setStarSigns(final List<Starsign> starSignsToAdd){
        Stream.of(starSignsToAdd).filter(new Predicate<Starsign>() {
            @Override
            public boolean test(Starsign s) {
                return !starSigns.contains(s);
            }
        }).forEach(new Consumer<Starsign>() {
            @Override
            public void accept(Starsign starsign) {
                StarSignPickerListFragment.this.addAndNotify(starsign);
            }
        });
    }

    private void addAndNotify(Starsign starsign){
        starSigns.add(starsign);
        starsignsRecyclerViewAdapter.notifyItemInserted(starSigns.indexOf(starsign));
    }
}
