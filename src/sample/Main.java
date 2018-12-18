package sample;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;

public class Main extends Application {

    Button startButton;
    Button buttonTest2;
    Button playerVsPlayer;
    Button playerVsComputer;
    Label titleText;
    Label mainMenu;
    //   Scene scene2;
    Scene scene1;
    Scene scene3;
    TextField playerName;
    VBox playerName_VBox;
    Button X;
    Button O;
    Scene scene4;
    Button backPlayerPlayer;
    Button testDisplayName;
    Scene scene5;
    Button backPlayerPlayer2;
    VBox playerName_VBox2;
    TextField playerName2;
    Button gameStart;
    Scene scene6;
    //  Button testButtonText;
    // Scene buttonTextChangeTester;
    private boolean xturn;
    //    Label X0Y0;
//    Label X0Y1;
//    Label X0Y2;
//    Label X1Y0;
//    Label X1Y1;
//    Label X1Y2;
//    Label X2Y0;
//    Label X2Y1;
//    Label X2Y2;
    static Label[] cells;
    Scene sceneGameBoard;
    String[] row;
    String[] column;
    //    Label X3Y0;
//    Label X3Y1;
//    Label X3Y2;
    static boolean[] spotUsed;
    static String piece;
    boolean winResult;
    static boolean winMet;
    Label playerWon;
    boolean xturnStart;
    Label playAgain;
    VBox endText;
    HBox againButtons;
    Button Yes;
    Button No;
    String winner;
    static boolean tie;
    boolean tieResult;

//    public Main(String piece) {
//        this.piece = piece;
//    }
//
//    public String getPiece() {
//        return piece;
//    }
//
//    public void setPiece(String piece) {
//        this.piece = piece;
//    }

    @Override
    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Tic-Tac-Toe");
        // primaryStage.setScene(new Scene(GridPane, 300, 275));
        startButton = new Button("Start");
        buttonTest2 = new Button("test2");
        titleText = new Label("Welcome to Tic-Tac-Toe!");
        playerVsPlayer = new Button("P vs. P");
        playerVsComputer = new Button("P vs. C");
        mainMenu = new Label("Select a Game Mode");
        playerName = new TextField();
        X = new Button("X");
        O = new Button("O");
        backPlayerPlayer = new Button("Back");
        testDisplayName = new Button("Display Player Name");
        backPlayerPlayer2 = new Button("Back");
        gameStart = new Button("Continue.");
        playerName2 = new TextField();
//testButtonText = new Button(" ");
        //temporarily the labels will not have blank text for testing to make sure they all show up.
        cells = new Label[9];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Label("   ");
        }

        row = new String[3];
        column = new String[3];
//        for (int r=0; r<row.length; r++)

        spotUsed = new boolean[9];
        for (int j = 0; j < spotUsed.length; j++) {
            spotUsed[j] = false;
        }
        winResult = false;
        winMet = false;
        playerWon = new Label(winner);
        playAgain = new Label("Would you like to play again with \n the same settings?");
        No = new Button("No");
        Yes = new Button("Yes");
      //  winner = " ";

//X0Y0 = new Label("   1");
//X0Y1 = new Label("   1");
//X0Y2 = new Label("   1");
//X1Y0 = new Label("   1");
//X1Y1 = new Label("   1");
//X1Y2 = new Label("   1");
//X2Y0 = new Label("   1");
//X2Y1 = new Label("   1");
//X2Y2 = new Label("   1");
//X3Y0 = new Label("1");
//X3Y1 = new Label("1");
//X3Y2 = new Label("1");
        piece = " ";

//        GridPane grid = new GridPane();
//
//       // grid.setPrefSize(300, 275);
//        grid.setAlignment(Pos.CENTER);
//        grid.setGridLinesVisible(true);
//        grid.add(buttonTest, 0, 1,2,1);
//
//        grid.add(buttonTest2, 0, 2);
//        //grid.setHgap(10);
//       // grid.setVgap(10);
//       grid.setPadding(new Insets(25, 25, 25, 25));
//     // grid.setAlignment(Pos.BOTTOM_LEFT);
//      //  grid.getChildren().add(buttonTest2);
//
//
//        Scene scene1 = new Scene(grid, 300, 275);

        VBox scene1_layout = new VBox(100);
        scene1_layout.setAlignment(Pos.CENTER);
        scene1_layout.getChildren().addAll(titleText, startButton);
        scene1 = new Scene(scene1_layout, 200, 300);

        startButton.setOnAction(e -> window.setScene(scene3));

