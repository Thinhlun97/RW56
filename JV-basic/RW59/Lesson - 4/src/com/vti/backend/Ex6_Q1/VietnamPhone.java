package com.vti.backend.Ex6_Q1;

import java.util.ArrayList;

public class VietnamPhone extends Phone{
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void insertContact(String name, String number){
        Contact contact = new Contact(name , number);
        contacts.add(contact);
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equals(name));
    }

    public void updateContact(String name, String newNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contact.setNumber(newNumber);
            }
        }
    }

    public void searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println(contact);
            }
        }
    }

    public void printContact() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
