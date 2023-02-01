package com.vti.modal.enumModal;

public enum PositionName {
    Dev("Deverlop"),Test("Test_convert"),ScrumMaster("ScumMaster"),PM("PM_convert");

    private String value;

    PositionName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
