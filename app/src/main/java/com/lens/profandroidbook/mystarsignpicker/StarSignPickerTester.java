package com.lens.profandroidbook.mystarsignpicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StarSignPickerTester extends AppCompatActivity {

    public static final int PICK_STARSIGN = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_sign_picker_tester);

        Button button = findViewById(R.id.pick_starsign_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        Uri.parse("starsigns://"));
                startActivityForResult(intent, PICK_STARSIGN);
            }
        });
    }

    @Override
    public void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);

        switch(reqCode) {
            case (PICK_STARSIGN) : {
                if (resCode == Activity.RESULT_OK) {
                    String selectedSign =
                            data.getStringExtra(StarSignPicker.EXTRA_SIGN_NAME);
                    TextView tv = findViewById(R.id.selected_starsign_textview);
                    tv.setText(selectedSign);
                }
                break;
            }
            default: break;
        }
    }
}
