package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChoosePokemon {
    @FXML private CheckBox Check1;
    @FXML private CheckBox Check2;
    @FXML private CheckBox Check3;
    @FXML private CheckBox Check4;
    @FXML private CheckBox Check5;
    @FXML private CheckBox Check6;
    @FXML private CheckBox Check7;
    @FXML private CheckBox Check8;
    @FXML private CheckBox Check9;
    @FXML private CheckBox Check10;
    @FXML private CheckBox Check11;
    @FXML private CheckBox Check12;
    @FXML private CheckBox Check13;
    @FXML private CheckBox Check14;
    @FXML private CheckBox Check15;
    @FXML private CheckBox Check16;
    @FXML private Label invalid;



    private double xOffset = 0;
    private double yOffset = 0;


    private static List PokemonList1() throws IOException {
        List<Pokemon> pokemonList3 = new ArrayList<>();
        Pokemon pkmn1 = Pokemonobjects.bublbasaur();
        Pokemon pkmn2 = Pokemonobjects.squirtle();
        Pokemon pkmn3 = Pokemonobjects.charmander();
        Pokemon pkmn4 = Pokemonobjects.pikachu();
        Pokemon pkmn5 = Pokemonobjects.onix();
        Pokemon pkmn6 = Pokemonobjects.Venonat();
        Pokemon pkmn7 = Pokemonobjects.Arcanine();
        Pokemon pkmn8 = Pokemonobjects.magikarp();
        pokemonList3.add(pkmn1);
        pokemonList3.add(pkmn2);
        pokemonList3.add(pkmn3);
        pokemonList3.add(pkmn4);
        pokemonList3.add(pkmn5);
        pokemonList3.add(pkmn6);
        pokemonList3.add(pkmn7);
        pokemonList3.add(pkmn8);
        return pokemonList3;
    }
    private static List PokemonList2() throws IOException {
        List<Pokemon> pokemonList4 = new ArrayList<>();
        Pokemon pkmn9 = Pokemonobjects.bublbasaur();
        Pokemon pkmn10 = Pokemonobjects.squirtle();
        Pokemon pkmn11 = Pokemonobjects.charmander();
        Pokemon pkmn12 = Pokemonobjects.pikachu();
        Pokemon pkmn13 = Pokemonobjects.onix();
        Pokemon pkmn14 = Pokemonobjects.Venonat();
        Pokemon pkmn15 = Pokemonobjects.Arcanine();
        Pokemon pkmn16 = Pokemonobjects.magikarp();
        pokemonList4.add(pkmn9);
        pokemonList4.add(pkmn10);
        pokemonList4.add(pkmn11);
        pokemonList4.add(pkmn12);
        pokemonList4.add(pkmn13);
        pokemonList4.add(pkmn14);
        pokemonList4.add(pkmn15);
        pokemonList4.add(pkmn16);
        return pokemonList4;
    }

    private void Team3() throws IOException {
        if(Check1.isSelected()){
            Team.add((Pokemon) PokemonList1().get(0));
        }
        if(Check2.isSelected()){
            Team.add((Pokemon) PokemonList1().get(1));
        }
        if(Check3.isSelected()){
            Team.add((Pokemon) PokemonList1().get(2));
        }
        if(Check4.isSelected()){
            Team.add((Pokemon) PokemonList1().get(3));
        }
        if(Check5.isSelected()){
            Team.add((Pokemon) PokemonList1().get(4));
        }
        if(Check6.isSelected()){
            Team.add((Pokemon) PokemonList1().get(5));
        }
        if(Check7.isSelected()){
            Team.add((Pokemon) PokemonList1().get(6));
        }
        if(Check8.isSelected()){
            Team.add((Pokemon) PokemonList1().get(7));
        }
    }

    private void Team4() throws IOException {
        if(this.Check9.isSelected()){
            Team2.add((Pokemon) PokemonList2().get(0));
        }
        if(this.Check10.isSelected()){
            Team2.add((Pokemon) PokemonList2().get(1));
        }
        if(this.Check11.isSelected()){
            Team2.add((Pokemon) PokemonList2().get(2));
        }
        if(this.Check12.isSelected()){
            Team2.add((Pokemon) PokemonList2().get(3));
        }
        if(this.Check13.isSelected()){
            Team2.add((Pokemon) PokemonList2().get(4));
        }
        if(this.Check14.isSelected()){
            Team2.add((Pokemon) PokemonList2().get(5));
        }
        if(this.Check15.isSelected()){
            Team2.add((Pokemon) PokemonList2().get(6));
        }
        if(this.Check16.isSelected()){
            Team2.add((Pokemon) PokemonList2().get(7));
        }
    }

    private List<Pokemon> Team = new ArrayList<>();
    private List<Pokemon> Team2 = new ArrayList<>();

    public int pkmn1hp(){
        return Team2.get(0).getCurrentHP();
    }


    public void BattleButtonPushed(ActionEvent actionEvent) throws IOException {
        Team3();
        Team4();
        if(Team.size() > 6 || Team2.size() > 6){ invalid.setText("Team Sizes can be no bigger than 6");}
        else {
            Collections.shuffle(Team);
            Collections.shuffle(Team2);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Choose_Attack_Scene.fxml"));
            Parent settingsscene = loader.load();
            ChooseAttackScene controller = loader.getController();
            controller.Team2(Team, Team2);
            controller.getTeam1(Team);
            controller.getTeam2(Team2);
            controller.setTeam5(Team);
            controller.setTeam6(Team2);
            controller.setHplabel(Team);
            controller.setP1namePlate(Team);
            controller.setP2namePlate(Team2);
            Scene setwin = new Scene(settingsscene);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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
            window.show();} }

    public void Go_Back(ActionEvent actionEvent) throws IOException {
            Parent settingsscene = FXMLLoader.load(Controller.class.getResource("sample.fxml"));
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
            window.show();}

    public void Reset(ActionEvent actionEvent) throws IOException {
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
        window.show();}}
