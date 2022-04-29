package tl;

import fr.univavignon.pokedex.api.IPokedexFactoryTest;

public class PokedexFactoryTest extends IPokedexFactoryTest {

    public PokedexFactoryTest() {
        super.implementationOfIPokedexFactory(new PokedexFactory(), new PokemonMetadataProvider(), new PokemonFactory());
    }

}
