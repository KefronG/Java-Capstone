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

public class AttackOutcomeScene {

    //points for moving Stage (Window) around

    private double xOffset = 0;
    private double yOffset = 0;

    // The labels for the HP plate names
    @FXML private Label P1namePlate;
    @FXML private Label P2namePlate;

   // Dialog strings outputs attacks, status effects and the like.
    @FXML private Label string1;
    @FXML private Label string2;
    @FXML private Label string3;
    @FXML private Label string4;

    //static numbers for Hp bar
    static double num1;
    static double num2;
    static double num3;

    //Label for displaying text hp amount
    public Label hplabel;

    //physical repersentation of hp set to a rectangle
    public Rectangle hpbar1;

    //ImageView used to display pokemon images a type of container for images (but found in scene builder controls)
    public ImageView image5;
    public ImageView image6;

    //every control class creates a new set of arraylist to use for next scene, so i pull original team from ChoosePokemon and copy them to the new list
    private List<Pokemon> Team7 = new ArrayList<>();
    private List<Pokemon> Team8 = new ArrayList<>();

    //
    private int count1;

    void setP1HpBar(List<Pokemon> team){
        num1 = team.get(0).getCurrentHP();
        num2 = (team.get(0).getCurrentHP() / num1);
        num3 = (num2 * 142);
        hpbar1.setWidth(num3);
        System.out.print(num3);
    }

    //Method for setting hp label of current pokemon set in index one on the main hp plate
    public void setHplabel(List<Pokemon> team){
        if(team.get(0).getCurrentHP() <= 0){
            hplabel.setText("HP : " + 0);

        }
        else {
            hplabel.setText("HP : " + team.get(0).getCurrentHP());
        }
    }

    // this is where images of the pokemon are set from so the method is called from the previous  scene
    void Team3(List<Pokemon> name, List<Pokemon> name2) {
        image5.setImage(name2.get(0).getImagefile2());
        image6.setImage(name.get(0).getImagefile1()); }


        // using this method to set the privouse scenes pokemon arraylist to this ones.
    void getTeam1(List<Pokemon> team) { Team7 = team;}
    void getTeam2(List<Pokemon> team) { Team8 = team;}


    void setP1namePlate(List<Pokemon> team) { P1namePlate.setText("P1 :  " + team.get(0).getNickname());}
    void setP2namePlate(List<Pokemon> team) { P2namePlate.setText("P2 :  " + team.get(0).getNickname());}


    // this method is called when a pokemon faints i had seprated from other label variables because it would not out put before scene was over
    public void setstring2(String faint){
        string2.setText(faint);
    }

    public void AttackButtonPushed(ActionEvent actionEvent) throws IOException {
        //when the button is pressed it checks if the pokemon has faint if so it removes it
        if (Team8.get(0).hasFainted()) {Team8.remove(Team8.get(0));}
        //and if the pokemon list size is equal to zero it sends the player or players to the ending scene
        if(Team8.size() == 0){
            FXMLLoader loader = new FXMLLoader();
            //loading the sample package then get accessing that packages controller to access its methods and variables and using this controllers variables with that
            //controller classes methods. In order to pass data in between scenes.
            loader.setLocation(getClass().getResource("End_Of_Game_Scene.fxml"));
            Parent settingsscene = loader.load();
            EndOfGameScene controller = loader.getController();
            controller.outcome("P2 is out of Pokemon P1 has won!");
            Scene setwin= new Scene(settingsscene);
            Stage window2 = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            settingsscene.setOnMouseClicked(new EventHandler<MouseEvent>() {
                // these handle methods are set up to detect if window is clicked on and if dragged set the window in the new position based on mouse pointer location relative to
                // computer screen.
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
            //if team has or has not fainted but size != 0 switch scenes to player 2 choose attack and it will continue this loop until size is empty or
            //player chooses to run.
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("P2ChooseAttackScene.fxml"));
            Parent settingsscene = loader2.load();
            P2ChooseAttackScene controller2 = loader2.getController();
            controller2.Team2(Team7, Team8);
            controller2.setTeam6(Team8);
            controller2.setTeam5(Team7);
            controller2.getTeam1(Team7);
            controller2.getTeam2(Team8);
            controller2.setP1namePlate(Team7);
            controller2.setP2namePlate(Team8);
            controller2.setHplabel(Team8);
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
            window2.show(); } }

            // this method is used to check for status effects on the attackers and using the other la
    void PLAYER_Attack(List<Pokemon> attacker, List<Pokemon> defender, Attack attk) throws IOException {
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
            string1.setText(attacker.get(0).getNickname() + " used " + attk.getName() + " " );
            string3.setText(attk.useAttack(defender.get(0)));}}

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
        controller.getT1(Team8);
        controller.getT2(Team7);
        controller.pullTeam(Team8);
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
