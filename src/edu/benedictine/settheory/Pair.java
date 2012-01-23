//A simple class for typed ordered pair
//Created by James Vanderhyde, 3 March 2011

package edu.benedictine.settheory;

public class Pair<A,B> implements java.io.Serializable
{
    /**
     * The first item of this pair
     */
    public A a;

    /**
     * The second item of this pair
     */
    public B b;

    public Pair(A a, B b)
    {
        this.a=a;
        this.b=b;
    }

    /**
     * Constructs and returns a string representation of this pair.
     * @return a string representation of this pair
     */
    @Override
    public String toString()
    {
        return "("+a.toString()+","+b.toString()+")";
    }

    /**
     * Tests item-wise whether the given pair matches this pair.
     * @param candidate The object to test
     * @return true if and only if candidate is a Pair and both items
     *   match the corresponding items in this Pair
     */
    @Override
    public boolean equals(Object candidate)
    {
        if (candidate instanceof Pair)
        {
            Pair p=(Pair)candidate;
            return (p.a.equals(this.a) && p.b.equals(this.b));
        }
        else
            return false;
    }

    /**
     * Used for hash tables; recommended when equals is implemented.
     * @return a hash code for this Pair
     */
    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 79 * hash + (this.a != null ? this.a.hashCode() : 0);
        hash = 79 * hash + (this.b != null ? this.b.hashCode() : 0);
        return hash;
    }
}

