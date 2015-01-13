package com.github.perceptron8.datetime.jpa;

import java.time.Month;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link Month} to {@link Integer} and back again.
 */
@Converter(autoApply = true)
public class MonthConverter implements AttributeConverter<Month, Integer> {
	@Override
	public Integer convertToDatabaseColumn(Month attribute) {
		return attribute == null ? null : attribute.getValue();
	}

	@Override
	public Month convertToEntityAttribute(Integer dbData) {
		return dbData == null ? null : Month.of(dbData);
	}
}
