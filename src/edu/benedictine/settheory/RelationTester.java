//Test the student submissions for the RelationOnASet and Set classes
//Created by James Vanderhyde, 1 April 2011

package edu.benedictine.settheory;

public class RelationTester
{
    //The set of integers is infinite. How many do we want to check?
    private static int numIntegers = 64;
    private static Set<Integer> integers;;
    private static RelationOnASet<Integer> congmod4;
    private static RelationOnASet<Integer> lessThanEq;
    private static RelationOnASet<Integer> notEqual;
    private static RelationOnASet<Integer> divides;
    private static RelationOnASet<Integer> almostAll;

    public static void main(String[] args)
    {
        example4w();
        testSetContains();
        testReflexive();
        testSymmetric();
        testTransitive();
        testEquiv();
        testClasses();
    }

    public static void testSetContains()
    {
        Set<String> s=new Set<String>();
        s.addElement("Hello");
        s.addElement("James");
        s.addElement("Mariam");

        testResult("Set contains James",true,s.contains("James"));
        testResult("Set contains Mariah",false,s.contains("Mariah"));

        class IntTester
        {
            private void testInt(int test, boolean expected)
            {
                testResult("Subset of integers contains "+test+":",expected,integers.contains(test));
            }
        }

        IntTester t=new IntTester();

        t.testInt(0,true);
        t.testInt(1,true);
        t.testInt(32,true);
        t.testInt(-1,false);
        t.testInt(64,false);
        t.testInt(128,false);
    }

    private static void testResult(String message, boolean expected, boolean test)
    {
        System.out.println(message);
        System.out.println(" "+expected+" (expected)");
        System.out.println(" "+test+" (actual)");
        if (test!=expected)
            System.out.println(" *****");
    }

    public static void testReflexive()
    {
        testResult("congmod4 is reflexive:",true,congmod4.isReflexive());
        testResult("lessThanEq is reflexive:",true,lessThanEq.isReflexive());
        testResult("notEqual is reflexive:",false,notEqual.isReflexive());
        testResult("divides is reflexive:",false,divides.isReflexive());
        testResult("almostAll is reflexive:",true,almostAll.isReflexive());
    }

    public static void testSymmetric()
    {
        testResult("congmod4 is symmetric:",true,congmod4.isSymmetric());
        testResult("lessThanEq is symmetric:",false,lessThanEq.isSymmetric());
        testResult("notEqual is symmetric:",true,notEqual.isSymmetric());
        testResult("divides is symmetric:",false,divides.isSymmetric());
        testResult("almostAll is symmetric:",false,almostAll.isSymmetric());
    }

    public static void testTransitive()
    {
        testResult("congmod4 is transitive:",true,congmod4.isTransitive());
        testResult("lessThanEq is transitive:",true,lessThanEq.isTransitive());
        testResult("notEqual is transitive:",false,notEqual.isTransitive());
        testResult("divides is transitive:",true,divides.isTransitive());
        testResult("almostAll is transitive:",false,almostAll.isTransitive());
    }

    public static void testEquiv()
    {
        testResult("congmod4 is an equivalence relation:",true,congmod4.isEquivalenceRelation());
        testResult("lessThanEq is an equivalence relation:",false,lessThanEq.isEquivalenceRelation());
        testResult("notEqual is an equivalence relation:",false,notEqual.isEquivalenceRelation());
        testResult("divides is an equivalence relation:",false,divides.isEquivalenceRelation());
        testResult("almostAll is an equivalence relation:",false,almostAll.isEquivalenceRelation());
    }

    public static void testClasses()
    {
        System.out.println("congmod4 equivalence classes:");
        congmod4.printEquivalenceClasses();
    }

    public static void example4w()
    {
        //Create the set and add a subset of integers to it
        integers=new Set<Integer>();
        for (int i=0; i<numIntegers; i++)
            integers.addElement(i);

        //Create the relation and add all related pairs to it
        congmod4=new RelationOnASet<Integer>(integers);
        for (int i=0; i<numIntegers; i++)
            for (int j=0; j<numIntegers; j++)
                if ((i-j)%4==0)
                    congmod4.addElement(new Pair(i,j));

        //Create another relation and add all related pairs to it
        lessThanEq=new RelationOnASet<Integer>(integers);
        for (int i=0; i<numIntegers; i++)
            for (int j=0; j<numIntegers; j++)
                if (i<=j)
                    lessThanEq.addElement(new Pair(i,j));

        //Create another relation and add all related pairs to it
        notEqual=new RelationOnASet<Integer>(integers);
        for (int i=0; i<numIntegers; i++)
            for (int j=0; j<numIntegers; j++)
                if (i!=j)
                    notEqual.addElement(new Pair(i,j));

        //Create another relation and add all related pairs to it
        divides=new RelationOnASet<Integer>(integers);
        for (int i=0; i<numIntegers; i++)
            for (int j=0; j<numIntegers; j++)
                if (i!=0 && j%i==0)
                    divides.addElement(new Pair(i,j));

        //Create another relation and add all related pairs to it
        almostAll=new RelationOnASet<Integer>(integers);
        for (int i=0; i<numIntegers; i++)
            for (int j=0; j<numIntegers; j++)
                if (i!=63 || j!=62)
                    almostAll.addElement(new Pair(i,j));
    }

}
