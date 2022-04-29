package tl;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata pokemonMetadata;
        int attack, defense, stamina, iv;
        String name;
        try {
            pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
            attack = pokemonMetadata.getPokemonAttack();
            defense = pokemonMetadata.getPokemonDefense();
            stamina = pokemonMetadata.getPokemonStamina();
            Random random = new Random();
            iv = random.nextInt(100);
            name = pokemonMetadata.getPokemonName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return new Pokemon(Arrays.asList(attack,defense,stamina,cp,hp),index, name, dust, candy, iv);
    }
}
