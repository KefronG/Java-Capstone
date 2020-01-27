package sample;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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

public class ChooseAttackScene implements EventHandler<ActionEvent> {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML private Label P1namePlate;
    @FXML private Label P2namePlate;

    public Button attack1;
    public Button attack2;
    public Button attack3;
    public Button attack4;

    public Label attackPP1;
    public Label attackPP2;
    public Label attackPP3;
    public Label attackPP4;

    public Label hplabel;

    private static int setAmt1;
    private static int testnum;
    private static int testnum2;
    private static int testnum3;
    private static int testnum4;


    static int statichp;

    float num1;
    float num2;
    float num3;

    public ImageView image3;
    public ImageView image4;

    public Rectangle hpbar1;

    private List<Pokemon> Team5 = new ArrayList<>();
    private List<Pokemon> Team6 = new ArrayList<>();


    void Team2(List<Pokemon> name, List<Pokemon> name2) {
        image3.setImage(name.get(0).getImagefile2());
        image4.setImage(name2.get(0).getImagefile1()); }

    void setP1namePlate(List<Pokemon> team) { P1namePlate.setText("P1 :  " + team.get(0).getNickname());}
    void setP2namePlate(List<Pokemon> team) { P2namePlate.setText("P2 :  " + team.get(0).getNickname());}

    public void setHplabel(List<Pokemon> team){
        if(team.get(0).getCurrentHP() <= 0){
            hplabel.setText("HP : " + 0);

        }
        else {
            hplabel.setText("HP : " + team.get(0).getCurrentHP());
        }
    }
    private int getOGhp(int num){
        return num;
    }



    void setP1HpBar(int Ohp){
        num1 = Ohp;
        num2 = (num1 / Team6.get(0).getCurrentHP());
       num3 = (num2 * 142);
       hpbar1.setWidth(num3);
       System.out.print(Team5.get(0));
    }



    void getTeam1(List<Pokemon> team) { Team5 = team;}
    void getTeam2(List<Pokemon> team) { Team6 = team;}

    void setTeam5(List<Pokemon> team5) {
        final Attack struggle = new DamageAttack("Struggle", PokemonType.NORMAL, 25, 15);
        Team5 = team5;
        String s1 =Team5.get(0).getPokemonAttacks(Team5.get(0), 0).getName();
        String s2 =Team5.get(0).getPokemonAttacks(Team5.get(0), 1).getName();
        String s3 =Team5.get(0).getPokemonAttacks(Team5.get(0), 2).getName();
        String s4 =Team5.get(0).getPokemonAttacks(Team5.get(0), 3).getName();


        if((attkAmt(Team5.get(0), Team5.get(0).getAttacks().get(0)) - testnum) <= 0){
            attack1.setDisable(true);
            attack1.setTextFill(Color.valueOf("#6b6a68"));
            attackPP1.setTextFill(Color.valueOf("#6b6a68"));

        }
        if((attkAmt(Team5.get(0), Team5.get(0).getAttacks().get(1)) - testnum2) <= 0){
            attack2.setDisable(true);
            attack2.setTextFill(Color.valueOf("#6b6a68"));
            attackPP2.setTextFill(Color.valueOf("#6b6a68"));

        }
        if((attkAmt(Team5.get(0), Team5.get(0).getAttacks().get(2)) - testnum3) <= 0){
            attack3.setDisable(true);
            attack3.setTextFill(Color.valueOf("#6b6a68"));
            attackPP3.setTextFill(Color.valueOf("#6b6a68"));

        }
        if((attkAmt(Team5.get(0), Team5.get(0).getAttacks().get(3)) - testnum4) <= 0){
            attack4.setDisable(true);
            attack4.setTextFill(Color.valueOf("#6b6a68"));
            attackPP4.setTextFill(Color.valueOf("#6b6a68"));


        }
        if((attkAmt(Team5.get(0), Team5.get(0).getAttacks().get(0)) - testnum) <= 0
                &&(attkAmt(Team5.get(0), Team5.get(0).getAttacks().get(1)) - testnum2) <= 0
                &&(attkAmt(Team5.get(0), Team5.get(0).getAttacks().get(2)) - testnum3) <= 0
                &&(attkAmt(Team5.get(0), Team5.get(0).getAttacks().get(3)) - testnum4) <= 0){
            s1 = "Struggle";
            attack1.setTextFill(Color.valueOf("#ffa41c"));
            Team5.get(0).getAttacks().remove(rtn_attk1(Team5.get(0)));
            Team5.get(0).getAttacks().add(0,struggle);
            attack1.setDisable(false);
        }

        buttonsettext(s1,s2,s3,s4);
        setPP(Team5);
    }



    void setTeam6(List<Pokemon> team6){ Team6 =team6; }


