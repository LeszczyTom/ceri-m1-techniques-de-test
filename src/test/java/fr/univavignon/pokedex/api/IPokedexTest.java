package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import tl.Pokedex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IPokedexTest {

    IPokedex pokedex;
    List<Pokemon> pokemons;

    Pokemon bulbizarre = new Pokemon(new ArrayList<>(Arrays.asList(126, 126, 90, 613, 64)), 0, "Bulbizarre", 4000, 4, 56.0);
    Pokemon aquali = new Pokemon(new ArrayList<>(Arrays.asList(186, 168, 260, 2729, 202)), 133, "Aquali", 5000, 4, 100.0);

    public IPokedexTest() {
        pokedex = Mockito.mock(IPokedex.class);
        pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
    }

    public void implementationOfPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
        for(Pokemon pokemon : pokemons) {
            pokedex.addPokemon(pokemon);
        }
    }

    @Test
    public void addPokemonTest () {
        if(pokedex.getClass() == Mockito.mock(IPokedex.class).getClass())
            Mockito.doReturn(pokemons.size() + 1).when(pokedex).addPokemon(Mockito.any(Pokemon.class));

        // expected size + 1
        Assert.assertEquals(3, pokedex.addPokemon(new Pokemon(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)), 0, "", 0, 0, 0.0)));
    }

    @Test
    public void getPokemonTest () throws PokedexException {
        if(pokedex.getClass() == Mockito.mock(IPokedex.class).getClass()) {
            Mockito.doReturn(bulbizarre).when(pokedex).getPokemon(0);
            Mockito.doReturn(aquali).when(pokedex).getPokemon(1);
            Mockito.doThrow(new PokedexException("Index is not valid.")).when(pokedex).getPokemon(Mockito.intThat(i -> i < 0 || i > 1));
        }

        // expected bulbizarre
        Assert.assertEquals(bulbizarre, pokedex.getPokemon(0));
        // expected aquali
        Assert.assertEquals(aquali, pokedex.getPokemon(1));
        // expected exception
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(999));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-999));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(2));
    }

    @Test
    public void getPokemonsTest () {
        List<Pokemon> unmodifiablePokemonList = Collections.unmodifiableList(pokemons);

        if(pokedex.getClass() == Mockito.mock(IPokedex.class).getClass()) {
            Mockito.doReturn(unmodifiablePokemonList).when(pokedex).getPokemons();
        }

        // expected unmodifiableList
        Assert.assertEquals(unmodifiablePokemonList.getClass(), pokedex.getPokemons().getClass());
        // expected same size list
        Assert.assertEquals(pokemons.size(), pokedex.getPokemons().size());
        // expected same pokemons (bulbizarre)
        Assert.assertEquals(pokemons.get(0), pokedex.getPokemons().get(0));
    }

    @Test
    public void getPokemonsSortedTest () {
        PokemonComparators name = PokemonComparators.NAME;
        PokemonComparators index = PokemonComparators.INDEX;
        PokemonComparators cp = PokemonComparators.CP;

        List<Pokemon> sortedPokemonListByName = new ArrayList<>(pokemons);
        sortedPokemonListByName.sort(name);
        List<Pokemon> sortedPokemonListByIndex = new ArrayList<>(pokemons);
        sortedPokemonListByIndex.sort(index);
        List<Pokemon> sortedPokemonListByCp = new ArrayList<>(pokemons);
        sortedPokemonListByCp.sort(cp);

        if(pokedex.getClass() == Mockito.mock(IPokedex.class).getClass()) {
            Mockito.doReturn(Collections.unmodifiableList(sortedPokemonListByName)).when(pokedex).getPokemons(name);
            Mockito.doReturn(Collections.unmodifiableList(sortedPokemonListByIndex)).when(pokedex).getPokemons(index);
            Mockito.doReturn(Collections.unmodifiableList(sortedPokemonListByCp)).when(pokedex).getPokemons(cp);
        }

        // expected unmodifiableList
        Assert.assertEquals(Collections.unmodifiableList(new ArrayList<>()).getClass(), pokedex.getPokemons(name).getClass());
        // expected list sorted by name
        Assert.assertEquals("Aquali", pokedex.getPokemons(name).get(0).getPokemonName());
        // expected list sorted by index
        Assert.assertEquals(0, pokedex.getPokemons(index).get(0).getPokemonIndex());
        // expected list sorted by cp
        Assert.assertEquals(613, pokedex.getPokemons(cp).get(0).getPokemonCp());
        // expected same size list
        Assert.assertEquals(pokemons.size(), pokedex.getPokemons(name).size());
    }

    @Test
    public void sizeTest(){
        if(pokedex.getClass() == Mockito.mock(IPokedex.class).getClass()) {
            Mockito.doReturn(pokemons.size()).when(pokedex).size();
        }

        // expected size
        Assert.assertEquals(2, pokedex.size());
    }
}
