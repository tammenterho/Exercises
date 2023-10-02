package org.example;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AppTest 
{
    @Test
    public void testSmallestGap() {
        ArrayList<Integer>numbers1 = new ArrayList<>();
        numbers1.add(1);
        numbers1.add(4);
        numbers1.add(12);
        numbers1.add(22);

        // double num test
        ArrayList<Integer>numbers2 = new ArrayList<>();
        numbers2.add(5);
        numbers2.add(7);
        numbers2.add(7);
        numbers2.add(10);

        // same result test
        ArrayList<Integer>numbers3 = new ArrayList<>();
        numbers3.add(1);
        numbers3.add(3);
        numbers3.add(5);
        numbers3.add(7);

        assertEquals(2, App.smallestGap(numbers1));
        assertEquals(1, App.smallestGap(numbers2));
        assertEquals(1, App.smallestGap(numbers3));

    }
}
