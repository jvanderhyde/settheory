//A class for a finite typed set
//Created by James Vanderhyde, 3 March 2011

package edu.benedictine.settheory;

import java.io.Serializable;
import java.util.Iterator;

public class Set<E> implements Serializable, Iterable<E>
{
    //The set elements, stored in an ArrayList
    private java.util.ArrayList<E> data=new java.util.ArrayList();

    /**
     * Adds an element to this set.
     * @param element the element to add
     */
    public void addElement(E element)
    {
        data.add(element);
    }

    /**
     * Removes an element from this set.
     * @param element the element to remove
     */
    public void removeElement(E element)
    {
        data.remove(element);
    }

    /**
     * Returns the number of elements in this set.
     * @return the number of elements in this set
     */
    public int numElements()
    {
        return data.size();
    }

    /**
     * Tests whether this set contains the given element.
     * @param elt the element to test
     * @return true if and only if the given element is an element of this set
     */
    public boolean contains(E elt)
    {
        //Student implementation
        //throw new UnsupportedOperationException("Not yet implemented.");
        return data.contains(elt);
    }

    /**
     * Prints all the elements in this set to the given stream.
     * Example: <CODE>s.printAll(System.out);</CODE>
     * @param out The stream to print to
     */
    public void printAll(java.io.PrintStream out)
    {
        for (E elt:data)
            out.println(elt.toString());
    }

    /**
     * Use this method to go through all the elements of the set.
     * @return an Iterator over the elements of the set
     */
    public Iterator<E> iterator()
    {
        return data.iterator();
    }
}

