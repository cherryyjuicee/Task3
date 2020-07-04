package com.company;

import java.util.ArrayList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] array = {1,3,5,7,9,2,6,10,8,4};
        String arrayInString = toString(array);
        System.out.println(arrayInString);
        array = sequenceRecovery(array);
        arrayInString = toString(array);
        System.out.println(arrayInString);
    }

    public static int[] sequenceRecovery(int[] array) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(array[array.length - 1]);
        for (int i = array.length - 2; i >= 0; i--) {
            queue.add(queue.delete());
            queue.add(array[i]);
        }
        int[] queueInArray = queue.toIntArray();
        return queueInArray;
    }

    public static String toString (int[] array) {
        String string = new String();
        for (int i = 0; i < array.length - 1; i++) {
            string += array[i] + ", ";
        }
        string+= array[array.length - 1];
        return string;
    }
}
