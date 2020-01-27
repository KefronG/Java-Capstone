package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
    //count for getting rid of protected status in taketurn
    private static int count1 = 0;
    //count for getting rid of protected status in taketurn2
    private static int count2 = 0;
    //count for potion1
    private static int count3 = 0;
    //count for potion2
    private static int count4 = 0;
    //count for lumberry1
    private static int count5 = 0;
    //count for lumberry2
    private static int count6 = 0;
    private static int count7 = 0;
    private static int count8 = 0;
    private static int Wincount1 = 0;
    private static int Wincount2 = 0;
    private static int Wincount3 = 0;
    private static int Wincount4 = 0;

    /*
    FOR TEAMS: BATTLE LOOPS AND TAKE TURNS HAVE TO BE SPLIT WITH PKMN1 AMD PKMN2 HAVE THEIR OWN METHODS SO END COUNT CAN DECIDE WINNER
    WHILE LOOPING THROUGH POKEMON TEAM
        To Do list:
        Methods to pick pokemon ✓
        Methods to pick attack ✓
        Methods to battle ✓
        methods to heal hp / break status effect ✓
         */
    public static void main(String[] args) throws IOException { Battle(); }
    //first user input for picking pokemon
    private static int P1_pokemon_Choice(){
        //input number for a pokemon
        Scanner One_input = new Scanner(System.in);
        return One_input.nextInt();
    }
    //second user input for picking pokemon
    private static int P2_pokemon_Choice(){
        //input number for a pokemon
        Scanner One_input = new Scanner(System.in);
        return One_input.nextInt();
    }
    //user input for picking through pokemon attack index
    static int P_attack_Choice(){
        //input number for attack
        System.out.println("Pick attack: ");
        Scanner One_input = new Scanner(System.in);
        return One_input.nextInt();
    }
    private static void potion1(Pokemon name){
        //set how many potions user can use if user exceeds don't heal and display no more potions
        if(count3 == 3){
            System.out.println("No more potions to use");
        }
        else {
            count3++;
            int pots = 3 - count3;
            //use method located in Pokemon class
            name.usepotion();
            System.out.println(name.getNickname() + " Has healed 150 HP   " + pots+" potions left");
        }
    }
    private static void potion2(Pokemon name){
        //set how many potions user can use if user exceeds don't heal and display no more potions
        if(count4 == 3){
            System.out.println("No more potions to use");
        }
        else {
            count4++;
            int pots = 3 - count4;
            //use method located in Pokemon class
            name.usepotion();
            System.out.println(name.getNickname() + " Has healed 150 HP   " + pots+" potions left");
        }
    }
    //like potions but sets status to normal
    private static void lumberry1(Pokemon name){
        if(count5 == 3){
            System.out.println("No more lum berry's to use");
        }
        else {
            name.setCurrentStatus(Status.NORMAL);
            count5++;
            int pots = 3 - count5;
            System.out.println(name.getNickname() + " Has healed  " + pots+" Lum Berry's left");
        }
    }
    private static void lumberry2(Pokemon name){
        if(count6 == 3){
            System.out.println("No more lum berry's to use");
        }
        else {
            name.setCurrentStatus(Status.NORMAL);
            count6++;
            int pots = 3 - count6;
            System.out.println(name.getNickname() + " Has healed  " + pots+" Lum Berry's left");
        }
    }
    //for CPU to choose to heal when health is between 0 and 120
    private static int randomheal(){
        Random random1 = new Random();
        return random1.nextInt(120);
    }
    private static void PLAYER_OPTIONS(List<Pokemon> attacker, List<Pokemon> defender, int num1, int num2, String name ){


        System.out.println("\n" + name + " : " + attacker.get(num1).getNickname() + " HP: " + attacker.get(num1).getCurrentHP());
        //choose to attack or use item

        System.out.println(" 1.BAG 2.ATTACK 3.Pokemon");
        Scanner input1 = new Scanner(System.in);
        int user_input1 = input1.nextInt();
        if (user_input1 == 1) {
            //potions heal for 150 and can over heal
            System.out.println("1.USE Potion");
            // lum berry heals any status effect
            System.out.println("2.USE Lum Berry");
            System.out.println(" 3.Go back");
            int user_input2 = input1.nextInt();
            if (user_input2 == 1) {
                if(name.equals("P2")){
                    potion2(attacker.get(num1));
                }else {
                    potion1(attacker.get(num1));
                }

            } else if (user_input2 == 2) {
                if(name.equals("P2")){
                    lumberry2(attacker.get(num1));
                }else {
                    lumberry1(attacker.get(num1));
                }
            } else if (user_input2 == 3) {
                multi_player(attacker, defender, 0, 0);
            } else {
                System.out.println("Invalid Entry");
                multi_player(attacker, defender, 0, 0);
            }

        } else if (user_input1 == 2) {
            PLAYER_Attack(attacker,defender,0,0);

        }
        else if (user_input1 == 3) {
            for (int i = 0; i < attacker.size(); i++) {
                System.out.println(i + "." + attacker.get(i).getNickname());
            }
            System.out.println("pick a Pokemon : ");
            Scanner picpokemon = new Scanner(System.in);
            int in = picpokemon.nextInt();
            num1 = in;
            Pokemon pk1 = attacker.get(0);
            attacker.set(0,attacker.get(num1));
            attacker.set(num1,pk1);
            if (in > attacker.size()) {
                System.out.println("Invalid Entry");
                PLAYER_OPTIONS(defender,attacker, 0, 0, "P2");
            }
        }
        else {
            System.out.println("Invalid Entry");
            multi_player(attacker, defender, 0, 0);
        }

    }
    private static void CPU_OPTIONS(List<Pokemon> attacker, List<Pokemon> defender, int num1, int num2, String name ){
        System.out.println("\n"+ name + " : " + attacker.get(num1).getNickname() + " HP: " + attacker.get(num1).getCurrentHP());
        System.out.println(" 1.BAG 2.ATTACK 3.Pokemon");
        float probability2 = .1f;
        float random2 = new Random().nextFloat();
        float random3 = new Random().nextFloat();
        if (random2 > probability2) {
            if (attacker.get(num1).getCurrentHP() <= randomheal()) {
                potion2(attacker.get(num1));
            } else if (defender.get(num2).getCurrentStatus() != Status.NORMAL && defender.get(num2).getCurrentStatus() != Status.PROTECTED) {
                lumberry2(attacker.get(num1));
            }
        }
        else if(random3 < probability2 && attacker.size() <= 2){

            if(attacker.get(num1).getCurrentHP() <= randomheal() || random2 > probability2){

                Random random = new Random();
                num1 = random.nextInt(attacker.size());
                Pokemon pk1 = attacker.get(0);
                attacker.set(0,attacker.get(num1));
                attacker.set(num1,pk1);
            }
        }
        CPU_Attack(attacker,defender,0,0);
    }
    private static void PLAYER_Attack(List<Pokemon> attacker, List<Pokemon> defender, int num1, int num2){

        //if attacker poisoned do static 25 dmg
        if (attacker.get(num1).getCurrentStatus() == Status.POISONED) {
            attacker.get(num1).usepoisend();
            System.out.println(attacker.get(num1).getNickname() + " took 25 damage from Poison");
            float probablitity2 = 10.9f;
            float random2 = new Random().nextFloat();
            if (random2 < probablitity2) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
                System.out.println(attacker.get(num1).getNickname() + " broke Poisoned effect");
            }
        }
        if (attacker.get(num1).getCurrentStatus() == Status.BURNED) {
            attacker.get(num1).usepoisend();
            System.out.println(attacker.get(num1).getNickname() + " took 25 damage from Burn");
            float breakchance1 = 10.9f;
            float breakchance2 = new Random().nextFloat();
            if (breakchance2 > breakchance1) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
                System.out.println(attacker.get(num1).getNickname() + " broke effect");
            }
        }
        //checking attacker status for protect
        if (attacker.get(num1).getCurrentStatus() == Status.PROTECTED) {
            //confusing i know but if defending pokemon has protect print pokemon protected
            System.out.println(defender.get(num2).getNickname() + " Protected");
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
            System.out.println(attacker.get(num1).getNickname() + " is " + attacker.get(num1).getCurrentStatus().toString().toLowerCase() + "!");
            float probability = .9f;
            float random = new Random().nextFloat();
            if (random < probability) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
                System.out.println(attacker.get(num1).getNickname() + " broke effect");
            }
        } else {
            //choosing an attack
            Attack attack = attacker.get(num1).chooseAttack(attacker.get(num1));
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
                System.out.println(attacker.get(num1).getNickname() + "'s Attack missed");
                return;
            }
            System.out.println(attacker.get(num1).getNickname() + " used " + attack.getName() + "!");
            //must block this if user uses protect
            attack.useAttack(defender.get(num2));
        }
    }
    private static void CPU_Attack(List<Pokemon> attacker, List<Pokemon> defender, int num1, int num2) {

        //if attacker poisoned do static 25 dmg
        if (attacker.get(num1).getCurrentStatus() == Status.POISONED) {
            attacker.get(num1).usepoisend();
            System.out.println(attacker.get(num1).getNickname() + " took 25 damage from Poison");
            float probablitity2 = 10.9f;
            float random2 = new Random().nextFloat();
            if (random2 < probablitity2) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
                System.out.println(attacker.get(num1).getNickname() + " broke Poisoned effect");
            }
        }
        if (attacker.get(num1).getCurrentStatus() == Status.BURNED) {
            attacker.get(num1).usepoisend();
            System.out.println(attacker.get(num1).getNickname() + " took 25 damage from Burn");
            float breakchance1 = 10.9f;
            float breakchance2 = new Random().nextFloat();
            if (breakchance2 > breakchance1) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
                System.out.println(attacker.get(num1).getNickname() + " broke effect");
            }
        }
        //checking attacker status for protect
        if (attacker.get(num1).getCurrentStatus() == Status.PROTECTED) {
            //confusing i know but if defending pokemon has protect print pokemon protected
            System.out.println(defender.get(num2).getNickname() + " Protected");
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
            System.out.println(attacker.get(num1).getNickname() + " is " + attacker.get(num1).getCurrentStatus().toString().toLowerCase() + "!");
            float probability = .9f;
            float random = new Random().nextFloat();
            if (random < probability) {
                attacker.get(num1).setCurrentStatus(Status.NORMAL);
                System.out.println(attacker.get(num1).getNickname() + " broke effect");
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
                System.out.println(attacker.get(num1).getNickname() + "'s Attack missed");
                return;
            }
            System.out.println(attacker.get(num1).getNickname() + " used " + attack.getName() + "!");
            //must block this if user uses protect
            attack.useAttack(defender.get(num2));
        }
    }

    private static void multi_player(List<Pokemon> attacker, List<Pokemon> defender, int num1, int num2) {
        while (true) {
            if (attacker.get(num1).hasFainted()) { Wincount1++; System.out.println(attacker.get(num1).getNickname() + " has fainted!"); attacker.remove(attacker.get(num1));return; }
            PLAYER_OPTIONS(attacker,defender,0,0, "P1");
            if (defender.get(num2).hasFainted()) { Wincount2++;System.out.println(defender.get(num2).getNickname() + " has fainted!"); defender.remove(defender.get(num2));return; }
            PLAYER_OPTIONS(defender,attacker,0,0, "P2");
        }
    }
    private static void single_player(List<Pokemon> attacker, List<Pokemon> defender, int num1, int num2) {
        while (true) {
            if (attacker.get(num1).hasFainted()) { Wincount3++;System.out.println(attacker.get(num1).getNickname() + " has fainted!"); attacker.remove(attacker.get(num1));return; }
            PLAYER_OPTIONS(attacker,defender,0,0, "P1");
            if (defender.get(num2).hasFainted()) { Wincount4++;System.out.println(defender.get(num2).getNickname() + " has fainted! \n"); defender.remove(defender.get(num2));return; }
            CPU_OPTIONS(defender,attacker,0,0, "P2");
        }


    }

    //Take turn method here //// change choose attack in Pokemon class to get specific array indexes
    //user attack and reaction to status effect used for multiplayer

    //used for single player

    //battle loop this loop is the multiplayer loop
    // count for a static number set to 0 so it wont restart every time pokemon called
    // had to add two of each item one for each player or else one player could use all of potions or berries

    //single player battle loop

    //taketurn2 is used to get random attack
    //instead of pkmn1 put first user pokemon method

    //last wrapper choose to play multiplayer or single player


    private static void Battle() throws IOException {
        System.out.println("POKEMON BATTLE!");
        System.out.println("|1.Single  Player | 2.Multiplayer|");
        Scanner input = new Scanner(System.in);
        int user_input = input.nextInt();
        if (user_input == 1) {
            Pokemon pkmn1 = Pokemonobjects.bublbasaur();
            Pokemon pkmn2 = Pokemonobjects.squirtle();
            Pokemon pkmn3 = Pokemonobjects.charmander();
            Pokemon pkmn4 = Pokemonobjects.pikachu();
            Pokemon pkmn5 = Pokemonobjects.onix();
            Pokemon pkmn6 = Pokemonobjects.magikarp();
            Pokemon pkmn7 = Pokemonobjects.Venonat();
            Pokemon pkmn8 = Pokemonobjects.Arcanine();

            Pokemon pkmn9 = Pokemonobjects.bublbasaur();
            Pokemon pkmn10 = Pokemonobjects.squirtle();
            Pokemon pkmn11 = Pokemonobjects.charmander();
            Pokemon pkmn12 = Pokemonobjects.pikachu();
            Pokemon pkmn13 = Pokemonobjects.onix();
            Pokemon pkmn14 = Pokemonobjects.magikarp();
            Pokemon pkmn15 = Pokemonobjects.Venonat();
            Pokemon pkmn16 = Pokemonobjects.Arcanine();

            List<Pokemon> pokemonList1 = new ArrayList<>();
            pokemonList1.add(pkmn1);
            pokemonList1.add(pkmn2);
            pokemonList1.add(pkmn3);
            pokemonList1.add(pkmn4);
            pokemonList1.add(pkmn5);
            pokemonList1.add(pkmn6);
            pokemonList1.add(pkmn7);
            pokemonList1.add(pkmn8);

            List<Pokemon> pokemonList2 = new ArrayList<>();
            pokemonList2.add(pkmn9);
            pokemonList2.add(pkmn10);
            pokemonList2.add(pkmn11);
            pokemonList2.add(pkmn12);
            pokemonList2.add(pkmn13);
            pokemonList2.add(pkmn14);
            pokemonList2.add(pkmn15);
            pokemonList2.add(pkmn16);
            System.out.println("How how many pokemon do you want to battle with?");
            Scanner input2 = new Scanner(System.in);
            int user_input2 = input2.nextInt();
            Random random = new Random();
            int randpokemon = random.nextInt(6);
            List<Pokemon> Team1 = new ArrayList<>();
            System.out.println("Player 1 pick your Pokemon Team: 0.Bulbasaur 1.Squirtle 2.Charmander 3.Pikachu 4.Onix 5.Magikarp 6.Venonat 7.Cyndaquil 8.Random");
            for (int i = 0; i < user_input2; i++) {
                Scanner input3 = new Scanner(System.in);
                int user_input3 = input3.nextInt();
                if(user_input3 == 8){Team1.add(pokemonList1.get(randpokemon));}
                else if(user_input3 > pokemonList1.size()){
                    System.out.println("Invalid choice, Random pokemon selected");
                    Team1.add(pokemonList1.get(randpokemon));
                }
                else { Team1.add(pokemonList1.get(user_input3)); }
            }

            List<Pokemon> Team2 = new ArrayList<>();
            for (int i2 = 0; i2 < user_input2; i2++) {
                Team2.add(pokemonList2.get(randpokemon));
            }
            while(Team1.size() != 0 || Team2.size() != 0){
                if(Team1.size() == 0){ System.out.print("P1 is out of Pokemon ");break; }
                else if(Team2.size() == 0){ System.out.print("CPU is out of Pokemon ");break; }
                single_player(Team1,Team2, 0, 0);

            }
            if(Wincount3 > Wincount4){
                System.out.println("CPU HAS WON THE BATTLE!");
            }
            else if(Wincount3 < Wincount4){
                System.out.println("P1 HAS WON THE BATTLE!");
            }
            else{
                System.out.println("THE OUTCOME IS A TIE!");
            }

        } else if (user_input == 2) {

            Pokemon pkmn1 = Pokemonobjects.bublbasaur();
            Pokemon pkmn2 = Pokemonobjects.squirtle();
            Pokemon pkmn3 = Pokemonobjects.charmander();
            Pokemon pkmn4 = Pokemonobjects.pikachu();
            Pokemon pkmn5 = Pokemonobjects.onix();
            Pokemon pkmn6 = Pokemonobjects.magikarp();
            Pokemon pkmn7 = Pokemonobjects.Venonat();
            Pokemon pkmn8 = Pokemonobjects.Arcanine();

            Pokemon pkmn9 = Pokemonobjects.bublbasaur();
            Pokemon pkmn10 = Pokemonobjects.squirtle();
            Pokemon pkmn11 = Pokemonobjects.charmander();
            Pokemon pkmn12 = Pokemonobjects.pikachu();
            Pokemon pkmn13 = Pokemonobjects.onix();
            Pokemon pkmn14 = Pokemonobjects.magikarp();
            Pokemon pkmn15 = Pokemonobjects.Venonat();
            Pokemon pkmn16 = Pokemonobjects.Arcanine();

            List<Pokemon> pokemonList3 = new ArrayList<>();
            pokemonList3.add(pkmn1);
            pokemonList3.add(pkmn2);
            pokemonList3.add(pkmn3);
            pokemonList3.add(pkmn4);
            pokemonList3.add(pkmn5);
            pokemonList3.add(pkmn6);
            pokemonList3.add(pkmn7);
            pokemonList3.add(pkmn8);

            List<Pokemon> pokemonList4 = new ArrayList<>();
            pokemonList4.add(pkmn9);
            pokemonList4.add(pkmn10);
            pokemonList4.add(pkmn11);
            pokemonList4.add(pkmn12);
            pokemonList4.add(pkmn13);
            pokemonList4.add(pkmn14);
            pokemonList4.add(pkmn15);
            pokemonList4.add(pkmn16);


            System.out.println("How how many pokemon do you want to battle with? \n");
            Scanner input4 = new Scanner(System.in);
            int user_input4 = input4.nextInt();
            List<Pokemon> Team3 = new ArrayList<>();
            Random random9 = new Random();
            Random random8 = new Random();
            int randpokemon9 = random9.nextInt(6);
            int randpokemon8 = random8.nextInt(6);
            //System.out.println("Teams are shuffled after selection \n");
            System.out.println("Player 1 pick your Pokemon Team: 0.Bulbasaur 1.Squirtle 2.Charmander 3.Pikachu 4.Onix 5.Magikarp 6.Venonat 7.Cyndaquil");
            for (int i3 = 0; i3 < user_input4; i3++) {
                Scanner input5 = new Scanner(System.in);
                int user_input5 = input5.nextInt();
                if(user_input5 > pokemonList3.size()){
                    System.out.println("Invalid choice, Random pokemon selected");
                    Team3.add(pokemonList3.get(randpokemon9)); }
                else {
                    Team3.add(pokemonList3.get(user_input5));
                }
            }
            List<Pokemon> Team4 = new ArrayList<>();
            System.out.println("Player 2 pick your Pokemon Team: 0.Bulbasaur 1.Squirtle 2.Charmander 3.Pikachu 4.Onix 5.Magikarp 6.Venonat 7.Cyndaquil");
            for (int i4 = 0; i4 < user_input4; i4++) {
                Scanner input6 = new Scanner(System.in);
                int user_input6 = input6.nextInt();
                Team4.add(pokemonList4.get(user_input6));
            }
            while(Team3.size() != 0 || Team4.size() != 0){
                if(Team3.size() == 0){ System.out.print("P1 is out of Pokemon ");break; }
                else if(Team4.size() == 0){ System.out.print("P2 is out of Pokemon ");break; }
                multi_player(Team3,Team4, 0, 0);

            }
            if(Wincount1 > Wincount2){
                System.out.println("PLAYER 1 HAS WON THE BATTLE!");
            }
            else if(Wincount1 < Wincount2){
                System.out.println("PLAYER 2 HAS WON THE BATTLE!");
            }
            else{
                System.out.println("THE OUTCOME IS A TIE!");
            }
        }
        else{
            System.out.println("Invalid choice");
            Battle();
        }
    }

    // TO DO: /// Have pokemon attack amount not depended on Attack type /// Get hold
}
