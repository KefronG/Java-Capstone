package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class P2PickPokemon implements EventHandler<ActionEvent> {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    public ImageView pokemon1;
    @FXML  public ImageView pokemon2;
    @FXML  public ImageView pokemon3;
    @FXML  public ImageView pokemon4;
    @FXML  public ImageView pokemon5;
    @FXML  public ImageView pokemon6;

    @FXML public Button name1;
    @FXML public Button  name2;
    @FXML public Button  name3;
    @FXML public Button  name4;
    @FXML public Button  name5;
    @FXML public Button  name6;

    @FXML public Label pkmHP1;
    @FXML public Label pkmHP2;
    @FXML public Label pkmHP3;
    @FXML public Label pkmHP4;
    @FXML public Label pkmHP5;
    @FXML public Label pkmHP6;


    private List<Pokemon> Team9 = new ArrayList<>();
    private List<Pokemon> Team10 = new ArrayList<>();


    void getT1(List<Pokemon> team) { Team9 = team;}
    void getT2(List<Pokemon> team){ Team10 =team; }


    public void Exit(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("P2ChooseAttackScene.fxml"));
        Parent settingsscene = loader2.load();
        P2ChooseAttackScene controller2 = loader2.getController();
        controller2.Team2(Team10, Team9);
        controller2.setTeam6(Team9);
        controller2.setTeam5(Team10);
        controller2.setP1namePlate(Team10);
        controller2.setP2namePlate(Team9);
        controller2.setHplabel(Team10);
        Scene setwin2 = new Scene(settingsscene);
        Stage window2 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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
                window2.setX(event.getScreenX() - xOffset);
                window2.setY(event.getScreenY() - yOffset);
            }
        });
        window2.setScene(setwin2);
        window2.show();}

    void pullTeam(List<Pokemon> name){
        if(name.size() >= 1) {
            pokemon1.setImage(name.get(0).getImagefile1());
            name1.setText(name.get(0).getNickname());
            pkmHP1.setText("HP :" + name.get(0).getCurrentHP());}
        else{
            URL imgUrl = PickPokemonScene.class.getResource("/res/Blankimage.png");
            Image holdimg = new Image(String.valueOf(imgUrl));
            pokemon1.setImage(holdimg);
            name1.setText(" ");
            pkmHP1.setText(" ");}


        if(name.size() >= 2) {
            pokemon2.setImage(name.get(1).getImagefile1());
            name2.setText(name.get(1).getNickname());
            pkmHP2.setText("HP :" + name.get(1).getCurrentHP());}
        else {
            URL imgUrl = PickPokemonScene.class.getResource("/res/Blankimage.png");
            Image holdimg = new Image(String.valueOf(imgUrl));
            pokemon2.setImage(holdimg);
            name2.setText(" ");
            pkmHP2.setText(" ");}

        if(name.size() >= 3) {
            pokemon3.setImage(name.get(2).getImagefile1());
            name3.setText(name.get(2).getNickname());
            pkmHP3.setText("" + name.get(2).getCurrentHP());}
        else{
            URL imgUrl = PickPokemonScene.class.getResource("/res/Blankimage.png");
            Image holdimg = new Image(String.valueOf(imgUrl));
            pokemon3.setImage(holdimg);
            name3.setText(" ");
            pkmHP3.setText(" ");}

        if(name.size() >= 4) {
            pokemon4.setImage(name.get(3).getImagefile1());
            name4.setText(name.get(3).getNickname());
            pkmHP4.setText("HP :" + name.get(3).getCurrentHP());}
        else {
            URL imgUrl = PickPokemonScene.class.getResource("/res/Blankimage.png");
            Image holdimg = new Image(String.valueOf(imgUrl));
            pokemon4.setImage(holdimg);
            name4.setText(" ");
            pkmHP4.setText(" ");}

        if(name.size() >= 5) {
            pokemon5.setImage(name.get(4).getImagefile1());
            name5.setText(name.get(4).getNickname());
            pkmHP5.setText("HP :" + name.get(4).getCurrentHP());}
        else {
            URL imgUrl = PickPokemonScene.class.getResource("/res/Blankimage.png");
            Image holdimg = new Image(String.valueOf(imgUrl));
            pokemon5.setImage(holdimg);
            name5.setText(" ");
            pkmHP5.setText(" ");}

        if(name.size() >= 6) {
            pokemon6.setImage(name.get(5).getImagefile1());
            name6.setText(name.get(5).getNickname());
            pkmHP6.setText("HP :" + name.get(5).getCurrentHP());}
        else{
            URL imgUrl = PickPokemonScene.class.getResource("/res/Blankimage.png");
            Image holdimg = new Image(String.valueOf(imgUrl));
            pokemon6.setImage(holdimg);
            name6.setText(" ");
            pkmHP6.setText(" ");}}

    public void pickPokemon2( ActionEvent actionEvent) throws IOException {
        Pokemon pkm1 = Team9.get(0);
        Team9.set(0,Team9.get(1));
        Team9.set(1,pkm1);
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("Choose_Attack_Scene.fxml"));
        Parent settingsscene = loader2.load();
        ChooseAttackScene controller2 = loader2.getController();
        controller2.Team2(Team10, Team9);
        controller2.setTeam6(Team9);
        controller2.setTeam5(Team10);
        controller2.getTeam1(Team10);
        controller2.getTeam2(Team9);
        controller2.setP1namePlate(Team10);
        controller2.setP2namePlate(Team9);
        controller2.setHplabel(Team10);
        Scene setwin2 = new Scene(settingsscene);
        Stage window2 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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
                window2.setX(event.getScreenX() - xOffset);
                window2.setY(event.getScreenY() - yOffset);
            }
        });
        window2.setScene(setwin2);
        window2.show();}

    public void pickPokemon3( ActionEvent actionEvent) throws IOException {
        Pokemon pkm1 = Team9.get(0);
        Team9.set(0,Team9.get(2));
        Team9.set(2,pkm1);
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("Choose_Attack_Scene.fxml"));
        Parent settingsscene = loader2.load();
        ChooseAttackScene controller2 = loader2.getController();
        controller2.Team2(Team10, Team9);
        controller2.setTeam6(Team9);
        controller2.setTeam5(Team10);
        controller2.getTeam1(Team10);
        controller2.getTeam2(Team9);
        controller2.setP1namePlate(Team10);
        controller2.setP2namePlate(Team9);
        controller2.setHplabel(Team10);
        Scene setwin2 = new Scene(settingsscene);
        Stage window2 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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
                window2.setX(event.getScreenX() - xOffset);
                window2.setY(event.getScreenY() - yOffset);
            }
        });
        window2.setScene(setwin2);
        window2.show();}

    public void pickPokemon4( ActionEvent actionEvent) throws IOException {
        Pokemon pkm1 = Team9.get(0);
        Team9.set(0,Team9.get(3));
        Team9.set(3,pkm1);
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("Choose_Attack_Scene.fxml"));
        Parent settingsscene = loader2.load();
        ChooseAttackScene controller2 = loader2.getController();
        controller2.Team2(Team10, Team9);
        controller2.setTeam6(Team9);
        controller2.setTeam5(Team10);
        controller2.getTeam1(Team10);
        controller2.getTeam2(Team9);
        controller2.setHplabel(Team10);
        controller2.setP1namePlate(Team10);
        controller2.setP2namePlate(Team9);
        Scene setwin2 = new Scene(settingsscene);
        Stage window2 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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
                window2.setX(event.getScreenX() - xOffset);
                window2.setY(event.getScreenY() - yOffset);
            }
        });
        window2.setScene(setwin2);
        window2.show();}


    public void pickPokemon5( ActionEvent actionEvent) throws IOException {
        Pokemon pkm1 = Team9.get(0);
        Team9.set(0,Team9.get(4));
        Team9.set(4,pkm1);
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("Choose_Attack_Scene.fxml"));
        Parent settingsscene = loader2.load();
        ChooseAttackScene controller2 = loader2.getController();
        controller2.Team2(Team10, Team9);
        controller2.setTeam6(Team9);
        controller2.setTeam5(Team10);
        controller2.getTeam1(Team10);
        controller2.getTeam2(Team9);
        controller2.setHplabel(Team10);
        controller2.setP1namePlate(Team10);
        controller2.setP2namePlate(Team9);
        Scene setwin2 = new Scene(settingsscene);
        Stage window2 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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
                window2.setX(event.getScreenX() - xOffset);
                window2.setY(event.getScreenY() - yOffset);
            }
        });
        window2.setScene(setwin2);
        window2.show();
    }
    public void pickPokemon6( ActionEvent actionEvent) throws IOException {
        Pokemon pkm1 = Team9.get(0);
        Team9.set(0,Team9.get(5));
        Team9.set(5,pkm1);
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("Choose_Attack_Scene.fxml"));
        Parent settingsscene = loader2.load();
        ChooseAttackScene controller2 = loader2.getController();
        controller2.Team2(Team10, Team9);
        controller2.setTeam6(Team9);
        controller2.setTeam5(Team10);
        controller2.getTeam1(Team10);
        controller2.getTeam2(Team9);
        controller2.setHplabel(Team10);
        controller2.setP1namePlate(Team10);
        controller2.setP2namePlate(Team9);
        Scene setwin2 = new Scene(settingsscene);
        Stage window2 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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
                window2.setX(event.getScreenX() - xOffset);
                window2.setY(event.getScreenY() - yOffset);
            }
        });
        window2.setScene(setwin2);
        window2.show();}

    @Override
    public void handle(ActionEvent event) {}}
