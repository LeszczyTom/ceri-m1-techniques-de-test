package fr.univavignon.pokedex.api;

import java.util.List;

/**
 * Pokemon POJO.
 *
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

    /** Combat Point of the pokemon. **/
    private final int pokemonCp;

    /** HP of the pokemon. **/
    private final int pokemonHp;

    /** Required dust for upgrading this pokemon. **/
    private final int pokemonDust;

    /** Required candy for upgrading this pokemon. **/
    private final int pokemonCandy;

    /** IV perfection percentage. **/
    private final double pokemonIv;

    /** Index of cp stat. **/
    private final int cpIndex = 3;

    /** Index of hp stat. **/
    private final int hpIndex = 4;

    /**
     * Default constructor.
     *
     * @param stats List of stats. (attack, defense, stamina, cp, hp)
     * @param index Pokemon index.
     * @param name Pokemon name.
     * @param dust Pokemon dust.
     * @param candy Required candy for upgrading this pokemon.
     * @param iv IV perfection percentage.
     */
    public Pokemon(
            final List<Integer> stats,
            final int index,
            final String name,
            final int dust,
            final int candy,
            final double iv) {
        super(index, name, stats.get(0), stats.get(1), stats.get(2));
        this.pokemonCp = stats.get(cpIndex);
        this.pokemonHp = stats.get(hpIndex);
        this.pokemonDust = dust;
        this.pokemonCandy = candy;
        this.pokemonIv = iv;
    }

    /** Combat Point getter getter.
     *
     * @return Combat Point.
     */
    public int getPokemonCp() {
        return pokemonCp;
    }

    /** HP getter.
     *
     * @return HP.
     */
    public int getPokemonHp() {
        return pokemonHp;
    }

    /** Dust getter.
     *
     * @return Dust.
     */
    public int getPokemonDust() {
        return pokemonDust;
    }

    /** Candy getter.
     *
     * @return Candy.
     */
    public int getPokemonCandy() {
        return pokemonCandy;
    }

    /** IV getter.
     *
     * @return IV.
     */
    public double getPokemonIv() {
        return pokemonIv;
    }

}
