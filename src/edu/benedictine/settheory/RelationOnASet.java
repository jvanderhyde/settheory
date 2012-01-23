//A class for a binary relation on a set
//Created by James Vanderhyde, 3 March 2011

package edu.benedictine.settheory;

public class RelationOnASet<A> extends Set<Pair<A,A>>
{
    //This is the set on which the relation is defined.
    private Set<A> setA;

    public RelationOnASet(Set<A> setA)
    {
        this.setA=setA;
    }

    public boolean isReflexive()
    {
        //Student implementation
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public boolean isSymmetric()
    {
        //Student implementation
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public boolean isTransitive()
    {
        //Student implementation
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public boolean isEquivalenceRelation()
    {
        //Student implementation
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Prints all the equivalence classes of this relation,
     *  if it is an equivalence relation.
     *  Each class is printed exactly once.
     *  One class is printed per line.
     *  Since every element of the set is in exactly one class,
     *  every element of the set should appear on exactly one line.
     * Precondition: isEquivalenceRelation returns true
     */
    public void printEquivalenceClasses()
    {
        //Student implementation
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}

