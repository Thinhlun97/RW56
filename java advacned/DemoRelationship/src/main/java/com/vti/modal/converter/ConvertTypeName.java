package com.vti.modal.converter;

import com.vti.modal.enumModal.TypeName;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ConvertTypeName implements AttributeConverter<Integer,String> {
    @Override
    public String convertToDatabaseColumn(Integer integer) {
        return TypeName.valueOf(integer.toString()).name();
    }

    @Override
    public Integer convertToEntityAttribute(String s) {
        return TypeName.valueOf(s).getValue();
    }
}
