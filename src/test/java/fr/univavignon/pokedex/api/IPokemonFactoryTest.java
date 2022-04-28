package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;
    Pokemon bulbizarre = new Pokemon(new ArrayList<>(Arrays.asList(126, 126, 90, 613, 64)), 0, "Bulbizarre", 4000, 4, 56.0);
    Pokemon aquali = new Pokemon(new ArrayList<>(Arrays.asList(186, 168, 260, 2729, 202)), 133, "Aquali", 5000, 4, 100.0);

    public IPokemonFactoryTest() {
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void  createPokemonTest () {
        Mockito.when(pokemonFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(aquali);
        Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);

        // expected aquali
        Assert.assertEquals(aquali, pokemonFactory.createPokemon(133,2729, 202, 5000, 4));
        // expected bulbizarre
        Assert.assertEquals(bulbizarre, pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        // expected 64 hp for bulbizarre
        Assert.assertEquals(bulbizarre.getPokemonHp(), 64);
        // expected 5000 dust for aquali
        Assert.assertEquals(aquali.getPokemonDust(), 5000);
        // expected 4 candy for bulbizarre
        Assert.assertEquals(bulbizarre.getPokemonCandy(), 4);
        //expected 100.0 iv for aquali
        Assert.assertEquals(aquali.getPokemonIv(), 100.0, 0.0);
    }
}
