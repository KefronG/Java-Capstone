package sample;

public interface Attack {
    public String getName();
    public PokemonType getType();
    public String useAttack(Pokemon target);
    public int getAttack_amt();
}
