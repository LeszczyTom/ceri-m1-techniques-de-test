package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 *
 * @author fv
 */
public class PokemonTrainer {

    /** Trainer name. **/
    private final String trainerName;

    /** Trainer team. **/
    private final Team trainerTeam;

    /** Trainer pokedex. **/
    private final IPokedex trainerPokedex;

    /**
     * Default constructor.
     *
     * @param name Trainer name.
     * @param team Trainer team.
     * @param pokedex Trainer pokedex.
     */
    public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
        trainerName = name;
        trainerTeam = team;
        trainerPokedex = pokedex;
    }

    /** Name getter.
     * @return the trainer name
     */
    public String getTrainerName() {
        return trainerName;
    }

    /** Team getter.
     * @return the trainer team
     */
    public Team getTrainerTeam() {
        return trainerTeam;
    }

    /** Pokedex getter.
     * @return the trainer pokedex
     */
    public IPokedex getTrainerPokedex() {
        return trainerPokedex;
    }

}
