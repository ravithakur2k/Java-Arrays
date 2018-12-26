package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {1,2,4,5,6,7,8,11,15};
        System.out.println("Array is "+ Arrays.toString(array));

        reverseArray(array);
        System.out.println("Reversed Array is "+Arrays.toString(array));
    }

    public static void reverseArray(int[] array){
        int maxLength = array.length-1;
        int halfLength = array.length/2;
        for(int i = 0; i < halfLength; i++){
            int temp = array[i];
            array[i] = array[maxLength - i];
            array[maxLength - i] = temp;
        }
    }
}
