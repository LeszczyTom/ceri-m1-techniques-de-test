package tl;

import fr.univavignon.pokedex.api.IPokemonFactoryTest;

public class PokemonFactoryTest extends IPokemonFactoryTest {

    public PokemonFactoryTest() {
        super.implementationOfIPokemonFactory(new PokemonFactory());
    }
}
