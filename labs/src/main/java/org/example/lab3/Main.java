package org.example.lab3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private int[] firstArray;
    private int[] secondArray;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //first int array
        System.out.println("Enter your size of first array: ");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        System.out.println("Enter your array with " + size1 + " nums: ");
        for(int i = 0; i < size1; i++){
            arr1[i] = scanner.nextInt();
        }

        //second int array
        System.out.println("Enter your size of second array: ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        System.out.println("Enter your second array with " + size2 + " nums: ");
        for(int i = 0; i < size2; i++){
            arr2[i] = scanner.nextInt();
        }

        //find Intersection of both arrays
        ArrayList<Integer> intersection = new ArrayList<>();
        for(int i = 0; i < size1; i++){
            for(int j = 0; j < size2; j++){
                if(arr1[i] == arr2[j]){
                    intersection.add(arr1[i]);
                }
            }
        }
        System.out.println("Intersection of both arrays is: ");
        for (int i : intersection){
            System.out.print(i);
        }

        //add intersection values to hashSet
        Set<Double> doubleSet = new HashSet<>();
        for(int i : intersection){
            doubleSet.add((double) i);
        }

        //Add an element to the end of the list
        doubleSet.add(11.0);

        //Remove an element from the list
        doubleSet.remove(1.0);

        //Replace an element in the list

        if(doubleSet.contains(11.0)){
            doubleSet.remove(11.0);
            doubleSet.add(11.5);
        }


        //Print the elements of the list
        System.out.println("\nall elements of hashSet:");
        for(Double el : doubleSet){
            System.out.println(el);
        }

        //situation for ArithmeticException
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Attempted to divide by zero.");
            System.out.println("Explanation: Division by zero is undefined in mathematics.");
        }
    }
}
