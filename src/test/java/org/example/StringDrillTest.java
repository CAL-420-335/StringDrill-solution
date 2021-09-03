package org.example;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class StringDrillTest extends TestCase {

    @Test
    public void testCommencePar(){
        StringDrill test1 = new StringDrill("AlloMonCoco");
        assertTrue(test1.commencePar("A"));
        assertTrue(test1.commencePar(""));
        assertTrue(test1.commencePar("Al"));
        assertTrue(test1.commencePar("Allo"));
        assertTrue(test1.commencePar("AlloMonCoco"));

        assertFalse(test1.commencePar("a"));
        assertFalse(test1.commencePar("al"));
        assertFalse(test1.commencePar("l"));
        assertFalse(test1.commencePar("AlloMonCocox"));
        assertFalse(test1.commencePar(" Allo"));
    }

    @Test
    public void testNbOccurence(){
        StringDrill test1 = new StringDrill("AlloMonCoco");
        assertEquals(test1.nbOccurence("A"), 1);
        assertEquals(test1.nbOccurence("l"), 2);
        assertEquals(test1.nbOccurence("o"), 4);
        assertEquals(test1.nbOccurence("x"), 0);
        assertEquals(test1.nbOccurence("ll"), 1);
        assertEquals(test1.nbOccurence("coco"), 0);
        assertEquals(test1.nbOccurence("Cococ"), 0);
        assertEquals(test1.nbOccurence("Coco"), 1);
        assertEquals(test1.nbOccurence("Allo"), 1);

        StringDrill test2 = new StringDrill("aaaa");
        assertEquals(test2.nbOccurence("a"), 4);
        assertEquals(test2.nbOccurence("aa"), 3);
        assertEquals(test2.nbOccurence("aaa"), 2);
        assertEquals(test2.nbOccurence("aaaa"), 1);
        assertEquals(test2.nbOccurence("aaaaa"), 0);
    }

    @Test
    public void testSplit(){
        StringDrill test1 = new StringDrill("a,b,c,d");
        String[] res = {"a", "b", "c", "d"};
        assertArrayEquals(res, test1.split(","));
        res = new String[] {"a,b,c,d"};
        assertArrayEquals(res, test1.split("-"));

        res = new String[] {"a,", ",c,d"};
        assertArrayEquals(res, test1.split("b"));

        res = new String[] {"a,b", "d"};
        assertArrayEquals(res, test1.split(",c,"));

        res = new String[] {"a,b,c,d"};
        assertArrayEquals(res, test1.split("e"));
    }

    @Test
    public void testSubSplit(){
        StringDrill test1 = new StringDrill("a,b,c,d");

        assertEquals("a", test1.subSplit(0, ","));
        assertEquals("b", test1.subSplit(1, ","));
        assertEquals("c", test1.subSplit(2, ","));
        assertEquals("d", test1.subSplit(3, ","));
        assertEquals("a,b", test1.subSplit(0, ",c,"));
        assertEquals("d", test1.subSplit(1, ",c,"));
        assertEquals("a,b,c", test1.subSplit(0, ",d"));
        assertEquals("", test1.subSplit(1, ",d"));

        StringDrill test2 = new StringDrill("a,b,,c,d");
        assertEquals("", test2.subSplit(2, ","));
    }
}