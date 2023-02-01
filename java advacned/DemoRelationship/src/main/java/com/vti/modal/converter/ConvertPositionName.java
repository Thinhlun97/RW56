package com.vti.modal.converter;

import com.vti.modal.enumModal.PositionName;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ConvertPositionName implements AttributeConverter<String , String> {

    @Override
    public String convertToDatabaseColumn(String s) {
        return PositionName.valueOf(s).getValue();
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return PositionName.valueOf(s).name();
    }
}
