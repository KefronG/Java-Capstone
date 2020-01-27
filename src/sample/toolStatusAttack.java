package sample;

public class toolStatusAttack implements Attack {
    private static int attack_amt;
    private final String name;
    private final PokemonType type;
    private final Status status;
    toolStatusAttack(String aName, PokemonType aType, Status aStatus, int amt) {
        attack_amt = amt;
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
        return null;
    }

    public int getAttack_amt() {
        return attack_amt;
    }
}
