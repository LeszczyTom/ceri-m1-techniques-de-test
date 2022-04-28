package fr.univavignon.pokedex.api;

import java.util.Comparator;

/**
 * Enumeration of pokemon comparator.
 *
 * @author fv
 */
public enum PokemonComparators implements Comparator<Pokemon> {

    /** Comparator using Pokemon name. **/
    NAME(Comparator.comparing(Pokemon::getPokemonName)),

    /** Comparator using Pokemon index. **/
    INDEX(Comparator.comparing(Pokemon::getPokemonIndex)),

    /** Comparator using Pokemon combat point. **/
    CP(Comparator.comparing(Pokemon::getPokemonCp));

    /** Delegate comparator instance. **/
    private final Comparator<Pokemon> comparator;

    /**
     * Default constructor.
     *
     * @param delegate Delegate comparator instance.
     */
    PokemonComparators(final Comparator<Pokemon> delegate) {
        this.comparator = delegate;
    }

    /** {@inheritDoc} **/
    @Override
    public int compare(final Pokemon first, final Pokemon second) {

        return comparator.compare(first, second);
    }

}
