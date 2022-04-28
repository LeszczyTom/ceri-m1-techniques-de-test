package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 *
 * @author fv
 */
public class PokemonMetadata {

    /** Pokemon index. **/
    private final int pokemonIndex;

    /** Pokemon name. **/
    private final String pokemonName;

    /** Pokemon attack level. **/
    private final int pokemonAttack;

    /** Pokemon defense level. **/
    private final int pokemonDefense;

    /** Pokemon stamina level. **/
    private final int pokemonStamina;

    /**
     * Default constructor.
     *
     * @param index Pokemon index.
     * @param name Pokemon name.
     * @param attack Attack level.
     * @param defense Defense level.
     * @param stamina Stamina level.
     */
    public PokemonMetadata(final int index, final String name, final int attack, final int defense, final int stamina) {
        this.pokemonIndex = index;
        this.pokemonName = name;
        this.pokemonAttack = attack;
        this.pokemonDefense = defense;
        this.pokemonStamina = stamina;
    }

    /** Index getter.
     * @return Pokemon index of the pokemon.
     */
    public int getPokemonIndex() {
        return pokemonIndex;
    }

    /** Name getter.
     * @return Pokemon name of the pokemon.
     */
    public String getPokemonName() {
        return pokemonName;
    }

    /** Attack level getter.
     * @return Attack level of the pokemon.
     */
    public int getPokemonAttack() {
        return pokemonAttack;
    }

    /** Defense level getter.
     * @return Defense level of the pokemon.
     */
    public int getPokemonDefense() {
        return pokemonDefense;
    }

    /** Stamina level getter.
     * @return Stamina level of the pokemon.
     */
    public int getPokemonStamina() {
        return pokemonStamina;
    }

}
