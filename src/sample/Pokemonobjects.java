package sample;

import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokemonobjects {
    public static void main(String[] args){
    }
    //giving pokemon random attack dmg  in a range from 15 to 50 works with pokemon type dmg calc
    private static int rand_att_dmg1(){
        Random random = new Random();
        return random.nextInt(50 -15 + 1) +15;}

    //giving pokemon their own methods to be able to place them in a list and users can pick pokemon from that method array list
    static Pokemon bublbasaur() throws IOException {
        //array of names to make it easier to add or take away attack names
        String[] attacknames = {"Tackle", "Razor Leaf", "Quick Attack", "Sleep Powder"};
        //attack using random damge method with added constant values
        final Attack tackle = new DamageAttack(attacknames[0], PokemonType.NORMAL, rand_att_dmg1(), 15);
        final Attack razorleaf = new DamageAttack(attacknames[1], PokemonType.GRASS, rand_att_dmg1() , 15);
        final Attack quickattack = new DamageAttack(attacknames[2], PokemonType.NORMAL, rand_att_dmg1(), 15);
        final Attack sleeppowder = new StatusAttack(attacknames[3], PokemonType.GRASS, Status.ASLEEP, 0.9f, 10);
        final List<Attack> bulbasaurAttacks = new ArrayList<>();
        //adding attacks to pokemon attack list
        bulbasaurAttacks.add(tackle);
        bulbasaurAttacks.add(razorleaf);
        bulbasaurAttacks.add(quickattack);
        bulbasaurAttacks.add(sleeppowder);
        URL backUrl = Pokemonobjects.class.getResource("/res/BulbasaurBack.png");
        URL frontUrl = Pokemonobjects.class.getResource("/res/Bulbasaur.png");
        Image front = new Image(String.valueOf(frontUrl));
        Image back = new Image(String.valueOf(backUrl));
        return new Pokemon("Bulbasaur", PokemonType.GRASS, 100, bulbasaurAttacks, front, back);}

    static Pokemon magikarp() throws IOException {
        String[] attacknames = {};
        final List<Attack> magikarpAttacks = new ArrayList<>();
        URL backUrl = Pokemonobjects.class.getResource("/res/MagikarpBack.png");
        URL frontUrl = Pokemonobjects.class.getResource("/res/Magikarp.png");
        Image front = new Image(String.valueOf(frontUrl));
        Image back = new Image(String.valueOf(backUrl));
        return new Pokemon("Magikarp", PokemonType.WATER, 100,magikarpAttacks, front, back);}

    static Pokemon squirtle() throws IOException {
        String[] attacknames = {"Tackle", "Sing", "Water Gun", "Bubble", "Protect"};
        final Attack protect = new toolStatusAttack(attacknames[4], PokemonType.NORMAL, Status.PROTECTED, 5);
        final Attack tackle = new DamageAttack(attacknames[0], PokemonType.NORMAL, rand_att_dmg1(), 15);
        final Attack sing = new StatusAttack(attacknames[1], PokemonType.NORMAL, Status.ASLEEP, 0.9f, 10);
        final Attack watergun = new DamageAttack(attacknames[2], PokemonType.WATER, rand_att_dmg1() + 20, 15);
        final Attack bubble = new DamageAttack(attacknames[3], PokemonType.WATER, rand_att_dmg1() + 15, 15);
        final List<Attack> squirtleAttacks = new ArrayList<>();
        squirtleAttacks.add(tackle);
        squirtleAttacks.add(watergun);
        squirtleAttacks.add(sing);
        squirtleAttacks.add(protect);
        URL backUrl = Pokemonobjects.class.getResource("/res/SquirtleBack.png");
        URL frontUrl = Pokemonobjects.class.getResource("/res/Squirtle.png");
        Image front = new Image(String.valueOf(frontUrl));
        Image back = new Image(String.valueOf(backUrl));
        return new Pokemon("Squirtle", PokemonType.WATER, 100, squirtleAttacks,front, back);}

    static Pokemon charmander() throws IOException {
        String[] attacknames = {"Tackle", "Ember", "Quick attack", "Flamethrower"};
        final Attack tackle = new DamageAttack(attacknames[0], PokemonType.NORMAL, rand_att_dmg1(), 15);
        final Attack ember = new StatusDamageAttack(attacknames[1], PokemonType.FIRE,Status.BURNED, .9f, rand_att_dmg1()+15, 10);
        final Attack quickattack = new DamageAttack(attacknames[2], PokemonType.NORMAL, rand_att_dmg1() + 10, 15);
        final Attack flamethrower = new DamageAttack(attacknames[3], PokemonType.FIRE, rand_att_dmg1() + 20, 10);
        final List<Attack> CharmanderAttacks = new ArrayList<>();
        CharmanderAttacks.add(tackle);
        CharmanderAttacks.add(ember);
        CharmanderAttacks.add(quickattack);
        CharmanderAttacks.add(flamethrower);
        URL backUrl = Pokemonobjects.class.getResource("/res/CharmanderBack.png");
        URL frontUrl = Pokemonobjects.class.getResource("/res/Charmander.png");
        Image front = new Image(String.valueOf(frontUrl));
        Image back = new Image(String.valueOf(backUrl));
        return new Pokemon("Charmander", PokemonType.FIRE, 100, CharmanderAttacks, front, back);}

    static Pokemon pikachu() throws IOException {
        String[] attacknames = {"Tackle", "Thunderbolt", "Quick attack", "Wild Charge"};
        final Attack tackle = new DamageAttack(attacknames[0], PokemonType.NORMAL, rand_att_dmg1(), 15);
        final Attack thunderbolt = new StatusDamageAttack(attacknames[1], PokemonType.ELECTRIC, Status.PARALYZED, 0.5f, rand_att_dmg1(), 10);
        final Attack quickattack = new DamageAttack(attacknames[2], PokemonType.NORMAL, rand_att_dmg1() + 10, 15);
        final Attack wildcharge = new DamageAttack(attacknames[3], PokemonType.ELECTRIC, rand_att_dmg1() + 20, 15);
        final List<Attack> pikachuAttacks = new ArrayList<>();
        pikachuAttacks.add(tackle);
        pikachuAttacks.add(thunderbolt);
        pikachuAttacks.add(quickattack);
        pikachuAttacks.add(wildcharge);
        URL backUrl = Pokemonobjects.class.getResource("/res/PikachuBack.png");
        URL frontUrl = Pokemonobjects.class.getResource("/res/Pikachu.png");
        Image front = new Image(String.valueOf(frontUrl));
        Image back = new Image(String.valueOf(backUrl));
        return new Pokemon("Pikachu", PokemonType.ELECTRIC, 100, pikachuAttacks, front, back);}

    static Pokemon onix() throws IOException {
        String[] attacknames = {"Tackle", "Rock Smash", "Rock Throw", "Rock Slide", "Protect"};
        final Attack rocksmash = new DamageAttack(attacknames[0], PokemonType.ROCK, rand_att_dmg1(), 15);
        final Attack tackle = new DamageAttack(attacknames[1], PokemonType.NORMAL, rand_att_dmg1() + 15, 15);
        final Attack rockthrow = new DamageAttack(attacknames[2], PokemonType.ROCK, rand_att_dmg1() + 15, 15);
        final Attack rockslide = new DamageAttack(attacknames[3], PokemonType.ROCK, rand_att_dmg1() + 30, 15);
        final  Attack protect = new GStatusAttacks(attacknames[4], PokemonType.NORMAL, Status.PROTECTED, 0, 5);
        final List<Attack> OnixAttacks = new ArrayList<>();
        OnixAttacks.add(tackle);
        OnixAttacks.add(rocksmash);
        OnixAttacks.add(rockthrow);
        OnixAttacks.add(rockslide);
        URL backUrl = Pokemonobjects.class.getResource("/res/OnixBack.png");
        URL frontUrl = Pokemonobjects.class.getResource("/res/Onix.png");
        Image front = new Image(String.valueOf(frontUrl));
        Image back = new Image(String.valueOf(backUrl));
        return new Pokemon("Onix", PokemonType.ROCK, 100, OnixAttacks, front , back);}

    static Pokemon Venonat() throws IOException {
        String[] attacknames = {"Sleep Powder", "Stun Spore", "Poison Powder", "Signal Beam", "Tackle"};
        final Attack sleeppowder = new StatusAttack(attacknames[0], PokemonType.GRASS, Status.ASLEEP, 0.9f, 10);
        final Attack Poisonpowder = new GStatusAttacks(attacknames[2], PokemonType.BUG, Status.POISONED, 25, 10);
        final Attack signalbeam = new DamageAttack(attacknames[3], PokemonType.BUG, rand_att_dmg1(), 15);
        final Attack stunspore = new GStatusAttacks(attacknames[1], PokemonType.BUG, Status.PARALYZED, 0, 10);
        final List<Attack> venonatAttacks = new ArrayList<>();
        venonatAttacks.add(sleeppowder);
        venonatAttacks.add(Poisonpowder);
        venonatAttacks.add(signalbeam);
        venonatAttacks.add(stunspore);
        URL backUrl = Pokemonobjects.class.getResource("/res/VenonatBack.png");
        URL frontUrl = Pokemonobjects.class.getResource("/res/Venonat.png");
        Image front = new Image(String.valueOf(frontUrl));
        Image back = new Image(String.valueOf(backUrl));
        return new Pokemon("Venonat", PokemonType.BUG, 100, venonatAttacks, front, back);}

    static Gen_2_Pokemon Arcanine() throws IOException {
        String[] attacknames = {"Tackle","Ember","Flamethrower","Flame Charge" };
        final Attack tackle = new DamageAttack(attacknames[0], PokemonType.NORMAL, rand_att_dmg1(), 15);
        final Attack ember = new StatusDamageAttack(attacknames[1], PokemonType.FIRE,Status.BURNED, .9f, rand_att_dmg1()+15, 10);
        final Attack flamethrower = new DamageAttack(attacknames[2], PokemonType.FIRE, rand_att_dmg1() + 30, 10);
        final Attack flamecharge = new DamageAttack(attacknames[3], PokemonType.FIRE, rand_att_dmg1() + 40, 10);
        final List<Attack> ArcanineAttacks = new ArrayList<>();
        ArcanineAttacks.add(tackle);
        ArcanineAttacks.add(ember);
        ArcanineAttacks.add(flamethrower);
        ArcanineAttacks.add(flamecharge);
        URL frontUrl = Pokemonobjects.class.getResource("/res/Arcanine.png");
        URL backUrl = Pokemonobjects.class.getResource("/res/ArcanineBack.png");
        Image back = new Image(String.valueOf(frontUrl));
        Image front = new Image(String.valueOf(backUrl));
        return new Gen_2_Pokemon("Arcanine", PokemonType.FIRE, 100, ArcanineAttacks, "glasses", front, back );}


    public static List pokemonlist() throws IOException {
        List<Pokemon> listOfpkmn = new ArrayList<>();
        listOfpkmn.add(bublbasaur());
        listOfpkmn.add(squirtle());
        listOfpkmn.add(magikarp());
        listOfpkmn.add(charmander());
        listOfpkmn.add(pikachu());
        listOfpkmn.add(onix());
        listOfpkmn.add(Venonat());
        listOfpkmn.add(Arcanine());
        return listOfpkmn;
    }

}
