package com.sebastian.chordfinder;

/**
 * Created by Sebastian on 03/04/2016.
 */
public class Tuning {
    int[] tuning = {5, 12, 8, 3, 10, 5};
    final int versatility = 5;

    Tuning(int[] notes) {
        if(notes != null)
            tuning = notes;
    }

    public String[] getPositions(int[] chord){

        String[] placements = new String[tuning.length];

        for(int i = 0; i < tuning.length; i++) {
            nextString:
            for(int j = 0; j < versatility; j++) {
                for(int k = 0; k < chord.length; k++) {
                    if(chord[k]%12 == (tuning[i] + j)%12) {
                        placements[i] = j + "";
                        break nextString;
                    } else if(j == versatility - 1) {
                        placements[i] = "x";
                    }
                }
            }
        }

        return placements;
    }

    public String showChord(int note, int quality, int seventh) {
        int[] chord = {note, note + 4 - quality, note + 7, (note + 12 - seventh)%12};

        String[] positions = getPositions(chord);

        String p = "";
        for(int i = 0; i < tuning.length; i++) {
            for(int j = 0; j < 6; j++) {
                if(j == 0) {
                    p = p + toNote(tuning[i]) + " |";
                } else if ((j + "").equals(positions[i])) {
                    p = p + "-x-|";
                } else {
                    p = p + "---|";
                }
                if(j == 5) {
                    p = p + "\n";
                }
            }
        }

        return p;
    }

    public String toNote(int t) {
        if(t == 0) {
            return "C ";
        } else if (t == 1) {
            return "C#";
        } else if (t == 2) {
            return "D ";
        } else if (t == 3) {
            return "D#";
        } else if (t == 4) {
            return "E ";
        } else if (t == 5) {
            return "F ";
        } else if (t == 6) {
            return "F#";
        } else if (t == 7) {
            return "G ";
        } else if (t == 8) {
            return "G#";
        } else if (t == 9) {
            return "A ";
        } else if (t == 10) {
            return "A#";
        } else if (t == 11) {
            return "B ";
        } else {
            return "XX";
        }
    }

}
