package com.vti.modal.enumModal;

public enum TypeName {
    Esay(0), MultipleChoice(1);

    private int value;

    TypeName(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