//GridPane scene2_layout = new GridPane();
//scene2_layout.getChildren().add(buttonTest2);
//scene2 = new Scene(scene2_layout,200,300);

//scene 2 was a tester scene, it will be removed before final release.

        BorderPane scene3_layout = new BorderPane();
        HBox buttons = new HBox(100);
        scene3_layout.setCenter(mainMenu);
        scene3_layout.setBottom(buttons);
        buttons.getChildren().addAll(playerVsPlayer, playerVsComputer);
        scene3 = new Scene(scene3_layout, 200, 300);

        playerVsPlayer.setOnAction(e -> window.setScene(scene4));

        BorderPane scene4_layout = new BorderPane();
        HBox XOChoice = new HBox(60);
        playerName_VBox = new VBox(10);
        playerName_VBox.getChildren().add(playerName);
        scene4_layout.setCenter(playerName_VBox);
        playerName.setPromptText("Player 1, enter your name.");

        XOChoice.getChildren().addAll(X, O, backPlayerPlayer);
        scene4_layout.setBottom(XOChoice);
        scene4 = new Scene(scene4_layout, 210, 300);

        backPlayerPlayer.setOnAction(e -> window.setScene(scene3));
//testDisplayName.setOnAction(new EventHandler<ActionEvent>() {
//    @Override
//    public void handle(ActionEvent event) {
//        System.out.println("Player 1: " + playerName.getText());
//        }
//    }
//);

        X.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene5);
                xturn = true;
                xturnStart = true;
                //  System.out.println(xturn);
            }
        });

//add method that sets Player 1's piece to X and Player 2's to O.

        O.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene5);
                xturn = false;
                xturnStart = false;
                // System.out.println(xturn);
            }
        });

//for the method used with X, add other branch (if X, else if O, else) to set Player 1's piece to O and Player 2's to X.

        BorderPane scene5_layout = new BorderPane();
        HBox XOChoiceP2 = new HBox(60);
        playerName_VBox2 = new VBox(10);
        playerName_VBox2.getChildren().addAll(playerName2, gameStart);
        scene5_layout.setCenter(playerName_VBox2);
        playerName2.setPromptText("Player 2, enter your name.");

        XOChoiceP2.getChildren().add(backPlayerPlayer2);
        scene5_layout.setBottom(XOChoiceP2);
        scene5 = new Scene(scene5_layout, 210, 300);

        backPlayerPlayer2.setOnAction(e -> window.setScene(scene4));
        gameStart.setOnAction(new EventHandler<ActionEvent>() {
                                  @Override
                                  public void handle(ActionEvent event) {
                                      //   System.out.println("Player 2: " + playerName2.getText());
                                      window.setScene(sceneGameBoard);
                                      //below println is just for testing to see if it can remember what was entered for a name on scene4 in other
                                      // scenes or if a variable needs to be made to store the name in.
                                      //    window.setScene(buttonTextChangeTester);
                                      //System.out.println("It is now " + playerName.getText() + "'s turn.");

                                      //result: it remembers.
                                      //also, the displayname button doesn't need to be pressed for the name to be remembered, that helps.
                                  }
                              }
        );
//BorderPane buttonTextChangeTester_layout = new BorderPane();
//buttonTextChangeTester_layout.getChildren().add(testButtonText);
//buttonTextChangeTester_layout.setCenter(testButtonText);
//buttonTextChangeTester = new Scene(buttonTextChangeTester_layout, 200, 200);
//
//testButtonText.setOnMouseClicked(testButtonText.setText("X"));

        GridPane gameBoard_Layout = new GridPane();
        gameBoard_Layout.setAlignment(Pos.CENTER);
        gameBoard_Layout.setGridLinesVisible(true);
