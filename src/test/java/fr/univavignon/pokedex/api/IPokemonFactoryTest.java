package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import tl.PokemonFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;
    Pokemon bulbizarre = new Pokemon(new ArrayList<>(Arrays.asList(126, 126, 90, 613, 64)), 0, "Bulbizarre", 4000, 4, 56.0);
    Pokemon aquali = new Pokemon(new ArrayList<>(Arrays.asList(186, 168, 260, 2729, 202)), 133, "Aquali", 5000, 4, 100.0);
    Pokemon rand = new Pokemon(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)), 20, "rand", 0, 0, 0.0);

    public IPokemonFactoryTest() {
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
    }

    public void implementationOfIPokemonFactory(IPokemonFactory pokemonFactory) {
        this.pokemonFactory = pokemonFactory;
    }

    @Test
    public void  createPokemonTest () {
        if(pokemonFactory.getClass() == Mockito.mock(IPokemonFactory.class).getClass()) {
            Mockito.when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
            Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
            Mockito.when(pokemonFactory.createPokemon(20, 0, 0, 0, 0)).thenReturn(rand);
        }

        // expected 64 hp for bulbizarre
        Assert.assertEquals(64, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getPokemonHp());
        // expected 5000 dust for aquali
        Assert.assertEquals(5000, pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getPokemonDust());
        // expected 4 candy for bulbizarre
        Assert.assertEquals(4, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getPokemonCandy());
        // expected 613 cp for bulbizarre
        Assert.assertEquals(613, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getPokemonCp());
        // expected index 133 for aquali
        Assert.assertEquals(133, pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getPokemonIndex());
        // expected 56.0 iv for bulbizarre
        Assert.assertEquals(56.0, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getPokemonIv(), 0.0);
        // expected 100.0 iv for aquali
        Assert.assertEquals(100.0, pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getPokemonIv(), 0.0);
        // expected 0.0 iv for null
        Assert.assertEquals(0.0, pokemonFactory.createPokemon(20, 0, 0, 0, 0).getPokemonIv(), 0.0);
        // expected null
        Assert.assertNull(pokemonFactory.createPokemon(600, 613, 64, 4000, 4));
    }
}
