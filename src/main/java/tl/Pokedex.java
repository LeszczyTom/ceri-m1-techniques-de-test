package tl;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * This class implements the Pokedex interface.
 */
public class Pokedex implements IPokedex {

    /**
     * The list of all the Pokemon in the Pokedex.
     */
    private List<Pokemon> pokemons = new ArrayList<>(0);

    /**
     * Get the number of Pokemon in the Pokedex.
     * @return the number of Pokemon in the Pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Add a Pokemon to the Pokedex.
     * @param pokemon Pokemon to add to this pokedex.
     * @return the index of the added Pokemon relative to the Pokedex.
     */
    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size();
    }

    /**
     * Get the Pokemon at the given index.
     * @param id Unique pokedex relative identifier.
     * @return the Pokemon with the given id.
     * @throws PokedexException if the Pokemon is not found.
     */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        Pokemon pokemon;
        try {
            pokemon = pokemons.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Pokemon not found");
        }
        return pokemon;
    }

    /**
     * Get an unmodifiable list of all the Pokemon in the Pokedex.
     * @return an unmodifiable list of all the Pokemon in the Pokedex.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /**
     * Get an unmodifiable list of all the Pokemon in the
     * Pokedex sorted by either NAME, INDEX or COMPAT POINT.
     * @param order Comparator instance used for sorting the created view.
     * @return an unmodifiable list of all the Pokemon in the Pokedex
     * sorted by either NAME, INDEX or COMPAT POINT.
     */
    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> tmp = new ArrayList<>(pokemons);
        tmp.sort(order);
        return Collections.unmodifiableList(tmp);
    }

    /**
     * Create a new Pokémon.
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return the created Pokemon.
     */
    @Override
    public Pokemon createPokemon(final int index,
                                 final int cp,
                                 final int hp,
                                 final int dust,
                                 final int candy) {
        return new PokemonFactory().createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * Get the PokemonMetadata of the Pokemon at the given index.
     * @param index Index of the pokemon to retrieve metadata for.
     * @return the PokemonMetadata of the Pokemon at the given index.
     * @throws PokedexException if the Pokemon is not found.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        return new PokemonMetadataProvider().getPokemonMetadata(index);
    }
}
