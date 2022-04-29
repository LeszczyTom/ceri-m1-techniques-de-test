package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import tl.PokemonMetadataProvider;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider provider;
    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;

    public IPokemonMetadataProviderTest() {
        provider = Mockito.mock(IPokemonMetadataProvider.class);
        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
    }

    public void implementationOfIPokemonMetadataProvider(PokemonMetadataProvider provider) {
        this.provider = provider;
    }

    @Test
    public void getPokemonMetadata() throws PokedexException {
        if(provider.getClass() == Mockito.mock(IPokemonMetadataProvider.class).getClass()) {
            Mockito.doReturn(bulbizarre).when(provider).getPokemonMetadata(0);
            Mockito.doReturn(aquali).when(provider).getPokemonMetadata(133);
            Mockito.doThrow(new PokedexException("given index is not valid")).when(provider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));
        }

        // expected exception
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(-160));
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(160));
        // expected 126 attack for Bulbizarre
        Assert.assertEquals(126, provider.getPokemonMetadata(0).getPokemonAttack());
        // expected 168 defense for Aquali
        Assert.assertEquals(168, provider.getPokemonMetadata(133).getPokemonDefense());
        // expected 260 stamina for Aquali
        Assert.assertEquals(260, provider.getPokemonMetadata(133).getPokemonStamina());
    }
}
