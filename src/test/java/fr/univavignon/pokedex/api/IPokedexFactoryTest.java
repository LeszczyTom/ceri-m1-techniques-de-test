package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import tl.Pokedex;
import tl.PokedexFactory;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;

    IPokemonMetadataProvider pokemonMetadataProvider;

    IPokemonFactory pokemonFactory;

    public IPokedexFactoryTest() {
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
    }

    public void implementationOfIPokedexFactory(PokedexFactory pokedexFactory, IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokedexFactory = pokedexFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Test
    public void testCreatePokedex() {
        Class<?> typeOfCreatePokedexResult;
        if(pokedexFactory.getClass() == Mockito.mock(IPokedexFactory.class).getClass()) {
            pokemonFactory = Mockito.mock(IPokemonFactory.class);
            pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

            Mockito.doReturn(Mockito.mock(IPokedex.class)).when(pokedexFactory).createPokedex(Mockito.any(pokemonMetadataProvider.getClass()), Mockito.any(pokemonFactory.getClass()));
            Mockito.doReturn(Mockito.mock(Pokedex.class)).when(pokedexFactory).createPokedex(pokemonMetadataProvider, pokemonFactory);
            typeOfCreatePokedexResult = Mockito.mockingDetails(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).getMockCreationSettings().getTypeToMock();
        } else {
            typeOfCreatePokedexResult = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory).getClass();
        }

        // expected to return a Pokedex
        Assert.assertNotNull(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
        Assert.assertEquals(Pokedex.class, typeOfCreatePokedexResult);
    }
}
