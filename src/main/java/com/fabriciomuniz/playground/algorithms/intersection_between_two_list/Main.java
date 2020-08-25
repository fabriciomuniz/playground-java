package com.fabriciomuniz.playground.algorithms.intersection_between_two_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    /**
     * definition:
     * 1) set two random int lists as input
     * 2) order both lists by bubble sort (or other)
     * 3) remove duplicate items from lists (if necessary)
     * 4) walk through arrays recursively from smallest to biggest and check if a current position element already contained on another list
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arrayOne = {99, 10, 150, 1, 0, -35, 2, 99, 15, 200, -50};
        int[] arrayTwo = {30, 150, -9, 2, 15, 0, -150, 200, 5, 0, 300, 0, 30, 400, 40, 1000, 99, 200, -35};
        interceptionList(arrayOne, arrayTwo);
    }

    public static void interceptionList(int[] arrayOne, int[] arrayTwo) {
        int[] biggestOrderedArray = orderAndRemoveDuplicateItemsOfArray((arrayOne.length > arrayTwo.length) ? arrayOne : arrayTwo);
        int[] smallestOrderedArray = orderAndRemoveDuplicateItemsOfArray((arrayOne.length < arrayTwo.length) ? arrayOne : arrayTwo);
        List<Integer> list = new ArrayList<>();

        for (int x = 0; x < biggestOrderedArray.length - 1; x++) {
            boolean check = checkElementExistsInArray(biggestOrderedArray[x], smallestOrderedArray);
            if (check && !list.contains(biggestOrderedArray[x]))
                list.add(biggestOrderedArray[x]);
        }

        for (Integer number : list) {
            System.out.println(number);
        }

    }

    private static boolean checkElementExistsInArray(int element, int[] array) {
        for (int position : array) {
            if (position == element)
                return true;
        }
        return false;
    }

    private static int[] orderAndRemoveDuplicateItemsOfArray(int[] arrayToOrder) {
        boolean change = false;
        //sort
        for (int x = 0; x < arrayToOrder.length - 1; x++) {
            if (arrayToOrder[x] > arrayToOrder[x + 1]) {
                int allocatedValue = arrayToOrder[x + 1];
                arrayToOrder[x + 1] = arrayToOrder[x];
                arrayToOrder[x] = allocatedValue;
                change = true;
            }
        }
        if (change)
            return orderAndRemoveDuplicateItemsOfArray(arrayToOrder);
        return arrayToOrder;
    }

}
