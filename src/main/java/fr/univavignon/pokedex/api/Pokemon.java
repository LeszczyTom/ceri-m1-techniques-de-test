package fr.univavignon.pokedex.api;

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

    /**
     * Default constructor.
     *
     * @param index Pokemon index.
     * @param name Pokemon name.
     * @param attack Attack level.
     * @param defense Defense level.
     * @param stamina Stamina level.
     * @param cp Pokemon cp.
     * @param hp Pokemon hp.
     * @param dust Required dust for upgrading this pokemon.
     * @param candy Required candy for upgrading this pokemon.
     * @param iv IV perfection percentage.
     */
    public Pokemon(
            final int index,
            final String name,
            final int attack,
            final int defense,
            final int stamina,
            final int cp,
            final int hp,
            final int dust,
            final int candy,
            final double iv) {
        super(index, name, attack, defense, stamina);
        this.pokemonCp = cp;
        this.pokemonHp = hp;
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
