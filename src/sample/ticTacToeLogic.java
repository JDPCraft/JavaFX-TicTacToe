package sample;
import javafx.scene.control.Label;

import java.util.Arrays;

public class ticTacToeLogic {

    //    boolean checkSpot(int[] row, int[] column){
//        if(cells[row][column].equals("")) {
//
//            cells[row][column].setText();
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//



        static void winConditionCheck(){
            if (Main.spotUsed[0] == Main.spotUsed[3] == Main.spotUsed[6]) {
                Main.winMet = true;
            } else if (Main.spotUsed[1] == Main.spotUsed[4] == Main.spotUsed[7]) {
                Main.winMet = true;
            } else if (Main.spotUsed[2] == Main.spotUsed[5] == Main.spotUsed[8]) {
                Main.winMet = true;
            } else if (Main.spotUsed[0] == Main.spotUsed[1] == Main.spotUsed[2]) {
                Main.winMet = true;
            } else if (Main.spotUsed[3] == Main.spotUsed[4] == Main.spotUsed[5]) {
                Main.winMet = true;
            } else if (Main.spotUsed[6] == Main.spotUsed[7] == Main.spotUsed[8]) {
                Main.winMet = true;
            } else if (Main.spotUsed[1] == Main.spotUsed[4] == Main.spotUsed[7]) {
                Main.winMet = true;
            } else if (Main.spotUsed[1] == Main.spotUsed[4] == Main.spotUsed[7]) {
                Main.winMet = true;
            } else {
                Main.winMet = false;
            }
        }
    }

