package tl;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.Arrays;

/**
 * Factory for creating Pokemon.
 */
public class PokemonFactory implements IPokemonFactory {

    /**
     * IV of Bulbizarre.
     */
    public static final double BULBIZARRE_IV = 56.0;

    /**
     * IV of Aquali.
     */
    public static final double AQUALI_IV = 100.0;

    /**
     * IV of other pokemons.
     */
    public static final double OTHERPOKEMON_IV = 1.0;

    /**
     * Index of Aquali.
     */
    public static final int AQUALI_INDEX = 133;

    /**
     * Creates a new Pokemon.
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Pokemon.
     */
    @Override
    public Pokemon createPokemon(final int index,
                                 final int cp,
                                 final int hp,
                                 final int dust,
                                 final int candy) {
        PokemonMetadata pokemonMetadata;
        int attack;
        int defense;
        int stamina;
        String name;
        try {
            pokemonMetadata =
                    new PokemonMetadataProvider().getPokemonMetadata(index);
            attack = pokemonMetadata.getPokemonAttack();
            defense = pokemonMetadata.getPokemonDefense();
            stamina = pokemonMetadata.getPokemonStamina();
            name = pokemonMetadata.getPokemonName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return new Pokemon(Arrays.asList(attack, defense, stamina, cp, hp),
                index, name, dust, candy, getIV(index));
    }

    /**
     * Gets the IV of a pokemon.
     * @param index Pokemon index.
     * @return IV.
     */
    public double getIV(final int index) {
        if (index == 0) {
            return BULBIZARRE_IV;
        }
        if (index == AQUALI_INDEX) {
            return AQUALI_IV;
        }
        return OTHERPOKEMON_IV;
    }
}
