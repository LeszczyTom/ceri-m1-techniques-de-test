package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;

    public IPokedexFactoryTest() {
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        Mockito.doReturn(Mockito.mock(IPokedex.class)).when(pokedexFactory).createPokedex(Mockito.any(pokemonMetadataProvider.getClass()), Mockito.any(pokemonFactory.getClass()));

        // expected to return a Pokedex
        Assert.assertNotNull(pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class)));
        Assert.assertEquals(Mockito.mock(IPokedex.class).getClass(), pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class)).getClass());
    }
}
