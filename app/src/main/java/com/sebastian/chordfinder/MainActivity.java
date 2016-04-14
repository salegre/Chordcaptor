package com.sebastian.chordfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.str6)
    Spinner str6;
    @Bind(R.id.str5)
    Spinner str5;
    @Bind(R.id.str4)
    Spinner str4;
    @Bind(R.id.str3)
    Spinner str3;
    @Bind(R.id.str2)
    Spinner str2;
    @Bind(R.id.str1)
    Spinner str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.notes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        str6.setAdapter(adapter);
        str5.setAdapter(adapter);
        str4.setAdapter(adapter);
        str3.setAdapter(adapter);
        str2.setAdapter(adapter);
        str1.setAdapter(adapter);

    }

    @OnClick(R.id.getChordsButton)
    public void GetChords(){
        int[] tuning = {str6.getSelectedItemPosition(),
                str5.getSelectedItemPosition(),
                str4.getSelectedItemPosition(),
                str3.getSelectedItemPosition(),
                str2.getSelectedItemPosition(),
                str1.getSelectedItemPosition()};

        Log.i("Main", str5.getSelectedItemPosition() + " " +
                str4.getSelectedItemPosition() + " " +
                str3.getSelectedItemPosition() + " " +
                str2.getSelectedItemPosition() + " " +
                str1.getSelectedItemPosition());


        Intent intent = new Intent(this, ChordResults.class);
        intent.putExtra("TUNING", tuning);
        startActivity(intent);
        finish();
    }
}
