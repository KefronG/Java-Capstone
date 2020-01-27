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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P2ChooseAttackScene extends ActionEvent {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML private Label P1namePlate;
    @FXML private Label P2namePlate;

    public Label hplabel;

    static double num1;
    static double num2;
    static double num3;

    public Rectangle hpbar1;

    public Button attack1;
    public Button attack2;
    public Button attack3;
    public Button attack4;

    public Label attackPP1;
    public Label attackPP2;
    public Label attackPP3;
    public Label attackPP4;

    private static int setAmt1;
    private static int testnum;
    private static int testnum2;
    private static int testnum3;
    private static int testnum4;

    public ImageView image3;
    public ImageView image4;

    private List<Pokemon> Team5 = new ArrayList<>();
    private List<Pokemon> Team6 = new ArrayList<>();

    void Team2(List<Pokemon> name, List<Pokemon> name2) {
        image3.setImage(name2.get(0).getImagefile2());
        image4.setImage(name.get(0).getImagefile1());}

    void getTeam1(List<Pokemon> team) { Team5 = team;}
    void getTeam2(List<Pokemon> team) { Team6 = team;}


    void setP1HpBar(List<Pokemon> team){
        num1 = team.get(0).getCurrentHP();
        num2 = (team.get(0).getCurrentHP() / num1);
        num3 = (num2 * 142);
        hpbar1.setWidth(num3);
        System.out.print(num3);
    }


    void setP1namePlate(List<Pokemon> team) { P1namePlate.setText("P1 :  " + team.get(0).getNickname());}

    void setP2namePlate(List<Pokemon> team) { P2namePlate.setText("P2 :  " + team.get(0).getNickname());}

    void setTeam5(List<Pokemon> team5) { Team5 = team5;}

    void setTeam6(List<Pokemon> team6){
        final Attack struggle = new DamageAttack("Struggle", PokemonType.NORMAL, 25, 15);
        Team6 =team6;
        String s1 =Team6.get(0).getPokemonAttacks(Team6.get(0), 0).getName();
        String s2 =Team6.get(0).getPokemonAttacks(Team6.get(0), 1).getName();
        String s3 =Team6.get(0).getPokemonAttacks(Team6.get(0), 2).getName();
        String s4 =Team6.get(0).getPokemonAttacks(Team6.get(0), 3).getName();

        if((attkAmt(Team6.get(0), Team6.get(0).getAttacks().get(0)) - testnum) <= 0 ){
            attack1.setDisable(true);
            attack1.setTextFill(Color.valueOf("#6b6a68"));
            attackPP1.setTextFill(Color.valueOf("#6b6a68"));
        }
        if((attkAmt(Team6.get(0), Team6.get(0).getAttacks().get(1)) - testnum2) <= 0 || Team6.get(0).getAttacks().size() <= 1){
            attack2.setDisable(true);
            attack2.setTextFill(Color.valueOf("#6b6a68"));
            attackPP2.setTextFill(Color.valueOf("#6b6a68"));
        }
        if((attkAmt(Team6.get(0), Team6.get(0).getAttacks().get(2)) - testnum3) <= 0 || Team6.get(0).getAttacks().size() <= 1){
            attack3.setDisable(true);
            attack3.setTextFill(Color.valueOf("#6b6a68"));
            attackPP3.setTextFill(Color.valueOf("#6b6a68"));
        }
        if((attkAmt(Team6.get(0), Team6.get(0).getAttacks().get(3)) - testnum4) <= 0 || Team6.get(0).getAttacks().size() <= 1){
            attack4.setDisable(true);
            attack4.setTextFill(Color.valueOf("#6b6a68"));
            attackPP4.setTextFill(Color.valueOf("#6b6a68"));

        }
        if((attkAmt(Team6.get(0), Team6.get(0).getAttacks().get(0)) - testnum) <= 0
                &&(attkAmt(Team6.get(0), Team6.get(0).getAttacks().get(1)) - testnum2) <= 0
                &&(attkAmt(Team6.get(0), Team6.get(0).getAttacks().get(2)) - testnum3) <= 0
                &&(attkAmt(Team6.get(0), Team6.get(0).getAttacks().get(3)) - testnum4) <= 0 || Team6.get(0).getAttacks().size() <= 1){
            s1 = "Struggle";
            attack1.setTextFill(Color.valueOf("#ffa41c"));
            Team6.get(0).getAttacks().remove(rtn_attk1(Team6.get(0)));
            Team6.get(0).getAttacks().add(0,struggle);
            attack1.setDisable(false);
        }
        buttonsettext(s1,s2,s3,s4);
        setPP(Team6);
    }


    private void setPP(List<Pokemon> name){
        attackPP1.setText("PP : " + name.get(0).getAttacks().get(0).getAttack_amt() + " / " + (attkAmt(name.get(0), name.get(0).getAttacks().get(0)) - testnum) +"\n");
        attackPP2.setText("PP : " + name.get(0).getAttacks().get(1).getAttack_amt() + " / " + (attkAmt(name.get(0), name.get(0).getAttacks().get(1)) - testnum2) +"\n");
        attackPP3.setText("PP : " + name.get(0).getAttacks().get(2).getAttack_amt() + " / " + (attkAmt(name.get(0), name.get(0).getAttacks().get(2)) - testnum3) +"\n");
        attackPP4.setText("PP : " + name.get(0).getAttacks().get(3).getAttack_amt() + " / " + (attkAmt(name.get(0), name.get(0).getAttacks().get(3)) - testnum4) +"\n");
    }

    private void buttonsettext(String att1, String att2, String att3, String att4){
        attack1.setText(att1);attack2.setText(att2);attack3.setText(att3);attack4.setText(att4); }

    public void setHplabel(List<Pokemon> team){
        if(team.get(0).getCurrentHP() <= 0){
            hplabel.setText("HP : " + 0);

        }
        else {
            hplabel.setText("HP : " + team.get(0).getCurrentHP());
        }
    }


    private Attack rtn_attk1(Pokemon name){ return name.getAttacks().get(0);}


    private Attack rtn_attk2(Pokemon name){ return name.getAttacks().get(1); }


    private Attack rtn_attk3(Pokemon name){ return name.getAttacks().get(2);}


    private Attack rtn_attk4(Pokemon name){ return name.getAttacks().get(3);}

    private int attkAmt(Pokemon name, Attack attk){ setAmt1 = name.getAttacks().get(name.getAttacks().indexOf(attk)).getAttack_amt();return setAmt1;}

    public void Attack1ButtonPushed(ActionEvent event) throws IOException {
        if(Team5.size() == 0){
            Parent settingsscene2 = FXMLLoader.load(Controller.class.getResource("End_Of_Game_Scene.fxml"));
            Scene setwin2 = new Scene(settingsscene2);
            Stage window2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            settingsscene2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();

                }
            });

            settingsscene2.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    window2.setX(event.getScreenX() - xOffset);
                    window2.setY(event.getScreenY() - yOffset);
                }
            });
            window2.setScene(setwin2);
            window2.show();}


        if(event.getSource() == attack1){ testnum++; }


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("P2AttackOutCome.fxml"));
        Parent settingsscene = loader.load();
        P2AttackOutCome controller = loader.getController();
        controller.getTeam1(Team5);
        controller.getTeam2(Team6);
        controller.Team3(Team6,Team5);
        controller.setP1namePlate(Team5);
        controller.setP2namePlate(Team6);
        controller.PLAYER_Attack(Team6,Team5, rtn_attk1(Team6.get(0)));
        controller.setHplabel(Team5);
        if(Team6.get(0).hasFainted()){

            controller.setstring2(Team5.get(0).getNickname() + " has fainted!");


        }
        Scene setwin = new Scene(settingsscene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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



    public void Attack2ButtonPushed(ActionEvent event) throws IOException {
        if(Team5.size() == 0){
            Parent settingsscene2 = FXMLLoader.load(Controller.class.getResource("End_Of_Game_Scene.fxml"));
            Scene setwin2 = new Scene(settingsscene2);
            Stage window2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            settingsscene2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();

                }
            });

            settingsscene2.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    window2.setX(event.getScreenX() - xOffset);
                    window2.setY(event.getScreenY() - yOffset);
                }
            });
            window2.setScene(setwin2);
            window2.show();}


        if(event.getSource() == attack2){ testnum2++;}

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("P2AttackOutCome.fxml"));
        Parent settingsscene = loader.load();
        P2AttackOutCome controller = loader.getController();
        controller.getTeam1(Team5);
        controller.getTeam2(Team6);
        controller.Team3(Team6,Team5);
        controller.setP1namePlate(Team5);
        controller.setP2namePlate(Team6);
        controller.PLAYER_Attack(Team6,Team5, rtn_attk2(Team6.get(0)));
        controller.setHplabel(Team5);
        if(Team6.get(0).hasFainted()){

            controller.setstring2(Team5.get(0).getNickname() + " has fainted!");


        }
        Scene setwin = new Scene(settingsscene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        window.show(); }

    public void Attack3ButtonPushed(ActionEvent event) throws IOException {
        if(Team5.size() == 0){
            Parent settingsscene2 = FXMLLoader.load(Controller.class.getResource("End_Of_Game_Scene.fxml"));
            Scene setwin2 = new Scene(settingsscene2);
            Stage window2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            settingsscene2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();

                }
            });

            settingsscene2.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    window2.setX(event.getScreenX() - xOffset);
                    window2.setY(event.getScreenY() - yOffset);
                }
            });
            window2.setScene(setwin2);
            window2.show();}


        if(event.getSource() == attack3){ testnum3++;}


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("P2AttackOutCome.fxml"));
        Parent settingsscene = loader.load();
        P2AttackOutCome controller = loader.getController();
        controller.getTeam1(Team5);
        controller.getTeam2(Team6);
        controller.Team3(Team6,Team5);
        controller.setP1namePlate(Team5);
        controller.setP2namePlate(Team6);
        controller.PLAYER_Attack(Team6,Team5, rtn_attk3(Team6.get(0)));
        controller.setHplabel(Team5);
        if(Team6.get(0).hasFainted()){

            controller.setstring2(Team5.get(0).getNickname() + " has fainted!");


        }
        Scene setwin = new Scene(settingsscene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        window.show(); }

    public void Attack4ButtonPushed(ActionEvent event) throws IOException {
        if(Team5.size() == 0){
            Parent settingsscene2 = FXMLLoader.load(Controller.class.getResource("End_Of_Game_Scene.fxml"));
            Scene setwin2 = new Scene(settingsscene2);
            Stage window2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            settingsscene2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();

                }
            });

            settingsscene2.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    window2.setX(event.getScreenX() - xOffset);
                    window2.setY(event.getScreenY() - yOffset);
                }
            });
            window2.setScene(setwin2);
            window2.show();}

        if(event.getSource() == attack4){ testnum4++;}


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("P2AttackOutCome.fxml"));
        Parent settingsscene = loader.load();
        P2AttackOutCome controller = loader.getController();
        controller.getTeam1(Team5);
        controller.getTeam2(Team6);
        controller.Team3(Team6,Team5);
        controller.setP1namePlate(Team5);
        controller.setP2namePlate(Team6);
        controller.PLAYER_Attack(Team6,Team5, rtn_attk4(Team6.get(0)));
        controller.setHplabel(Team5);
        if(Team6.get(0).hasFainted()){

            controller.setstring2(Team5.get(0).getNickname() + " has fainted!");


        }
        Scene setwin = new Scene(settingsscene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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


    public void RunButtonPushed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("End_Of_Game_Scene.fxml"));
        Parent settingsscene = loader.load();
        EndOfGameScene controller = loader.getController();
        controller.outcome("P2 has ran away P1 won!");
        Scene setwin= new Scene(settingsscene);
        Stage window2 = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
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
        window2.setScene(setwin);
        window2.show();}


    public void Pick_Pokemon(ActionEvent event) throws  IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("P2PickPokemon.fxml"));
        Parent settingsscene = loader.load();
        P2PickPokemon controller = loader.getController();
        controller.getT1(Team6);
        controller.getT2(Team5);
        controller.pullTeam(Team6);
        Scene setwin= new Scene(settingsscene);
        Stage window2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
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
        window2.setScene(setwin);
        window2.show();}}
