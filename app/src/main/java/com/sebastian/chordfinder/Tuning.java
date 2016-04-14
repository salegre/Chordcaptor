package com.sebastian.chordfinder;

/**
 * Created by Sebastian on 03/04/2016.
 */
public class Tuning {
    int[] tuning = {5, 12, 8, 3, 10, 5};
//    int[][] chordsMajor = {{1, 5, 8, 1}, {2, 6, 9, 2}, {3, 7, 10, 3}, {4, 8, 11, 4}, {5, 9, 12, 5}, {6, 10, 1, 6}, {7, 11, 2, 7}, {8, 12, 3, 8}, {9, 1, 4, 9}, {10, 2, 5, 10}, {11, 3, 6, 11}, {12, 4, 7, 12}};
    int[][] chordsMajor = {{0, 4, 7, 0}, {1, 5, 8, 1}, {2, 6, 9, 2}, {3, 7, 10, 3}, {4, 8, 11, 4}, {5, 9, 0, 5}, {6, 10, 1, 6}, {7, 11, 2, 7}, {8, 0, 3, 8}, {9, 1, 4, 9}, {10, 2, 5, 10}, {11, 3, 6, 11}};
    int[][] chordsMinor = {{0, 3, 7, 0}, {1, 4, 8, 1}, {2, 5, 9, 2}, {3, 6, 10, 3}, {4, 7, 11, 4}, {5, 8, 0, 5}, {6, 9, 1, 6}, {7, 10, 2, 7}, {8, 11, 3, 8}, {9, 0, 4, 9}, {10, 1, 5, 10}, {11, 2, 6, 11}};
//    int[][] chordsMinor = {{1, 4, 8, 1}, {2, 5, 9, 2}, {3, 6, 10, 3}, {4, 7, 11, 4}, {5, 8, 12, 5}, {6, 9, 1, 6}, {7, 10, 2, 7}, {8, 11, 3, 8}, {9, 12, 4, 9}, {10, 1, 5, 10}, {11, 2, 6, 11}, {12, 3, 7, 12}};
    String[][] positions = new String[24][6];

    Tuning(int[] notes) {
        if(notes != null)
            tuning = notes;

        getPositions();
    }

    public void getPositions(){
        int major = 0;
        int minor = 0;

        for(int i = 0; i < positions.length; i++) {
            //is major chord
            if(i%2 == 0){
                for(int j = 0; j < tuning.length; j++){
                    placement:
                    for(int k = 0; k < 4; k++){
                        for(int l = 0; l < 5; l++){
                            if((tuning[j] + l) %12 == chordsMajor[major][k]) {
                                positions[i][j] = l + "";
                                break placement;
                            } else if(k == 3) {
                                positions[i][j] = "x";
                            }
                        }
                    }
                }
                major++;
            }
            //is minor chord
            else {
                for(int j = 0; j < tuning.length; j++){
                    placement:
                    for(int k = 0; k < 4; k++){
                        for(int l = 0; l < 5; l++){
                            if((tuning[j] + l)%12 == chordsMinor[minor][k]) {
                                positions[i][j] = l + "";
                                break placement;
                            } else if(k == 3) {
                                positions[i][j] = "x";
                            }
                        }
                    }
                }
                minor++;
            }
        }
    }

    public String showChord(int chord) {
        String p = "";
        for(int i = 0; i < positions[chord].length; i++) {
            p = p + positions[chord][i] + " ";
        }

        return p;
    }

}
