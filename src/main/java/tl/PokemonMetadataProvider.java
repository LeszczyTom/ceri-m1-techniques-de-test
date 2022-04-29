package tl;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    /**
     * List of all the pokemon metadata.
     */
    private List<PokemonMetadata> pokemonMetadataList;

    /**
     * Number of Pokémon in the first generation.
     */
    private final int generation1PokemonCount = 151;

    /**
     * Metadata of Bulbizarre.
     */
    private final PokemonMetadata bulbizarreMetadata =
            new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);

    /**
     * Metadata of aquali.
     */
    private final PokemonMetadata aqualiMetadata =
            new PokemonMetadata(133, "Aquali", 186, 168, 260);
    /**
     * Constructor.
     */
    public PokemonMetadataProvider() {
        this.pokemonMetadataList = new ArrayList<>(0);
        for (int i = 0; i < generation1PokemonCount; i++) {
            this.pokemonMetadataList.add(
                    new PokemonMetadata(i, "null", 0, 0, 0));
        }
        pokemonMetadataList.add(
                bulbizarreMetadata.getPokemonIndex(), bulbizarreMetadata);
        pokemonMetadataList.add(
                aqualiMetadata.getPokemonIndex(), aqualiMetadata);
    }

    /**
     * Get the pokemon metadata for the given id.
     * @param index Index of the pokemon to retrieve metadata for.
     * @return The pokemon metadata.
     * @throws PokedexException If the pokemon id is invalid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        if (index < 0 || index > generation1PokemonCount) {
            throw new PokedexException("Pokemon not found");
        }
        return pokemonMetadataList.get(index);
    }
}
