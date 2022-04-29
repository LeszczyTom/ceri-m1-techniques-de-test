package tl;

import fr.univavignon.pokedex.api.IPokedexTest;
import fr.univavignon.pokedex.api.PokedexException;
import org.junit.Assert;
import org.junit.Test;

public class PokedexTest extends IPokedexTest {
    Pokedex pokedex = new Pokedex();
    public PokedexTest() {
        super.implementationOfPokedex(new Pokedex());
    }

    @Test
    public void createPokemonTest() {
        // expected 64 hp for bulbizarre
        Assert.assertEquals(64, pokedex.createPokemon(0, 613, 64, 4000, 4).getPokemonHp());
        // expected 5000 dust for aquali
        Assert.assertEquals(5000, pokedex.createPokemon(133, 2729, 202, 5000, 4).getPokemonDust());
        // expected 4 candy for bulbizarre
        Assert.assertEquals(4, pokedex.createPokemon(0, 613, 64, 4000, 4).getPokemonCandy());
        // expected 613 cp for bulbizarre
        Assert.assertEquals(613, pokedex.createPokemon(0, 613, 64, 4000, 4).getPokemonCp());
        // expected index 133 for aquali
        Assert.assertEquals(133, pokedex.createPokemon(133, 2729, 202, 5000, 4).getPokemonIndex());
        // expected 56.0 iv for bulbizarre
        Assert.assertEquals(56.0, pokedex.createPokemon(0, 613, 64, 4000, 4).getPokemonIv(), 0.0);
        // expected null
        Assert.assertNull(pokedex.createPokemon(600, 613, 64, 4000, 4));
    }

    @Test
    public void getPokemonMetaDataTest() {
        // expected exception
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemonMetadata(-160));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemonMetadata(160));
        try {
            // expected 126 attack for Bulbizarre
            Assert.assertEquals(126, pokedex.getPokemonMetadata(0).getPokemonAttack());
            // expected 186 defense for Aquali
            Assert.assertEquals(168, pokedex.getPokemonMetadata(133).getPokemonDefense());
            // expected 260 stamina for Aquali
            Assert.assertEquals(260, pokedex.getPokemonMetadata(133).getPokemonStamina());
        } catch (PokedexException e) {
            Assert.fail(e.getMessage());
        }
    }
}
