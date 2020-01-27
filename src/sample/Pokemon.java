package sample;

import javafx.scene.image.Image;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Pokemon {
        private final PokemonType type;
        private final List<Attack> attacks;
        private String nickname;
        private int currentHP;
        private Status currentStatus;
        private Image imagefile1;
        private Image imagefile2;

        Pokemon(final String species, final PokemonType type, final int maxHP, final List<Attack> attacks, Image file1, Image file2) throws IOException {
            this.type = type;
            final Attack struggle = new DamageAttack("Struggle", PokemonType.WATER,  25, 15);
            //keep eye on this or in this if statement can be used for protect attack
            if (attacks.size() < 1 || attacks.size() > 4) {
                attacks.add(struggle);
                //throw new IllegalArgumentException("Pokemon must know between one and four attacks.");
            }
            this.attacks = attacks;
            this.nickname = species;
            this.currentHP = maxHP;
            this.currentStatus = Status.NORMAL;
            this.imagefile1 = file1;
            this.imagefile2 = file2;
        }

    Image getImagefile1() {
        return imagefile1;
    }

    Image getImagefile2() {
        return imagefile2;
    }

    PokemonType getType() {
            return type;
        }
        public void setNickname(final String nickname) {
            if (nickname.contains("poop")) {
                throw new IllegalArgumentException("Please give your Pokemon a more polite nickname.");
            }
            this.nickname = nickname;
        }
        List<Attack> getAttacks() {
            return attacks;
        }
        private int attack1a = 1;
        private int attack2b = 1;
        private int attack3c = 1;
        private int attack4d = 1;
        //every pokemon has the ability to struggle when out of moves
        Attack chooseAttack_AI(Pokemon name) {
            final Attack struggle = new DamageAttack("Struggle", PokemonType.NORMAL,  25, 15);
            // choose at random - pokemon are not very smart
            int rand = new Random().nextInt(attacks.size());
            if (name.attacks.get(rand) == name.attacks.get(0)) { int amt = name.attacks.get(0).getAttack_amt();
                int AP = amt - attack1a++;
                if(AP == 0) {
                    name.attacks.remove(attacks.get(0));
                    if(name.getAttacks().size() == 0){
                        name.attacks.add(struggle);
                    }
                    return name.attacks.get(new Random().nextInt(attacks.size()));}
            }
            else if (name.attacks.get(rand) == name.attacks.get(1)) { int amt = name.attacks.get(1).getAttack_amt();
                int AP = amt - attack2b++;
                if(AP == 0) {
                    name.attacks.remove(attacks.get(1));
                    if(name.getAttacks().size() == 0){
                        name.attacks.add(struggle);
                    }
                    return name.attacks.get(new Random().nextInt(attacks.size()));}}
            else if (name.attacks.get(rand) == name.attacks.get(2)) { int amt = name.attacks.get(2).getAttack_amt();
                int AP = amt - attack3c++;
                if(AP == 0) {
                    name.attacks.remove(attacks.get(2));
                    if(name.getAttacks().size() == 0){
                        name.attacks.add(struggle);
                    }
                    return name.attacks.get(new Random().nextInt(attacks.size()));}}
            else if (name.attacks.get(rand) == name.attacks.get(3)) { int amt = name.attacks.get(3).getAttack_amt();
                int AP = amt - attack4d++;
                if(AP == 0) {
                    name.attacks.remove(attacks.get(3));
                    if(name.getAttacks().size() == 0){
                        name.attacks.add(struggle);
                    }
                    return name.attacks.get(new Random().nextInt(attacks.size()));}
            }
            return name.attacks.get(rand);
        }
        private int attack1 = 1;
        private int attack2 = 1;
        private int attack3 = 1;
        private int attack4 = 1;
        Attack chooseAttack(Pokemon name) {
            final Attack struggle = new DamageAttack("Struggle", PokemonType.WATER,  25, 15);
            for (int i = 0; i < name.getAttacks().size(); i++) {
                System.out.println(name.getAttacks().indexOf(name.getAttacks().get(i)) + "." + " " + name.getAttacks().get(i).getName() +
                        "  (" + name.getAttacks().get(i).getAttack_amt() + " PP)");
            }
            int input = checker(name);

            if (name.attacks.get(input) == name.attacks.get(0)) {
                int amt = name.attacks.get(input).getAttack_amt();
                int AP = amt - attack1++;
                //used abs because count would go negative
                System.out.println(name.getAttacks().get(0).getName() + " has " + Math.abs(AP) + " PP Left \n");
                if (AP == 0) {
                    name.attacks.remove(attacks.get(input));
                    System.out.println("No more PP!");
                    if (name.getAttacks().size() == 0) {
                        System.out.println("0.Struggle");
                        name.attacks.add(struggle);
                    }
                    return name.attacks.get(Player.P_attack_Choice());
                }
            } else if (name.attacks.get(input) == name.attacks.get(1)) {
                int amt = name.attacks.get(input).getAttack_amt();
                int AP = amt - attack2++;
                System.out.println(name.getAttacks().get(1).getName() + " has " + Math.abs(AP) + " PP Left \n");
                if (AP == 0) {
                    name.attacks.remove(attacks.get(input));
                    System.out.println("No more PP!");
                    if (name.getAttacks().size() == 0) {
                        System.out.println("0.Struggle");
                        name.attacks.add(struggle);
                    }
                    return name.attacks.get(Player.P_attack_Choice());
                }
            } else if (name.attacks.get(input) == name.attacks.get(2)) {
                int amt = name.attacks.get(input).getAttack_amt();
                int AP = amt - attack3++;
                System.out.println(name.getAttacks().get(2).getName() + " has " + Math.abs(AP) + " PP Left \n");
                if (AP == 0) {
                    name.attacks.remove(attacks.get(input));
                    System.out.println("No more PP!");
                    if (name.getAttacks().size() == 0) {
                        System.out.println("0.Struggle");
                        name.attacks.add(struggle);
                    }
                    return name.attacks.get(Player.P_attack_Choice());
                }
            } else if (name.attacks.get(input) == name.attacks.get(3)) {
                int amt = name.attacks.get(input).getAttack_amt();
                int AP = amt - attack4++;
                System.out.println(name.getAttacks().get(3).getName() + " has " + Math.abs(AP) + " PP Left \n");
                if (AP == 0) {
                    name.attacks.remove(attacks.get(input));
                    System.out.println("No more PP!");
                    if (name.getAttacks().size() == 0) {
                        System.out.println("0.Struggle");
                        name.attacks.add(struggle);
                    }
                    return name.attacks.get(Player.P_attack_Choice());
                }
            }
            return name.attacks.get(input);
        }

        private static int  checker(Pokemon name){ int input  = Player.P_attack_Choice();int num;num = input;
            if(num >= name.getAttacks().size()){ System.out.println("invalid choice, Using default attack");return 0;}
            else{ return num;}}

        Attack getPokemonAttacks(Pokemon name, int index) {return name.attacks.get(index);}

        //get specific attack using attack index and returning number
        Attack Attack_Names(int nameindex){return attacks.get(nameindex);}
        String getNickname()
        {
            return nickname;
        }

        void doDamage(final int damage)
        {
            currentHP -= damage;
        }


        int getCurrentHP()
        {
            return currentHP;
        }

        boolean hasFainted() { return (currentHP <= 0); }

        //adding 150 to currentHP down side can over upside you can heal
        void usepotion(){currentHP += 150;}

        void usepoisend(){ currentHP -= 25;}

        void setCurrentStatus(Status status)
        {
            currentStatus = status;
        }

        Status getCurrentStatus()
        {
            return currentStatus;
        }



        public void compareTypes(Pokemon target) { if (this.type == target.type) { System.out.println("These are the same type");}
            else { System.out.println("These are different types"); }}
}


