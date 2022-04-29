package tl;

import fr.univavignon.pokedex.api.IPokemonFactoryTest;

public class RocketPokemonFactoryTest extends IPokemonFactoryTest {

    public RocketPokemonFactoryTest() {
        super.implementationOfIPokemonFactory(new RocketPokemonFactory());
    }
}
