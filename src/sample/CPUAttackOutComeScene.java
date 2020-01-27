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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CPUAttackOutComeScene {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML private Label P1namePlate;
    @FXML private Label P2namePlate;

    public Label hplabel;

    static double num1;
    static double num2;
    static double num3;

    public Rectangle hpbar1;

    @FXML private Label string1;
    @FXML private Label string2;
    @FXML private Label string3;
    @FXML private Label string4;

    private static int setAmt1;
    private static int setAmt2;
    private static int setAmt3;
    private static int setAmt4;
    private static int testnum;
    private static int testnum2;
    private static int testnum3;
    private static int testnum4;
    private static int PP1;
    private static int PP2;
    private static int PP3;
    private static int PP4;
    private static int count1;


    public ImageView image3;
    public ImageView image4;

    private List<Pokemon> Team5 = new ArrayList<>();
    private List<Pokemon> Team6 = new ArrayList<>();

    public void setHplabel(List<Pokemon> team){
        if(team.get(0).getCurrentHP() <= 0){
            hplabel.setText("HP : " + 0);

        }
        else {
            hplabel.setText("HP : " + team.get(0).getCurrentHP());
        }
    }


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

    void setP2namePlate(List<Pokemon> team) { P2namePlate.setText("CPU :  " + team.get(0).getNickname());}


    public void setstring2(String faint){
        string2.setText(faint);
    }


    Attack chooseAttack_AI(Pokemon name) {
        final Attack struggle = new DamageAttack("Struggle", PokemonType.NORMAL,  25, 15);
        // choose at random - pokemon are not very smart
        int rand = new Random().nextInt(name.getAttacks().size());
        if (name.getAttacks().get(rand) == name.getAttacks().get(0)) { setAmt1 = name.getAttacks().get(0).getAttack_amt();
             PP1 = setAmt1 - testnum++;
            if(PP1 == 0) {
                name.getAttacks().remove(name.getAttacks().get(0));
                System.out.println("No more PP!");
                if(name.getAttacks().size() == 0){
                    System.out.println("0.Struggle");
                    name.getAttacks().add(struggle);
                }
                return name.getAttacks().get(new Random().nextInt(name.getAttacks().size()));}
        }
        else if (name.getAttacks().get(rand) == name.getAttacks().get(1)) { setAmt2 = name.getAttacks().get(1).getAttack_amt();
            PP2 = setAmt2 - testnum2++;
            if(PP2 == 0) {
                name.getAttacks().remove(name.getAttacks().get(1));
                System.out.println("No more PP!");
                if(name.getAttacks().size() == 0){
                    System.out.println("0.Struggle");
                    name.getAttacks().add(struggle);
                }
                return name.getAttacks().get(new Random().nextInt(name.getAttacks().size()));}}
        else if (name.getAttacks().get(rand) == name.getAttacks().get(2)) { setAmt3 = name.getAttacks().get(2).getAttack_amt();
            PP3 = setAmt3 - testnum3++;
            if(PP3 == 0) {
                name.getAttacks().remove(name.getAttacks().get(2));
                System.out.println("No more PP!");
                if(name.getAttacks().size() == 0){
                    System.out.println("0.Struggle");
                    name.getAttacks().add(struggle);
                }
                return name.getAttacks().get(new Random().nextInt(name.getAttacks().size()));}}
        else if (name.getAttacks().get(rand) == name.getAttacks().get(3)) { setAmt4 = name.getAttacks().get(3).getAttack_amt();
            PP4 = setAmt4 - testnum4++;
            if(PP4 == 0) {
                name.getAttacks().remove(name.getAttacks().get(3));
                System.out.println("No more PP!");
                if(name.getAttacks().size() == 0){
                    System.out.println("0.Struggle");
                    name.getAttacks().add(struggle);
                }
                return name.getAttacks().get(new Random().nextInt(name.getAttacks().size()));}
        }
        return name.getAttacks().get(rand);
    }

    public void CPU_Attack(List<Pokemon> attacker, List<Pokemon> defender, int num1, int num2) {
        string4.setText(" ");
        string3.setText(" ");
        string2.setText(" ");
        //if attacker poisoned do static 25 dmg
        if (attacker.get(num1).getCurrentStatus() == Status.POISONED) {
            attacker.get(num1).usepoisend();
            string4.setText(attacker.get(0).getNickname() + " took 25 damage from Poison");
            float probablitity2 = 10.9f;
            float random2 = new Random().nextFloat();
            if (random2 < probablitity2) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
                string2.setText(attacker.get(0).getNickname() + " broke Poisoned effect");
            }
        }
        if (attacker.get(num1).getCurrentStatus() == Status.BURNED) {
            attacker.get(num1).usepoisend();
            string4.setText(attacker.get(0).getNickname() + " took 25 damage from Burn");
            float breakchance1 = 10.9f;
            float breakchance2 = new Random().nextFloat();
            if (breakchance2 > breakchance1) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
                string2.setText(attacker.get(0).getNickname() + " broke effect");
            }
        }
        //checking attacker status for protect
        if (attacker.get(num1).getCurrentStatus() == Status.PROTECTED) {
            //confusing i know but if defending pokemon has protect print pokemon protected
            string1.setText(defender.get(0).getNickname() + " Protected");
            //count1 to 1 or one attack phase then reset status to normal
            count1++;
            if (count1 == 1) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
            }
            //here instead of canceling protected pokemon cancel attacking
            return;
        }
        //attacker status not normal return status if probability of breaking higher than random set status to normal
        if (attacker.get(num1).getCurrentStatus() != Status.NORMAL && attacker.get(num1).getCurrentStatus() != Status.POISONED && attacker.get(num1).getCurrentStatus()
                != Status.PROTECTED && attacker.get(num1).getCurrentStatus() != Status.BURNED) {
            string1.setText(attacker.get(0).getNickname() + " is " + attacker.get(0).getCurrentStatus().toString().toLowerCase() + "!");
            float probability = .9f;
            float random = new Random().nextFloat();
            if (random < probability) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
                string2.setText(attacker.get(0).getNickname() + " broke effect");
            }
        }

        else {
            //choosing an attack
            Attack attack = attacker.get(num1).chooseAttack_AI(attacker.get(num1));
            //using attack on self
            final Attack protect = new toolStatusAttack("Protect", PokemonType.NORMAL, Status.PROTECTED, 5);
            if (attack.equals(protect)) {
                attacker.get(num1).setCurrentStatus(Status.PROTECTED);
            }

            //if random float greater than probability than attacker missed attack else use attack
            float probability2 = 1.1f;
            float random2 = new Random().nextFloat();
            //problem needs to be more modular
            if (random2 > probability2) {
                string1.setText(attacker.get(0).getNickname() + "'s Attack missed");
                return;
            }
            string1.setText(attacker.get(0).getNickname() + " used " + attack.getName() + " ");
            //must block this if user uses protect
            string3.setText(attack.useAttack(defender.get(0)));
        }
    }




    public void AttackButtonPushed(ActionEvent actionEvent) throws IOException {
        if (Team5.get(0).hasFainted()) {Team5.remove(Team5.get(0));}
        if(Team5.size() == 0){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("End_Of_Game_Scene.fxml"));
            Parent settingsscene = loader.load();
            EndOfGameScene controller = loader.getController();
            controller.outcome("P1 is out of Pokemon CPU has won!");
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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("singleChooseAttackScene.fxml"));
            Parent settingsscene = loader.load();
            SingleChooseAttackScene controller = loader.getController();
            controller.Team2(Team5, Team6);
            controller.getTeam1(Team5);
            controller.getTeam2(Team6);
            controller.setTeam5(Team5);
            controller.setTeam6(Team6);
            controller.setHplabel(Team5);
            controller.setP1namePlate(Team5);
            controller.setP2namePlate(Team6);
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
            window.show();}}


    public void RunButtonPushed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("End_Of_Game_Scene.fxml"));
        Parent settingsscene = loader.load();
        EndOfGameScene controller = loader.getController();
        controller.outcome("P1 has ran away CPU won!");
        Scene setwin= new Scene(settingsscene);
        Stage window2 = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        settingsscene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY(); }});

        settingsscene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window2.setX(event.getScreenX() - xOffset);
                window2.setY(event.getScreenY() - yOffset); }});
        window2.setScene(setwin);
        window2.show();}

    public void Pick_Pokemon(ActionEvent event) throws  IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SinglePickPokemon.fxml"));
        Parent settingsscene = loader.load();
        SinglePickPokemon controller = loader.getController();
        controller.getT1(Team5);
        controller.getT2(Team6);
        controller.pullTeam(Team5);
        Scene setwin= new Scene(settingsscene);
        Stage window2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        settingsscene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY(); } });

        settingsscene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window2.setX(event.getScreenX() - xOffset);
                window2.setY(event.getScreenY() - yOffset); }});
        window2.setScene(setwin);
        window2.show();}

}
