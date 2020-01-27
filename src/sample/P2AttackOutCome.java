package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P2AttackOutCome {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML private Label P1namePlate;
    @FXML private Label P2namePlate;

    public Label hplabel;


       static float num1;
              float num2;
              float num3;

    public Rectangle hpbar1;

    @FXML private Label string1;
    @FXML private Label string2;
    @FXML private Label string3;
    @FXML private Label string4;

    public ImageView image5;
    public ImageView image6;

    private List<Pokemon> Team7 = new ArrayList<>();
    private List<Pokemon> Team8 = new ArrayList<>();

    private int count1;

public void setHplabel(List<Pokemon> team){
    if(team.get(0).getCurrentHP() <= 0){
        hplabel.setText("HP : " + 0);

    }
    else {
        hplabel.setText("HP : " + team.get(0).getCurrentHP());
    }
}

public float setP1HpBar(List<Pokemon> team){
    num1 = team.get(0).getCurrentHP();
    num2 = (142 * (num1 / team.get(0).getCurrentHP()));
    hpbar1.setWidth(num2);
    System.out.print(num2);
    System.out.print(num2);
    System.out.print(team.get(0).getCurrentHP());
    return  num2;
}

void Team3(List<Pokemon> name, List<Pokemon> name2) {
    image5.setImage(name2.get(0).getImagefile2());
    image6.setImage(name.get(0).getImagefile1());}

void getTeam1(List<Pokemon> team) { Team7 = team;}
void getTeam2(List<Pokemon> team) { Team8 = team;}

void setP1namePlate(List<Pokemon> team) { P1namePlate.setText("P1 :  " + team.get(0).getNickname());}

void setP2namePlate(List<Pokemon> team) { P2namePlate.setText("P2 :  " + team.get(0).getNickname());}

public void setstring2(String faint){
    string2.setText(faint);
}


public void AttackButtonPushed(ActionEvent actionEvent) throws IOException {
    if (Team7.get(0).hasFainted()) {Team7.remove(Team7.get(0));}
    if(Team7.size() == 0){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("End_Of_Game_Scene.fxml"));
        Parent settingsscene = loader.load();
        EndOfGameScene controller = loader.getController();
        controller.outcome("P1 is out of Pokemon P2 has won!");
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
            window2.show(); }

        else {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("Choose_Attack_Scene.fxml"));
            Parent settingsscene = loader2.load();
            ChooseAttackScene controller2 = loader2.getController();
            controller2.Team2(Team7, Team8);
            controller2.setTeam6(Team8);
            controller2.setTeam5(Team7);
            controller2.setP1namePlate(Team7);
            controller2.setP2namePlate(Team8);
            controller2.setHplabel(Team7);
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
            window2.show();}}

    void PLAYER_Attack(List<Pokemon> attacker, List<Pokemon> defender, Attack attk){
        string4.setText(" ");
        string3.setText(" ");
        string2.setText(" ");
        //if attacker poisoned do static 25 dmg
        if (attacker.get(0).getCurrentStatus() == Status.POISONED) {
            attacker.get(0).usepoisend();
            string4.setText(attacker.get(0).getNickname() + " took 25 damage from Poison");
            float probablitity2 = 10.9f;
            float random2 = new Random().nextFloat();
            if (random2 < probablitity2) {
                attacker.get(0).setCurrentStatus(Status.NORMAL);
                string2.setText(attacker.get(0).getNickname() + " broke Poisoned effect");

            }
        }
        if (attacker.get(0).getCurrentStatus() == Status.BURNED) {
            attacker.get(0).usepoisend();
            string4.setText(attacker.get(0).getNickname() + " took 25 damage from Burn");
            float breakchance1 = 10.9f;
            float breakchance2 = new Random().nextFloat();
            if (breakchance2 < breakchance1) {
                attacker.get(0).setCurrentStatus(Status.NORMAL);
                string2.setText(attacker.get(0).getNickname() + " broke effect");
            }
        }
        //checking attacker status for protect
        if (attacker.get(0).getCurrentStatus() == Status.PROTECTED) {
            //confusing i know but if defending pokemon has protect print pokemon protected
            string1.setText(defender.get(0).getNickname() + " Protected");
            //count1 to 1 or one attack phase then reset status to normal

            count1++;
            if (count1 == 1) {
                attacker.get(0).setCurrentStatus(Status.NORMAL);
            }
            //here instead of canceling protected pokemon cancel attacking
            return;
        }
        //attacker status not normal return status if probability of breaking higher than random set status to normal
        if (attacker.get(0).getCurrentStatus() != Status.NORMAL && attacker.get(0).getCurrentStatus() != Status.POISONED && attacker.get(0).getCurrentStatus()
                != Status.PROTECTED && attacker.get(0).getCurrentStatus() != Status.BURNED) {
            string1.setText(attacker.get(0).getNickname() + " is " + attacker.get(0).getCurrentStatus().toString().toLowerCase() + "!");
            float probability = .9f;
            float random = new Random().nextFloat();
            if (random < probability) {
                attacker.get(0).setCurrentStatus(Status.NORMAL);
                string2.setText(attacker.get(0).getNickname() + " broke effect");
            }
        } else {
            //choosing an attack
            //using attack on self
            final Attack protect = new toolStatusAttack("Protect", PokemonType.NORMAL, Status.PROTECTED, 5);
            if (attk.equals(protect)) {
                attacker.get(0).setCurrentStatus(Status.PROTECTED);
            }

            //if random float greater than probability than attacker missed attack else use attack
            float probability2 = 1.1f;
            float random2 = new Random().nextFloat();
            //problem needs to be more modular
            if (random2 > probability2) {
                string1.setText(attacker.get(0).getNickname() + "'s Attack missed");
                return;
            }
            string1.setText(attacker.get(0).getNickname() + " used " + attk.getName() + " ");
            string3.setText(attk.useAttack(defender.get(0)));
        }
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
        window2.show();}

    public void Pick_Pokemon(ActionEvent event) throws  IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Pick_Pokemon_Scene.fxml"));
        Parent settingsscene = loader.load();
        PickPokemonScene controller = loader.getController();
        controller.getT1(Team7);
        controller.getT2(Team8);
        controller.pullTeam(Team7);
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
