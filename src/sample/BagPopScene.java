package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.applet.Main;

import java.io.IOException;

public class BagPopScene implements EventHandler<ActionEvent>{


    public void rtn(){
        FXMLLoader clsLoad = new FXMLLoader(getClass().getResource("Bag_Pop_Scene.fxml"));
        //Stage stg = (Stage) getClass().getResource();


    }























    @Override
    public void handle(ActionEvent event) {

    }
}
