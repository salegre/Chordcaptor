package com.sebastian.chordfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class ChordResults extends AppCompatActivity {

    @Bind(R.id.spinner) Spinner chordSpinner;
    @Bind(R.id.textViewChords)
    TextView chordsDisplay;

    Tuning config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_results);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        config = new Tuning(extras.getIntArray("TUNING"));

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.chords, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        chordSpinner.setAdapter(adapter);

        displayChord(0);
    }

    public void displayChord(int i){
        chordsDisplay.setText(config.showChord(i));
    }

    @OnItemSelected(R.id.spinner)
    void onItemSelected(){
        Log.i("Results", chordSpinner.getSelectedItem().toString());
        displayChord(chordSpinner.getSelectedItemPosition());
    }

}
