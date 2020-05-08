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

    public String showChord(int root, int quality, int seventh) {
        int[] chord = {root, root + 4 - quality, root + 7, (root + 12 - seventh)%12};

        String[] positions = getPositions(chord);

        String p = "";
        for(int i = 0; i < positions.length; i++) {
            p = p + positions[i] + " ";
        }

        return p;
    }

}