//gameBoard_Layout.setHgap(20);
//gameBoard_Layout.setVgap(20);
//        X0Y0.relocate(50,50);
//        X0Y1.relocate(150,100);
//        X0Y2.relocate(150,150);
//        X1Y0.relocate(100,50);
//        X1Y1.relocate(100,100);
//        X1Y2.relocate(100,150);
//        X2Y0.relocate(150,50);
//        X2Y1.relocate(150,100);
//        X2Y2.relocate(150,150);
        Rectangle R1 = new Rectangle(30, 30);
        Rectangle R2 = new Rectangle(30, 30);
        Rectangle R3 = new Rectangle(30, 30);
        Rectangle R4 = new Rectangle(30, 30);
        Rectangle R5 = new Rectangle(30, 30);
        Rectangle R6 = new Rectangle(30, 30);
        Rectangle R7 = new Rectangle(30, 30);
        Rectangle R8 = new Rectangle(30, 30);
        Rectangle R9 = new Rectangle(30, 30);
        R1.setFill(Color.WHITE);
        R2.setFill(Color.BLACK);
        R3.setFill(Color.WHITE);
        R4.setFill(Color.BLACK);
        R5.setFill(Color.WHITE);
        R6.setFill(Color.BLACK);
        R7.setFill(Color.WHITE);
        R8.setFill(Color.BLACK);
        R9.setFill(Color.WHITE);


//row is Y, column is X
        gameBoard_Layout.add(R1, 0, 0);
        gameBoard_Layout.add(cells[0], 0, 0);

        gameBoard_Layout.add(R2, 1, 0);
        gameBoard_Layout.add(cells[1], 1, 0);
        cells[1].setTextFill(Color.WHITE);

        gameBoard_Layout.add(R3, 2, 0);
        gameBoard_Layout.add(cells[2], 2, 0);

        gameBoard_Layout.add(R4, 0, 1);
        gameBoard_Layout.add(cells[3], 0, 1);
        cells[3].setTextFill(Color.WHITE);

        gameBoard_Layout.add(R5, 1, 1);
        gameBoard_Layout.add(cells[4], 1, 1);

        gameBoard_Layout.add(R6, 2, 1);
        gameBoard_Layout.add(cells[5], 2, 1);
        cells[5].setTextFill(Color.WHITE);

        gameBoard_Layout.add(R7, 0, 2);
        gameBoard_Layout.add(cells[6], 0, 2);

        gameBoard_Layout.add(R8, 1, 2);
        gameBoard_Layout.add(cells[7], 1, 2);
        cells[7].setTextFill(Color.WHITE);

        gameBoard_Layout.add(R9, 2, 2);
        gameBoard_Layout.add(cells[8], 2, 2);

        //following is a test
