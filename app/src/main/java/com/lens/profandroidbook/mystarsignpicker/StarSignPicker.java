package com.lens.profandroidbook.mystarsignpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StarSignPicker extends AppCompatActivity {
    public static final String EXTRA_SIGN_NAME = "SIGN_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_sign_picker);
        StarSignPickerAdapter adapter = new StarSignPickerAdapter();
        adapter.settOnAdapterItemClick(new StarSignPickerAdapter.IAdapterItemClick() {
            @Override
            public void onItemClicked(String selectedItem) {
                Intent outDataIntent = new Intent();
                outDataIntent.putExtra(EXTRA_SIGN_NAME, selectedItem);
                setResult(Activity.RESULT_OK,outDataIntent);
                finish();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
    }
}
