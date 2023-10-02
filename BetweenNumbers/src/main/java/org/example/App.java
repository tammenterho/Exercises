package org.example;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App
{
    public static int smallestGap(ArrayList<Integer> numbers) {


        Collections.sort(numbers);

        int smallestGap = Integer.MAX_VALUE;

        for (int i= 0; i < numbers.size() - 1; i++) {
            int currentNum = numbers.get(i);
            int nextNum = numbers.get(i + 1);
            int gap = nextNum - currentNum - 1;

            if (currentNum == nextNum) {
                continue;
            }

            if (gap < smallestGap) {
                smallestGap = gap;
            }
        }
        return smallestGap;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
