package tl;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import java.util.Collections;
import java.util.*;

public class Pokedex implements IPokedex {

    private List<Pokemon> pokemons = new ArrayList<>(0);

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        Pokemon pokemon;
        try {
            pokemon = pokemons.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Pokemon not found");
        }
        return pokemon;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> tmp = new ArrayList<>(pokemons);
        tmp.sort(order);
        return Collections.unmodifiableList(tmp);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return null;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return null;
    }
}
