package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedex pokedex;
    IPokedexFactory pokedexFactory;

    public IPokemonTrainerFactoryTest() {
        pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
    }

    @Test
    public void createTrainerTest() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Trainer", Team.VALOR, pokedex);

        Mockito.doReturn(pokemonTrainer).when(pokemonTrainerFactory).createTrainer("Trainer", Team.VALOR, pokedexFactory);

        // expected PokemenTrainer
        Assert.assertEquals(pokemonTrainer.getClass(), pokemonTrainerFactory.createTrainer("Trainer", Team.VALOR, pokedexFactory).getClass());
        // expected name
        Assert.assertEquals("Trainer", pokemonTrainerFactory.createTrainer("Trainer", Team.VALOR, pokedexFactory).getTrainerName());
        // expected team
        Assert.assertEquals(Team.VALOR, pokemonTrainerFactory.createTrainer("Trainer", Team.VALOR, pokedexFactory).getTrainerTeam());
        // expected pokedex
        Assert.assertEquals(pokedex.getClass(), pokemonTrainerFactory.createTrainer("Trainer", Team.VALOR, pokedexFactory).getTrainerPokedex().getClass());
        // expected same size pokedex
        Assert.assertEquals(pokedex.getPokemons().size(), pokemonTrainerFactory.createTrainer("Trainer", Team.VALOR, pokedexFactory).getTrainerPokedex().getPokemons().size());
    }
}
