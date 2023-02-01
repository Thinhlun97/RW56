package com.vti.modal.enumModal;

public enum SalaryName {
    DEV(600), TEST(700), ScrumMaster(1500), PM(2000);

    private int value;

    SalaryName(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}