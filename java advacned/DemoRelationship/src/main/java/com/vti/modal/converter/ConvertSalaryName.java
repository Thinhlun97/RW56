package com.vti.modal.converter;

import com.vti.modal.enumModal.SalaryName;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ConvertSalaryName implements AttributeConverter<Integer , String> {
    @Override
    public String convertToDatabaseColumn(Integer integer) {
        return SalaryName.valueOf(integer.toString()).name();
    }

    @Override
    public Integer convertToEntityAttribute(String s) {
        return SalaryName.valueOf(s).getValue();
    }
}
