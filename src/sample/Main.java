package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
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
    Scene scene2;
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

    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Tic-Tac-Toe");
       // primaryStage.setScene(new Scene(GridPane, 300, 275));
startButton = new Button("test");
buttonTest2 = new Button("test2");
titleText = new Label("Welcome");
playerVsPlayer = new Button("P vs. P");
playerVsComputer = new Button("P vs. C");
mainMenu = new Label("Select a Game Mode");
playerName = new TextField();
X = new Button("X");
O = new Button("O");
backPlayerPlayer = new Button("Back");
testDisplayName = new Button("Display Player Name");
backPlayerPlayer2 = new Button("Back");

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
scene1_layout.getChildren().addAll(titleText,startButton);
scene1 = new Scene(scene1_layout,200,300);

startButton.setOnAction(e -> window.setScene(scene3));

//GridPane scene2_layout = new GridPane();
//scene2_layout.getChildren().add(buttonTest2);
//scene2 = new Scene(scene2_layout,200,300);

//scene 2 was a tester scene, it will be removed before final release.

BorderPane scene3_layout = new BorderPane();
HBox buttons = new HBox(100);
scene3_layout.setCenter(mainMenu);
scene3_layout.setBottom(buttons);
buttons.getChildren().addAll(playerVsPlayer,playerVsComputer);
scene3 = new Scene(scene3_layout, 200, 300);

playerVsPlayer.setOnAction(e -> window.setScene(scene4));

BorderPane scene4_layout = new BorderPane();
HBox XOChoice = new HBox(60);
playerName_VBox = new VBox(10);
playerName_VBox.getChildren().addAll(playerName,testDisplayName);
scene4_layout.setCenter(playerName_VBox);
playerName.setPromptText("Player 1, enter your name.");

XOChoice.getChildren().addAll(X,O,backPlayerPlayer);
scene4_layout.setBottom(XOChoice);
scene4 = new Scene(scene4_layout, 210, 300);

backPlayerPlayer.setOnAction(e -> window.setScene(scene3));
testDisplayName.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        System.out.println(playerName.getText());
        }
    }
);

X.setOnAction(e -> window.setScene(scene5));
//add method that sets Player 1's piece to X and Player 2's to O.

O.setOnAction(e -> window.setScene(scene5));
//for the method used with X, add other branch (if X, else if O, else) to set Player 1's piece to O and Player 2's to X.

BorderPane scene5_layout = new BorderPane();
HBox XOChoiceP2 = new HBox(60);
playerName_VBox = new VBox(10);
playerName_VBox.getChildren().addAll(playerName,testDisplayName);
scene5_layout.setCenter(playerName_VBox);
playerName.setPromptText("Player 2, enter your name.");

XOChoiceP2.getChildren().add(backPlayerPlayer2);
scene5_layout.setBottom(XOChoice);
scene5 = new Scene(scene5_layout, 210, 300);

backPlayerPlayer2.setOnAction(e -> window.setScene(scene4));
testDisplayName.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        System.out.println(playerName.getText());
        }
    }
);



        window.setScene(scene1);

        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
