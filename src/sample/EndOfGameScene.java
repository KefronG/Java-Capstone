package sample;

import javafx.scene.control.Label;

public class EndOfGameScene {

    public Label whoWon;

    public void ExitG(javafx.event.ActionEvent actionEvent) {
        System.exit(0);
    }

    void outcome(String str1){ whoWon.setText(str1); }
}
