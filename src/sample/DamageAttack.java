package sample;

public class DamageAttack implements Attack{
    private static int attack_amt;
    private final String name;
    private final PokemonType type;
    private final int damage;
    public int attkdmgOut;
    DamageAttack(String aName, PokemonType aType, int aDamage, int amt)
    {
        attack_amt = amt;
        this.name = aName;
        this.type = aType;
        this.damage = aDamage;
        if (aDamage == 0) { throw new IllegalArgumentException("Damage attack must have damage"); }
    }
    public String getName()
    {
        return name;
    }
    public PokemonType getType()
    {
        return type;
    }
    public String useAttack(Pokemon target)
    {
        final int damage = calculateDamage(target.getType());
        target.doDamage(damage);
        return target.getNickname() + " took " + damage + " damage!";
    }
    private int calculateDamage(final PokemonType defenderType)
    {
        // defender is vulnerable - double damage
        if ((type == PokemonType.FIRE && defenderType == PokemonType.GRASS) ||
                (type == PokemonType.WATER && defenderType == PokemonType.FIRE) ||
                (type == PokemonType.GRASS && defenderType == PokemonType.WATER)||
                (type == PokemonType.ELECTRIC && defenderType == PokemonType.WATER)||
                (type == PokemonType.WATER && defenderType == PokemonType.ROCK)||
                (type == PokemonType.FIRE && defenderType == PokemonType.BUG))

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

    public int getAttkdmgOut() {
        return attkdmgOut;
    }

    // its goes by Type attack instead of individual attacks
    //GOAL to get to pick individual attacks and get those amounts
    public int getAttack_amt() {
        return attack_amt;
    }



}
