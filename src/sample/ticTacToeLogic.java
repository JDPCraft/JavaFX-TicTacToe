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



        static void winConditionCheck(String piece){
           // Main.piece.equalsIgnoreCase(Main.cells.);
           // if (Main.spotUsed[0] && Main.spotUsed[1] && Main.spotUsed[2] && Main.spotUsed[3] && Main.spotUsed[4] && Main.spotUsed[5] && Main.spotUsed[6] && Main.spotUsed[7] && Main.spotUsed[8]) {
//Main.winMet = false;
          //  }
            if (Main.cells[0].getText().equalsIgnoreCase(piece) && Main.cells[3].getText().equalsIgnoreCase(piece) && Main.cells[6].getText().equalsIgnoreCase(piece)) {
                Main.winMet = true;
            } else if (Main.cells[1].getText().equalsIgnoreCase(piece) && Main.cells[4].getText().equalsIgnoreCase(piece) && Main.cells[7].getText().equalsIgnoreCase(piece)) {
                Main.winMet = true;
            } else if (Main.cells[2].getText().equalsIgnoreCase(piece) && Main.cells[5].getText().equalsIgnoreCase(piece) && Main.cells[8].getText().equalsIgnoreCase(piece)) {
                Main.winMet = true;
            } else if (Main.cells[0].getText().equalsIgnoreCase(piece) && Main.cells[1].getText().equalsIgnoreCase(piece) && Main.cells[2].getText().equalsIgnoreCase(piece)) {
                Main.winMet = true;
            } else if (Main.cells[3].getText().equalsIgnoreCase(piece) && Main.cells[4].getText().equalsIgnoreCase(piece) && Main.cells[5].getText().equalsIgnoreCase(piece)) {
                Main.winMet = true;
            } else if (Main.cells[6].getText().equalsIgnoreCase(piece) && Main.cells[7].getText().equalsIgnoreCase(piece) && Main.cells[8].getText().equalsIgnoreCase(piece)) {
                Main.winMet = true;
            } else if (Main.cells[0].getText().equalsIgnoreCase(piece) && Main.cells[4].getText().equalsIgnoreCase(piece) && Main.cells[8].getText().equalsIgnoreCase(piece)) {
                Main.winMet = true;
            } else if (Main.cells[2].getText().equalsIgnoreCase(piece) && Main.cells[4].getText().equalsIgnoreCase(piece) && Main.cells[6].getText().equalsIgnoreCase(piece)) {
                Main.winMet = true;
            }
            else if (Main.spotUsed[0] && Main.spotUsed[1] && Main.spotUsed[2] && Main.spotUsed[3] && Main.spotUsed[4] && Main.spotUsed[5] && Main.spotUsed[6] && Main.spotUsed[7] && Main.spotUsed[8]) {
                Main.tie = true;
            }
           /* } */ else {
                Main.winMet = false;
            }
        }
    }

