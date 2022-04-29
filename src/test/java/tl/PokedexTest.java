package tl;

import fr.univavignon.pokedex.api.IPokedexTest;
import fr.univavignon.pokedex.api.PokedexException;
import org.junit.Assert;
import org.junit.Test;

public class PokedexTest extends IPokedexTest {

    PokemonMetadataProvider provider = new PokemonMetadataProvider();
    PokemonFactory pokemonFactory = new PokemonFactory();
    public PokedexTest() {
        super.implementationOfPokedex(new Pokedex());
    }

    @Test
    public void createPokemonTest() {
        // expected 64 hp for bulbizarre
        Assert.assertEquals(64, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getPokemonHp());
        // expected 5000 dust for aquali
        Assert.assertEquals(5000, pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getPokemonDust());
        // expected 4 candy for bulbizarre
        Assert.assertEquals(4, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getPokemonCandy());
        // expected 613 cp for bulbizarre
        Assert.assertEquals(613, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getPokemonCp());
        // expected index 133 for aquali
        Assert.assertEquals(133, pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getPokemonIndex());
        // expected 56.0 iv for bulbizarre
        Assert.assertEquals(56.0, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getPokemonIv(), 0.0);
        // expected null
        Assert.assertNull(pokemonFactory.createPokemon(600, 613, 64, 4000, 4));
    }

    @Test
    public void getPokemonMetaDataTest() {
        // expected exception
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(-160));
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(160));
        try {
            // expected 126 attack for Bulbizarre
            Assert.assertEquals(126, provider.getPokemonMetadata(0).getPokemonAttack());
            // expected 186 defense for Aquali
            Assert.assertEquals(168, provider.getPokemonMetadata(133).getPokemonDefense());
            // expected 260 stamina for Aquali
            Assert.assertEquals(260, provider.getPokemonMetadata(133).getPokemonStamina());
        } catch (PokedexException e) {
            Assert.fail(e.getMessage());
        }
    }
}
