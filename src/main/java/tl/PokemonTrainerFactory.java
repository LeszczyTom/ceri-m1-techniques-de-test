package tl;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

/**
 * Factory for creating Pokemon trainers.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Factory for creating Pokemon Trainers.
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Factory to use for creating
     *                       associated pokedex instance.
     * @return The created trainer.
     */
    @Override
    public PokemonTrainer createTrainer(final String name,
                                        final Team team,
                                        final IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team,
                pokedexFactory.createPokedex(new PokemonMetadataProvider(),
                        new PokemonFactory())
        );
    }
}
