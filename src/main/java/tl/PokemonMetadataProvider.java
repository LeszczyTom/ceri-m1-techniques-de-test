package tl;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index == 0) return new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        if(index == 133) return new PokemonMetadata(133, "Aquali", 186, 168, 260);
        return null;
    }
}
