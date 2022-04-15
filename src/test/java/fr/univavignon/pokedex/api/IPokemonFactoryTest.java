package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
    Pokemon aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);

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
    }
}
