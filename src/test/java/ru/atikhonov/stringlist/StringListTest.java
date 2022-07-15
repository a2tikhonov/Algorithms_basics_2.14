package ru.atikhonov.stringlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {

    StringList out = new StringListImpl(5);


    @BeforeEach
    void setUp() {
    }

    @Test
    void add() {
        assertEquals("string0", out.add("string0"));
        assertEquals(1, out.size());
        assertEquals("string0", out.get(0));
        assertEquals("string1", out.add("string1"));
        assertEquals(2, out.size());
        assertEquals("string1", out.get(1));
        assertThrows(IllegalArgumentException.class, () -> out.add(null));
    }

    @Test
    void testAdd() {
        assertEquals("string0", out.add(0, "string0"));
        assertEquals(1, out.size());
        assertEquals("string0", out.get(0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> out.add(1, "string1"));
    }

    @Test
    void set() {
        out.add("string");
        assertEquals("string0", out.set(0, "string0"));
        assertEquals("string0", out.get(0));
    }

    @Test
    void remove() {
        out.add("string0");
        out.add("string1");
        out.add("string2");
        out.remove(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> out.remove(3));
        assertEquals("string2", out.get(1));
        assertNotEquals("string1", out.contains("string1"));
    }

    @Test
    void testRemove() {
        out.add("string0");
        out.add("string1");
        out.add("string2");
        out.remove("string1");
        assertThrows(IllegalArgumentException.class, () -> out.remove("string10"));
        assertEquals("string2", out.get(1));
        assertNotEquals("string1", out.contains("string1"));
    }

    @Test
    void contains() {
        out.add("string0");
        assertTrue(out.contains("string0"));
        assertFalse(out.contains("string10"));
    }

    @Test
    void indexOf() {
        out.add("string0");
        out.add("string1");
        out.add("string2");
        assertEquals(1, out.indexOf("string1"));
        assertEquals(-1, out.indexOf("string10"));
    }

    @Test
    void lastIndexOf() {
        out.add("string0");
        out.add("string1");
        out.add("string2");
        assertEquals(1, out.lastIndexOf("string1"));
        assertEquals(-1, out.lastIndexOf("string10"));
    }

    @Test
    void get() {
        out.add("string1");
        assertEquals("string1", out.get(0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> out.get(1));
    }

    @Test
    void testEquals() {
        StringList expected = new StringListImpl(6);
        out.add("string0");
        out.add("string1");
        out.add("string2");
        expected.add("string0");
        expected.add("string1");
        expected.add("string2");
        assertTrue(out.equals(expected));
        expected.add("string3");
        assertFalse(out.equals(expected));
    }

    @Test
    void size() {
        out.add("string0");
        out.add("string1");
        out.add("string2");
        assertEquals(3, out.size());
        out.remove(0);
        assertEquals(2, out.size());
        out.add("string0");
        out.add("string3");
        assertEquals(4, out.size());
    }

    @Test
    void isEmpty() {
        out.add("string0");
        assertFalse(out.isEmpty());
        out.remove(0);
        assertTrue(out.isEmpty());
    }

    @Test
    void clear() {
        out.add("string0");
        out.add("string1");
        out.add("string2");
        out.clear();
        assertTrue(out.isEmpty());
    }

    @Test
    void toArray() {
        String[] expected = new String[] {"string0", "string1", "string2"};
        out.add("string0");
        out.add("string1");
        out.add("string2");
        String[] actual = out.toArray();
        assertTrue(Arrays.equals(expected, actual));
    }
}