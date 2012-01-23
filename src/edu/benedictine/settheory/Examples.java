//Examples of Sets and Relations
//Created by James Vanderhyde, 3 March 2011

package edu.benedictine.settheory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Examples
{
    public static void main(String[] args)
    {
        example1();
    }

    //Need a very small example. Also need to show expected result for
    // equivalence classes.

    //Example 1: Relation from names (strings) to ages (ints)
    public static void example1()
    {
        //Create some elements
        String n1="James", n2="Mariam";
        int i1=34, i2=29;

        //Create the set of names and put the elements in it
        Set<String> names=new Set();
        names.addElement(n1);
        names.addElement(n2);

        //Create the set of ages and put the elements in it
        Set<Integer> ages=new Set();
        ages.addElement(i1);
        ages.addElement(i2);

        //Create a pair that we will put in the relation
        Pair<String,Integer> p=new Pair(n1,i1);

        //Create the relations and put the pairs in it
        Relation<String,Integer> r=new Relation(names,ages);
        r.addElement(p);
        r.addElement(new Pair(n2,i2));

        //Print out all the pairs in the relation
        r.printAll(System.out);
    }

    //Example 2: An equivalence relation (congruence mod 3)
    public static void example2()
    {
        //The set of integers is infinite. How many do we want to check?
        int numIntegers = 30;

        //Create the set and add a subset of integers to it
        Set<Integer> integers=new Set();
        for (int i=0; i<numIntegers; i++)
            integers.addElement(i);

        //Create the relation and add all related pairs to it
        RelationOnASet<Integer> congmod3=new RelationOnASet<Integer>(integers);
        for (int i=0; i<numIntegers; i++)
            for (int j=0; j<numIntegers; j++)
                if ((i-j)%3==0)
                    congmod3.addElement(new Pair(i,j));

        //Save it out
        try
        {
            ObjectOutputStream out=new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream("congmod3.dat")));
            out.writeObject(congmod3);
            out.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        //Print out all the pairs in the relation
        congmod3.printAll(System.out);
        System.out.println(congmod3.isReflexive()); //prints true

        //Print out the equivalence classes
        if (congmod3.isEquivalenceRelation())
            congmod3.printEquivalenceClasses();
    }

    //Save out a file
    public static void example4w()
    {
        //The set of integers is infinite. How many do we want to check?
        int numIntegers = 64;

        //Create the set and add a subset of integers to it
        Set<Integer> integers=new Set();
        for (int i=0; i<numIntegers; i++)
            integers.addElement(i);

        //Create the relation and add all related pairs to it
        RelationOnASet<Integer> congmod4=new RelationOnASet<Integer>(integers);
        for (int i=0; i<numIntegers; i++)
            for (int j=0; j<numIntegers; j++)
                if ((i-j)%4==0)
                    congmod4.addElement(new Pair(i,j));

        //Save it out
        try
        {
            ObjectOutputStream out=new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream("example4.dat")));
            out.writeObject(congmod4);
            out.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        
    }

    //Example 3: not equal
    public static void example3()
    {
        //The set of integers is infinite. How many do we want to check?
        int numIntegers = 30;

        //Create the set and add a subset of integers to it
        Set<Integer> integers=new Set();
        for (int i=0; i<numIntegers; i++)
            integers.addElement(i);

        //Create the relation and add all related pairs to it
        RelationOnASet<Integer> noteq=new RelationOnASet<Integer>(integers);
        for (int i=0; i<numIntegers; i++)
            for (int j=0; j<numIntegers; j++)
                if (i != j)
                    noteq.addElement(new Pair(i,j));

        //Print out all the pairs in the relation
        noteq.printAll(System.out);
        System.out.println(noteq.isReflexive()); //prints false
    }

    //Example 4: Read in a relation
    //This didn't work because students modify the classes
    public static void example4()
    {
        RelationOnASet r=null;
        try
        {
            ObjectInputStream in=new ObjectInputStream(
                new BufferedInputStream(
                new FileInputStream("example4.dat")));
            r = (RelationOnASet)in.readObject();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (ClassCastException e)
        {
            System.out.println("The file does not contain a RelationOnASet");
        }

        //Print out all the pairs in the relation
        r.printAll(System.out);
        System.out.println(r.isReflexive()); //prints true

        //Print out the equivalence classes
        if (r.isEquivalenceRelation())
            r.printEquivalenceClasses();
    }
}
