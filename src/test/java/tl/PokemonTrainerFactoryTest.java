package tl;

import fr.univavignon.pokedex.api.IPokemonTrainerFactoryTest;

public class PokemonTrainerFactoryTest extends IPokemonTrainerFactoryTest {
    public PokemonTrainerFactoryTest() {
        super.implementationOfIPokemonTrainerFactory(new PokemonTrainerFactory());
    }
}
