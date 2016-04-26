package com.sebastian.chordfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class ChordResults extends AppCompatActivity {

    @Bind(R.id.spinnerNote) Spinner noteSpinner;
    @Bind(R.id.spinnerQuality) Spinner qualitySpinner;
    @Bind(R.id.spinnerSeventh) Spinner seventhSpinner;
    @Bind(R.id.resultsTextView)
    TextView resultsTextView;

    Tuning config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_results);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        config = new Tuning(extras.getIntArray("TUNING"));

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> noteAdapter = ArrayAdapter.createFromResource(this,
                R.array.notes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        noteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the noteAdapter to the spinner
        noteSpinner.setAdapter(noteAdapter);

        ArrayAdapter<CharSequence> qualityAdapter = ArrayAdapter.createFromResource(this, R.array.qualities, android.R.layout.simple_spinner_item);
        qualityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qualitySpinner.setAdapter(qualityAdapter);

        ArrayAdapter<CharSequence> seventhAdapter = ArrayAdapter.createFromResource(this, R.array.seventh, android.R.layout.simple_spinner_item);
        qualityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seventhSpinner.setAdapter(seventhAdapter);


        displayChord();
    }

    public void displayChord(){
        resultsTextView.setText(config.showChord(noteSpinner.getSelectedItemPosition(), qualitySpinner.getSelectedItemPosition(), seventhSpinner.getSelectedItemPosition()));
    }

    @OnItemSelected(R.id.spinnerNote)
    void onNoteSelected(){
        displayChord();
    }

    @OnItemSelected(R.id.spinnerQuality)
    void onQualitySelected(){
        displayChord();
    }

    @OnItemSelected(R.id.spinnerSeventh)
    void onSeventhSelected(){
        displayChord();
    }

}
