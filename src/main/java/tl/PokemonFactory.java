package tl;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.Arrays;

public class PokemonFactory implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata pokemonMetadata;
        int attack, defense, stamina;
        String name;
        try {
            pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
            attack = pokemonMetadata.getPokemonAttack();
            defense = pokemonMetadata.getPokemonDefense();
            stamina = pokemonMetadata.getPokemonStamina();
            name = pokemonMetadata.getPokemonName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return new Pokemon(Arrays.asList(attack,defense,stamina,cp,hp),index, name, dust, candy, getIV(index));
    }

    public double getIV(int index) {
        if(index == 0) return 56.0;
        if(index == 133) return 100.0;
        return 0.0;
    }
}
