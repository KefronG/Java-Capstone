package sample;

import javafx.scene.image.Image;

import java.io.IOException;
import java.util.List;

public class Gen_2_Pokemon extends Pokemon{
    public final String holditem;

    public Gen_2_Pokemon(final String species, final PokemonType type, final int maxHP, final List<Attack> attacks, String item, Image file2, Image file1) throws IOException {
        super(species,type, maxHP, attacks, file1 ,file2);
        this.holditem = item;

    }
    public String getHolditem(){ return holditem;}

    public String setHolditem(String HI){
        HI = holditem;
        return HI;}
}
