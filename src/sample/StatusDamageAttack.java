package sample;

import java.util.Random;

public class StatusDamageAttack implements Attack{
    private static int attack_amt;
    private final int damage;
    private final String name;
    private final PokemonType type;
    private final Status status;
    private final float probability;
    //combining StatusAttack and DamgeAttack
    StatusDamageAttack(String aName, PokemonType aType, Status aStatus, float aProbability, int dmg, int amt) {
        attack_amt = amt;
        damage = dmg;
        name = aName;
        type = aType;
        status = aStatus;
        if (aProbability < 0 || aProbability > 1)
        {
            throw new IllegalArgumentException("Probability must be between 0 (0%) and 1 (100%).");
        }
        else if (dmg == 0)
        {
            throw new IllegalArgumentException("Damage attack must have damage");
        }
        probability = aProbability;
    }
    public String getName() { return name; }
    public PokemonType getType()
    {
        return type;
    }
    public String useAttack(Pokemon target)
    {
        final boolean succeeds = calculateSuccess();
        final int damage = calculateDamage(target.getType());
        target.doDamage(damage);
        System.out.println(target.getNickname() + " took " + damage + " damage!");
        if (succeeds)
        {

            target.setCurrentStatus(status);
            return target.getNickname() + " took " + damage + " damage " + target.getNickname() + " is now " + status.toString().toLowerCase() + "!";
        }
        else
        {
            return target.getNickname()+" did not get "+ status.toString().toLowerCase();
        }
    }

    public int getAttack_amt() {
        return attack_amt;
    }



    // to break effect method goes into battle loop
    private boolean calculateSuccess()
    {
        float random = new Random().nextFloat();
        return (random < probability);
    }
    private int calculateDamage(final PokemonType defenderType)
    {
        // defender is vulnerable - double damage
        if ((type == PokemonType.FIRE && defenderType == PokemonType.GRASS) ||
                (type == PokemonType.WATER && defenderType == PokemonType.FIRE) ||
                (type == PokemonType.GRASS && defenderType == PokemonType.WATER)||
                (type == PokemonType.ELECTRIC && defenderType == PokemonType.WATER)||
                (type == PokemonType.WATER && defenderType == PokemonType.ROCK))

        {
            return damage * 2;
        }

        // defender is resistant - half damage
        if ((type == PokemonType.GRASS && defenderType == PokemonType.FIRE) ||
                (type == PokemonType.FIRE && defenderType == PokemonType.WATER) ||
                (type == PokemonType.WATER && defenderType == PokemonType.GRASS)||
                (type == PokemonType.ELECTRIC && defenderType == PokemonType.ROCK) ||
                (type == PokemonType.FIRE && defenderType == PokemonType.ROCK))
        {
            return damage / 2;
        }

        // no weaknesses - normal damage
        return damage;
    }


}