    private void setPP(List<Pokemon> name){
        attackPP1.setText("PP : " + name.get(0).getAttacks().get(0).getAttack_amt() + " / " + (attkAmt(name.get(0), name.get(0).getAttacks().get(0)) - testnum) +"\n");
        attackPP2.setText("PP : " + name.get(0).getAttacks().get(1).getAttack_amt() + " / " + (attkAmt(name.get(0), name.get(0).getAttacks().get(1)) - testnum2) +"\n");
        attackPP3.setText("PP : " + name.get(0).getAttacks().get(2).getAttack_amt() + " / " + (attkAmt(name.get(0), name.get(0).getAttacks().get(2)) - testnum3) +"\n");
        attackPP4.setText("PP : " + name.get(0).getAttacks().get(3).getAttack_amt() + " / " + (attkAmt(name.get(0), name.get(0).getAttacks().get(3)) - testnum4) +"\n");
    }

    private void buttonsettext(String att1, String att2, String att3, String att4){
        attack1.setText(att1);attack2.setText(att2);attack3.setText(att3);attack4.setText(att4); }



    private Attack rtn_attk1(Pokemon name){ return name.getAttacks().get(0);}


    private Attack rtn_attk2(Pokemon name){ return name.getAttacks().get(1); }


    private Attack rtn_attk3(Pokemon name){ return name.getAttacks().get(2);}


    private Attack rtn_attk4(Pokemon name){ return name.getAttacks().get(3);}

    private int attkAmt(Pokemon name, Attack attk){ setAmt1 = name.getAttacks().get(name.getAttacks().indexOf(attk)).getAttack_amt();return setAmt1; }

    public void Attack1ButtonPushed(ActionEvent event) throws IOException {
        if(Team6.size() == 0){
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
            window2.show(); }


        if(event.getSource() == attack1){ testnum++; }



        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Attack_Outcome_Scene.fxml"));
        Parent settingsscene = loader.load();
        AttackOutcomeScene controller = loader.getController();
        controller.getTeam1(Team5);
        controller.getTeam2(Team6);
        controller.Team3(Team5,Team6);
        controller.setP1namePlate(Team5);
        controller.setP2namePlate(Team6);
        controller.PLAYER_Attack(Team5,Team6, rtn_attk1(Team5.get(0)));
        controller.setHplabel(Team6);
        if(Team6.get(0).hasFainted()){

            controller.setstring2(Team6.get(0).getNickname() + " has fainted!");


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


    public void Attack2ButtonPushed(ActionEvent event) throws IOException {
        if(Team6.size() == 0){
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
            window2.show(); }


        if(event.getSource() == attack2){ testnum2++; }


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Attack_Outcome_Scene.fxml"));
        Parent settingsscene = loader.load();
        AttackOutcomeScene controller = loader.getController();
        controller.getTeam1(Team5);
        controller.getTeam2(Team6);
        controller.Team3(Team5,Team6);
        controller.setP1namePlate(Team5);
        controller.setP2namePlate(Team6);
        controller.PLAYER_Attack(Team5,Team6, rtn_attk2(Team5.get(0)));
        controller.setHplabel(Team6);

        if(Team6.get(0).hasFainted()){

            controller.setstring2(Team6.get(0).getNickname() + " has fainted!");


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
        if(Team6.size() == 0){
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
            window2.show(); }


        if(event.getSource() == attack3){ testnum3++; }


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Attack_Outcome_Scene.fxml"));
        Parent settingsscene = loader.load();
        AttackOutcomeScene controller = loader.getController();
        controller.getTeam1(Team5);
        controller.getTeam2(Team6);
        controller.Team3(Team5,Team6);
        controller.setP1namePlate(Team5);
        controller.setP2namePlate(Team6);
        controller.PLAYER_Attack(Team5,Team6, rtn_attk3(Team5.get(0)));
        controller.setHplabel(Team6);
        if(Team6.get(0).hasFainted()){

            controller.setstring2(Team6.get(0).getNickname() + " has fainted!");


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

        if(Team6.size() == 0){
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
            window2.show(); }


        if(event.getSource() == attack4){ testnum4++; }


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Attack_Outcome_Scene.fxml"));
        Parent settingsscene = loader.load();
        AttackOutcomeScene controller = loader.getController();
        controller.getTeam1(Team5);
        controller.getTeam2(Team6);
        controller.Team3(Team5,Team6);
        controller.setP1namePlate(Team5);
        controller.setP2namePlate(Team6);
        controller.PLAYER_Attack(Team5,Team6, rtn_attk4(Team5.get(0)));
        controller.setHplabel(Team6);
        if(Team6.get(0).hasFainted()){

            controller.setstring2(Team6.get(0).getNickname() + " has fainted!");


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
    public void RunButtonPushed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("End_Of_Game_Scene.fxml"));
        Parent settingsscene = loader.load();
        EndOfGameScene controller = loader.getController();
        controller.outcome("P1 has ran away P2 won!");
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
        window2.show();
    }
    public void Pick_Pokemon(ActionEvent event) throws  IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Pick_Pokemon_Scene.fxml"));
        Parent settingsscene = loader.load();
        PickPokemonScene controller = loader.getController();
        controller.getT1(Team5);
        controller.getT2(Team6);
        controller.pullTeam(Team5);
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
        window2.show();
    }



    @Override
    public void handle(ActionEvent event){}


}

