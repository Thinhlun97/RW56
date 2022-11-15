package com.vti.backend.Ex6_Q1;

public abstract class Phone {
    public abstract void insertContact(String number, String name );
    public abstract void removeContact(String name );
    public abstract void updateContact(String number, String name );
    public abstract void searchContact(String name );
}
