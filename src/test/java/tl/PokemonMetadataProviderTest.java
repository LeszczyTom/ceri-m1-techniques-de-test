package tl;

import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;

public class PokemonMetadataProviderTest extends IPokemonMetadataProviderTest {

    public PokemonMetadataProviderTest() {
        super.implementationOfIPokemonMetadataProvider(new PokemonMetadataProvider());
    }

}