//    R1.setOnMousePressed(new EventHandler<MouseEvent>() {
//        @Override
//        public void handle(MouseEvent event) {
//         //   if(X0Y0.equals("1")) {
//                piece = xturn? "   X": "   O";
//                X0Y0.setText(piece);
//                xturn = !xturn;
//                //need to prevent user from overriding a square that's already been used.
//            }
//
//      //  }
//    }
//);

        R1.setOnMousePressed(new EventHandler<MouseEvent>() {
                                 @Override
                                 public void handle(MouseEvent event) {
                                     //ask Mr. Walters about this when possible
//                                     row[0]="0";
                                     if (!spotUsed[0]) {
                                         piece = xturn ? "   X" : "   O";
//                                     if(cells[0].equals("   ")) {
                                         cells[0].setText(piece);

                                         xturn = !xturn;
                                         spotUsed[0] = true;
                                         ticTacToeLogic.winConditionCheck(piece);
                                         winResult();
                                         if (winResult == true) {
                                             if (xturn == true) {
                                                 winner = "Player O Won!";
                                                 playerWon.setText(winner);
                                             }
                                             else if (xturn == false) {
                                                 winner = "Player X Won!";
                                                 playerWon.setText(winner);
                                             }
                                             window.setScene(scene6);
                                         }
                                         else if (tieResult == true) {
                                             winner = "Tie game!";
                                             playerWon.setText(winner);
                                             window.setScene(scene6);
                                         }
                                     }

                                 }
                             }
        );

        R2.setOnMousePressed(new EventHandler<MouseEvent>() {
                                 @Override
                                 public void handle(MouseEvent event) {
                                     //ask Mr. Walters about this when possible
//                                     row[0]="0";
                                     if (!spotUsed[1]) {
                                         piece = xturn ? "   X" : "   O";
//                                     if(cells[0].equals("   ")) {
                                         cells[1].setText(piece);

                                         xturn = !xturn;
                                         spotUsed[1] = true;
                                         ticTacToeLogic.winConditionCheck(piece);
                                         winResult();
                                         if (winResult == true) {
                                             if (xturn == true) {
                                                 winner = "Player O Won!";
                                                 playerWon.setText(winner);
                                             }
                                             else if (xturn == false) {
                                                 winner = "Player X Won!";
                                                 playerWon.setText(winner);
                                             }
                                             window.setScene(scene6);
                                         }
                                         else if (tieResult == true) {
                                             winner = "Tie game!";
                                             playerWon.setText(winner);
                                             window.setScene(scene6);
                                         }
                                     }

                                 }
                             }
        );

        R3.setOnMousePressed(new EventHandler<MouseEvent>() {
                                 @Override
                                 public void handle(MouseEvent event) {
                                     //ask Mr. Walters about this when possible
//                                     row[0]="0";
                                     if (!spotUsed[2]) {
                                         piece = xturn ? "   X" : "   O";
//                                     if(cells[0].equals("   ")) {
                                         cells[2].setText(piece);


                                         xturn = !xturn;
                                         spotUsed[2] = true;
                                         ticTacToeLogic.winConditionCheck(piece);
                                         winResult();
                                         if (winResult == true) {
                                             if (xturn == true) {
                                                 winner = "Player O Won!";
                                                 playerWon.setText(winner);
                                             }
                                             else if (xturn == false) {
                                                 winner = "Player X Won!";
                                                 playerWon.setText(winner);
                                             }
                                             window.setScene(scene6);
                                         }
                                         else if (tieResult == true) {
                                             winner = "Tie game!";
                                             playerWon.setText(winner);
                                             window.setScene(scene6);
                                         }
                                     }

                                 }
                             }
        );

        R4.setOnMousePressed(new EventHandler<MouseEvent>() {
                                 @Override
                                 public void handle(MouseEvent event) {
                                     //ask Mr. Walters about this when possible
//                                     row[0]="0";
                                     if (!spotUsed[3]) {
                                         piece = xturn ? "   X" : "   O";
//                                     if(cells[0].equals("   ")) {
                                         cells[3].setText(piece);

                                         xturn = !xturn;
                                         spotUsed[3] = true;
                                         ticTacToeLogic.winConditionCheck(piece);
                                         winResult();
                                         if (winResult == true) {
                                             if (xturn == true) {
                                                 winner = "Player O Won!";
                                                 playerWon.setText(winner);
                                             }
                                             else if (xturn == false) {
                                                 winner = "Player X Won!";
                                                 playerWon.setText(winner);
                                             }
                                             window.setScene(scene6);
                                         }
                                         else if (tieResult == true) {
                                             winner = "Tie game!";
                                             playerWon.setText(winner);
                                             window.setScene(scene6);
                                         }
                                     }

                                 }
                             }
        );

        R5.setOnMousePressed(new EventHandler<MouseEvent>() {
                                 @Override
                                 public void handle(MouseEvent event) {
                                     //ask Mr. Walters about this when possible
//                                     row[0]="0";
                                     if (!spotUsed[4]) {
                                         piece = xturn ? "   X" : "   O";
//                                     if(cells[0].equals("   ")) {
                                         cells[4].setText(piece);


                                         xturn = !xturn;
                                         spotUsed[4] = true;
                                         ticTacToeLogic.winConditionCheck(piece);
                                         winResult();
                                         if (winResult == true) {
                                             if (xturn == true) {
                                                 winner = "Player O Won!";
                                                 playerWon.setText(winner);
                                             }
                                             else if (xturn == false) {
                                                 winner = "Player X Won!";
                                                 playerWon.setText(winner);
                                             }
                                             window.setScene(scene6);
                                         }
                                         else if (tieResult == true) {
                                             winner = "Tie game!";
                                             playerWon.setText(winner);
                                             window.setScene(scene6);
                                         }
                                     }

                                 }
                             }
        );

        R6.setOnMousePressed(new EventHandler<MouseEvent>() {
                                 @Override
                                 public void handle(MouseEvent event) {
                                     //ask Mr. Walters about this when possible
//                                     row[0]="0";
                                     if (!spotUsed[5]) {
                                         piece = xturn ? "   X" : "   O";
//                                     if(cells[0].equals("   ")) {
                                         cells[5].setText(piece);

                                         xturn = !xturn;
                                         spotUsed[5] = true;
                                         ticTacToeLogic.winConditionCheck(piece);
                                         winResult();
                                         if (winResult == true) {
                                             if (xturn == true) {
                                                 winner = "Player O Won!";
                                                 playerWon.setText(winner);
                                             }
                                             else if (xturn == false) {
                                                 winner = "Player X Won!";
                                                 playerWon.setText(winner);
                                             }
                                             window.setScene(scene6);
                                         }
                                         else if (tieResult == true) {
                                             winner = "Tie game!";
                                             playerWon.setText(winner);
                                             window.setScene(scene6);
                                         }
                                     }

                                 }
                             }
        );

        R7.setOnMousePressed(new EventHandler<MouseEvent>() {
                                 @Override
                                 public void handle(MouseEvent event) {
                                     //ask Mr. Walters about this when possible
//                                     row[0]="0";
                                     if (!spotUsed[6]) {
                                         piece = xturn ? "   X" : "   O";
//                                     if(cells[0].equals("   ")) {
                                         cells[6].setText(piece);

                                         xturn = !xturn;
                                         spotUsed[6] = true;
                                         ticTacToeLogic.winConditionCheck(piece);
                                         winResult();
                                         if (winResult == true) {
                                             if (xturn == true) {
                                                 winner = "Player O Won!";
                                                 playerWon.setText(winner);
                                             }
                                             else if (xturn == false) {
                                                 winner = "Player X Won!";
                                                 playerWon.setText(winner);
                                             }
                                             window.setScene(scene6);
                                         }
                                         else if (tieResult == true) {
                                             winner = "Tie game!";
                                             playerWon.setText(winner);
                                             window.setScene(scene6);
                                         }
                                     }

                                 }
                             }
        );

        R8.setOnMousePressed(new EventHandler<MouseEvent>() {
                                 @Override
                                 public void handle(MouseEvent event) {
                                     //ask Mr. Walters about this when possible
//                                     row[0]="0";
                                     if (!spotUsed[7]) {
                                         piece = xturn ? "   X" : "   O";
//                                     if(cells[0].equals("   ")) {
                                         cells[7].setText(piece);

                                         xturn = !xturn;
                                         spotUsed[7] = true;
                                         ticTacToeLogic.winConditionCheck(piece);
                                         winResult();
                                         if (winResult == true) {
                                             if (xturn == true) {
                                                 winner = "Player O Won!";
                                                 playerWon.setText(winner);
                                             }
                                             else if (xturn == false) {
                                                 winner = "Player X Won!";
                                                 playerWon.setText(winner);
                                             }
                                             window.setScene(scene6);
                                         }
                                         else if (tieResult == true) {
                                             winner = "Tie game!";
                                             playerWon.setText(winner);
                                             window.setScene(scene6);
                                         }
                                     }

                                 }
                             }
        );

        R9.setOnMousePressed(new EventHandler<MouseEvent>() {
                                 @Override
                                 public void handle(MouseEvent event) {
                                     //ask Mr. Walters about this when possible
//                                     row[0]="0";
                                     if (!spotUsed[8]) {
                                         piece = xturn ? "   X" : "   O";
//                                     if(cells[0].equals("   ")) {
                                         cells[8].setText(piece);

                                         xturn = !xturn;
                                         spotUsed[8] = true;
                                         ticTacToeLogic.winConditionCheck(piece);
                                         winResult();
                                         if (winResult == true) {
                                         if (xturn == true) {
                                             winner = "Player O Won!";
                                             playerWon.setText(winner);
                                         }
                                         else if (xturn == false) {
                                             winner = "Player X Won!";
                                             playerWon.setText(winner);
                                         }
                                         window.setScene(scene6);
                                     }
                                     else if (tieResult == true) {
                                         winner = "Tie game!";
                                             playerWon.setText(winner);
                                         window.setScene(scene6);
                                     }
                                 }

                                 }
                             }
        );

