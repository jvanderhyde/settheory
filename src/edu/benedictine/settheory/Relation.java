//A class for a binary relation from a set A to a set B
//Created by James Vanderhyde, 3 March 2011

package edu.benedictine.settheory;

public class Relation<A,B> extends Set<Pair<A,B>>
{
    //These are the sets on which the relation is defined.
    //Note that it is possible for a to be the same as b.
    private Set<A> setA;
    private Set<B> setB;

    public Relation(Set<A> setA, Set<B> setB)
    {
        this.setA=setA;
        this.setB=setB;
    }
}
