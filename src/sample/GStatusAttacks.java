package sample;

public class GStatusAttacks implements Attack{
    private static int attack_amt;
    private final String name;
    private final PokemonType type;
    private final Status status;
    private final int damage;
    GStatusAttacks(String aName, PokemonType aType, Status aStatus , int dmg, int amt) {
        attack_amt = amt;
        damage = dmg;
        name = aName;
        type = aType;
        status = aStatus;
    }
    public String getName() { return name; }

    public PokemonType getType()
    {
        return type;
    }
    public String useAttack(Pokemon target)
    {
        target.setCurrentStatus(status);

        return target.getNickname() + " is now " + status.toString().toLowerCase() + "!";
    }



    public int getAttack_amt() {
        return attack_amt;
    }


}
