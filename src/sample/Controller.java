package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    public void Settings_button_clicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent settingsscene = FXMLLoader.load(Controller.class.getResource("Main_Win_Set.fxml"));
        Scene setwin = new Scene(settingsscene);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        settingsscene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();

            }
        });

        settingsscene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setX(event.getScreenX() - xOffset);
                window.setY(event.getScreenY() - yOffset);
            }
        });
        window.setScene(setwin);
        window.show();
    }

    public void SingleplayerScene(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent settingsscene = FXMLLoader.load(Controller.class.getResource("singleChoosePokemon.fxml"));
        Scene setwin = new Scene(settingsscene);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(setwin);
        window.show();
    }

    public void MultiplayerScene(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent settingsscene = FXMLLoader.load(Controller.class.getResource("ChoosePokemon.fxml"));
        Scene setwin = new Scene(settingsscene);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        settingsscene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();

            }
        });

        settingsscene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setX(event.getScreenX() - xOffset);
                window.setY(event.getScreenY() - yOffset);
            }
        });
        window.setScene(setwin);
        window.show();
    }

    public void ExitG(javafx.event.ActionEvent actionEvent) {
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){}
}
