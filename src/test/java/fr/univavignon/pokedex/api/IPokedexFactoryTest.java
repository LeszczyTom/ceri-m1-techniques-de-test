package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;

    public IPokedexFactoryTest() {
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        Mockito.when(pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class))).thenReturn(Mockito.mock(IPokedex.class));
        assertEquals(Mockito.mock(IPokedex.class), pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class)));
    }
}
