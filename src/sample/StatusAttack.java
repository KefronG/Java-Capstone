package sample;

import java.util.Random;

public class StatusAttack implements Attack{
    private static int attack_amt;
    private final String name;
    private final PokemonType type;
    private final Status status;
    private final float probability;
    StatusAttack(String aName, PokemonType aType, Status aStatus, float aProbability, int amt) {
        attack_amt = amt;
        name = aName;
        type = aType;
        status = aStatus;
        if (aProbability < 0 || aProbability > 1)
        {
            throw new IllegalArgumentException("Probability must be between 0 (0%) and 1 (100%).");
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
        if (succeeds)
        {
            target.setCurrentStatus(status);
            return target.getNickname() + " is now " + status.toString().toLowerCase() + "!";
        }
        else
        {
            return "The attack failed!";
        }
    }



    public int getAttack_amt() {
        return attack_amt;
    }



    private boolean calculateSuccess()
    {
        float random = new Random().nextFloat();
        return (random < probability);
    }

}
