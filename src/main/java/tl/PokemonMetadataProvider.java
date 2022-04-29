package tl;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    List<PokemonMetadata> pokemonMetadataList;

    public PokemonMetadataProvider() {
        this.pokemonMetadataList = new ArrayList<>(0);
        for(int i = 0; i < 151; i++) {
            this.pokemonMetadataList.add(new PokemonMetadata(i, "null", 0, 0, 0));
        }
        pokemonMetadataList.add(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonMetadataList.add(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index > 151) throw new PokedexException("Pokemon not found");
        return pokemonMetadataList.get(index);
    }
}
