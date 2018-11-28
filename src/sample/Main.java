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

    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Hello World");
       // primaryStage.setScene(new Scene(GridPane, 300, 275));
startButton = new Button("test");
buttonTest2 = new Button("test2");
titleText = new Label("Welcome");
playerVsPlayer = new Button("P vs. P");
playerVsComputer = new Button("P vs. C");
mainMenu = new Label("Select a Game Mode");

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

GridPane scene2_layout = new GridPane();
scene2_layout.getChildren().add(buttonTest2);
scene2 = new Scene(scene2_layout,200,300);

BorderPane scene3_layout = new BorderPane();
HBox buttons = new HBox(100);
scene3_layout.setCenter(mainMenu);
scene3_layout.setBottom(buttons);
buttons.getChildren().addAll(playerVsPlayer,playerVsComputer);
scene3 = new Scene(scene3_layout, 200, 200);
        window.setScene(scene1);

        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
