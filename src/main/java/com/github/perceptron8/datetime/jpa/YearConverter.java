package com.github.perceptron8.datetime.jpa;

import java.time.Year;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link Year} to {@link Integer} and back again.
 */
@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Integer> {
	@Override
	public Integer convertToDatabaseColumn(Year attribute) {
		return attribute == null ? null : attribute.getValue();
	}

	@Override
	public Year convertToEntityAttribute(Integer dbData) {
		return dbData == null ? null : Year.of(dbData);
	}
}
