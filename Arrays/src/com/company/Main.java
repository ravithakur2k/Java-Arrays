package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] myIntegerValues = getIntegers(5);
        for(int i = 0; i< myIntegerValues.length; i++){
            System.out.println("Element "+i+" Typed value is "+myIntegerValues[i]);
        }
            sortIntegers(myIntegerValues);
        //System.out.println("Avg of numbers typed is equal to "+getAverage(myIntegerValues));
            printArray(sortIntegers(myIntegerValues));


//	    int[] myIntArray = new int[10];
//	    myIntArray[5] = 10;
//	    System.out.println(myIntArray[5]);
//
//	    double[] myDoubleArray = new double[5];
//	    myDoubleArray[0] = 2;
//	    System.out.println(myDoubleArray[0]);
//
//        for(int i = 0; i< myIntArray.length;i++){
//            myIntArray[i] = i*10;
//        }
//
//        printArray(myIntArray);
//
//
//    }
//    public static void printArray(int[] array){
//        for(int i = 0; i<array.length;i++){
//            System.out.println("Element "+ i +" value is "+ array[i]);
//        }

   }

   public static int[] getIntegers(int number){
        System.out.println("Enter " + number+ " Integer numbers.\r");
        int[] values = new int[number];
        for(int i = 0; i<values.length;i++){
            values[i] = scanner.nextInt();
        }
        return values;
   }

   public static void printArray(int[] array){
        for(int i = 0; i<array.length;i++){
            System.out.println("Element of "+i+" Value is "+array[i]);
        }
   }

   public static int[] sortIntegers(int[] array){
        int[] sortedArray = new int[array.length];
        for(int i = 0; i<array.length;i++){
            sortedArray[i] = array[i];
        }
       boolean flag = true;
       int temp;
       while(flag){
           flag = false;
           for(int i =0; i < sortedArray.length-1;i++){
               if(sortedArray[i] > sortedArray[i+1]){
                   temp = sortedArray[i];
                   sortedArray[i] = sortedArray[i+1];
                   sortedArray[i+1] = temp;
                   flag = true;
               }
           }
       }

        return sortedArray;
   }

   public static double getAverage(int[] array){
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        double avgSum = sum/array.length;
        return avgSum;
   }

}
