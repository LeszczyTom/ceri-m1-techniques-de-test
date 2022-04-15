package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider provider;
    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;

    public IPokemonMetadataProviderTest() {
        provider = Mockito.mock(IPokemonMetadataProvider.class);
        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
    }

    @Test
    public void getPokemonMetadata() throws PokedexException {
        Mockito.doReturn(bulbizarre).when(provider).getPokemonMetadata(0);
        Mockito.doReturn(aquali).when(provider).getPokemonMetadata(133);
        Mockito.doThrow(new PokedexException("given index is not valid")).when(provider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));

        // expected Bulbizarre's metadata
        Assert.assertEquals(bulbizarre, provider.getPokemonMetadata(0));
        // expected Aquali's metadata
        Assert.assertEquals(aquali, provider.getPokemonMetadata(133));
        // expected exception
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(-160));
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(160));
    }
}
