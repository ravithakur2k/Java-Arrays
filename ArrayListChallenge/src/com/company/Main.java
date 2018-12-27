package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("988034007");
    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\n Enter your actions : (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Shutting your device...");
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                case 7:
                    quit = true;
                    break;
            }

        }
    }

    private static void queryContact(){
        System.out.println("Enter the name to be queried: ");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if(contact == null){
            System.out.println("Contact Not Found");
        }else{
            System.out.println("Contact Name = "+contact.getName()+" Number = "+contact.getPhoneNumber());
        }
    }
    private static void removeContact(){
        System.out.println("Enter the contact to be removed:");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if(contact == null){
            System.out.println("Contact Not Found");
        }

        if(mobilePhone.removeContact(contact)){
            System.out.println("Successfully removed contact");
        }else{
            System.out.println("Error Removing Contact");
        }
    }
    private static void updateContact(){
        System.out.println("Enter a existing contact:");
        String oldName = scanner.nextLine();
        Contact oldContact = mobilePhone.queryContact(oldName);
        if(oldContact == null){
            System.out.println("Contact not found");
        }
        System.out.println("Enter a new contact:");
        String newName = scanner.nextLine();
        System.out.println("Enter a new phone number:");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        if(mobilePhone.updateContact(oldContact,newContact)){
            System.out.println("Successfully Updated Record");
        }else{
            System.out.println("Error Updating Records");
        }
    }
    private static void addNewContact(){
        System.out.println("Enter a new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter a new Number : ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name,phoneNumber);
        if(mobilePhone.addContact(newContact)){
            System.out.println("New Contact Added : name = "+newContact.getName()+" Phone Number = "+newContact.getPhoneNumber());
        }else{
            System.out.println("Cannot add, "+ newContact.getName()+" already on file");
        }
    }

    public static void startPhone(){
        System.out.println("Starting Phone...");
    }

    public static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shut\n"+
                            "1 - to print Contacts\n"+
                            "2 - to add a new contact\n"+
                            "3 - to update an existing contact\n"+
                            "4 - to remove a contact\n"+
                            "5 - to query an existing a contact\n"+
                            "6 - to print a list of available actions");
        System.out.println("Choose your action:");
    }

    private static void printContacts(){
        System.out.println("Printing Contacts");
        for(int i=0; i< mobilePhone.getContacts().size(); i++ ){
            System.out.println((i+1)+". Name - "+mobilePhone.getContacts().get(i).getName() +" Phone Number - "+mobilePhone.getContacts().get(i).getPhoneNumber());
        }
    }


}
