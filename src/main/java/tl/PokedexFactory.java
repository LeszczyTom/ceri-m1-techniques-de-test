package tl;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;

/**
 * Factory for creating Pokedex instances.
 */
public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new Pokedex instance.
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return A new Pokedex instance.
     */
    @Override
    public IPokedex createPokedex(
            final IPokemonMetadataProvider metadataProvider,
            final IPokemonFactory pokemonFactory) {
        return new Pokedex();
    }
}