//gameBoard_Layout.add(X3Y0, 3,0);
//gameBoard_Layout.add(X3Y1, 3,1);
//gameBoard_Layout.add(X3Y2, 3,2);

        sceneGameBoard = new Scene(gameBoard_Layout, 300, 300);

        BorderPane scene6_layout = new BorderPane();
        endText = new VBox(20);
        againButtons = new HBox(60);
        endText.getChildren().addAll(playerWon, playAgain);
        againButtons.getChildren().addAll(Yes, No);
        scene6_layout.setCenter(endText);
        scene6_layout.setBottom(againButtons);
        scene6 = new Scene(scene6_layout, 210, 300);

        Yes.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                if (xturnStart == false) {
                                    xturn = false;
                                    tieResult = false;
                                    winResult = false;
                                    tie = false;
                                    winMet = false;
                                    spotUsed[0] = false;
                                    spotUsed[1] = false;
                                    spotUsed[2] = false;
                                    spotUsed[3] = false;
                                    spotUsed[4] = false;
                                    spotUsed[5] = false;
                                    spotUsed[6] = false;
                                    spotUsed[7] = false;
                                    spotUsed[8] = false;
                                    cells[0].setText(" ");
                                    cells[1].setText(" ");
                                    cells[2].setText(" ");
                                    cells[3].setText(" ");
                                    cells[4].setText(" ");
                                    cells[5].setText(" ");
                                    cells[6].setText(" ");
                                    cells[7].setText(" ");
                                    cells[8].setText(" ");

                                    window.setScene(sceneGameBoard);
                                }
                                if (xturnStart == true) {
                                    xturn = true;
                                    tieResult = false;
                                    winResult = false;
                                    tie = false;
                                    winMet = false;
                                    spotUsed[0] = false;
                                    spotUsed[1] = false;
                                    spotUsed[2] = false;
                                    spotUsed[3] = false;
                                    spotUsed[4] = false;
                                    spotUsed[5] = false;
                                    spotUsed[6] = false;
                                    spotUsed[7] = false;
                                    spotUsed[8] = false;
                                    cells[0].setText(" ");
                                    cells[1].setText(" ");
                                    cells[2].setText(" ");
                                    cells[3].setText(" ");
                                    cells[4].setText(" ");
                                    cells[5].setText(" ");
                                    cells[6].setText(" ");
                                    cells[7].setText(" ");
                                    cells[8].setText(" ");

                                    window.setScene(sceneGameBoard);
                                }
                            }
                        }
        );
        No.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               window.setScene(scene3);
                               tieResult = false;
                               winResult = false;
                               tie = false;
                               winMet = false;
                               spotUsed[0] = false;
                               spotUsed[1] = false;
                               spotUsed[2] = false;
                               spotUsed[3] = false;
                               spotUsed[4] = false;
                               spotUsed[5] = false;
                               spotUsed[6] = false;
                               spotUsed[7] = false;
                               spotUsed[8] = false;
                               cells[0].setText(" ");
                               cells[1].setText(" ");
                               cells[2].setText(" ");
                               cells[3].setText(" ");
                               cells[4].setText(" ");
                               cells[5].setText(" ");
                               cells[6].setText(" ");
                               cells[7].setText(" ");
                               cells[8].setText(" ");

                           }

                       }
        );


        window.setScene(scene1);

        window.show();
    }

    boolean winResult() {
        if (winMet == true) {
            winResult = true;
            return true;
        } else if (tie == true) {
            tieResult = true;
            return false;
        } else {
            winResult = false;
            tieResult = false;
            return false;
        }

    }




//    boolean checkSpot(String[] row, String[] column){
//        if(cells[row][column].equals("")) {
//
//            cells[row][column].setText(piece);
//            return true;
//        }
//        else {
//            return false;
//        }
//    }


    public static void main(String[] args) {
        launch(args);
    }
}
