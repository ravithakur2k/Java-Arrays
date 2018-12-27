package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t0-To Print Choice Options");
        System.out.println("\t1-To Print the List of Grocery Items");
        System.out.println("\t2-To add an Item to the List");
        System.out.println("\t3-To modify and Item in the list");
        System.out.println("\t4-To remove and Item from the List");
        System.out.println("\t5-To search for an Item from the list");
        System.out.println("\t6-To quit the application");

    }

    public static void addItem(){
        System.out.println("Please enter the grocery Item: ");
        String groceryItemToBeAdded = scanner.nextLine();
        groceryList.addGrocery(groceryItemToBeAdded);
    }

    public static void modifyItem(){
        System.out.println("Please enter the number : ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the modified Item : ");
        String modifiedItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo-1,modifiedItem);
    }

    public static void removeItem(){
        System.out.println("Enter the Item number to be removed : ");
        int removeItemNumber = scanner.nextInt();
        groceryList.removeItem(removeItemNumber-1);
    }

    public static void searchItem(){
        System.out.println("Please Enter the Item name ");
        String itemName = scanner.nextLine();
        String searchedItem = groceryList.findItem(itemName);
        if(searchedItem != null){
            System.out.println("Found"+searchedItem+" in the grocery list");
        }else{
            System.out.println(itemName+" Not fount in the grocery List");
        }
    }
}
