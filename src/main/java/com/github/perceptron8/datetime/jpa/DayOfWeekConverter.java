package com.github.perceptron8.datetime.jpa;

import java.time.DateTimeException;
import java.time.DayOfWeek;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link DayOfWeek} to {@link Integer} and back again.
 * Throws {@link DateTimeException} if the latter is not possible.
 */
@Converter(autoApply = true)
public class DayOfWeekConverter implements AttributeConverter<DayOfWeek, Integer> {
	@Override
	public Integer convertToDatabaseColumn(DayOfWeek attribute) {
		return attribute == null ? null : attribute.getValue();
	}

	@Override
	public DayOfWeek convertToEntityAttribute(Integer dbData) {
		return dbData == null ? null : DayOfWeek.of(dbData);
	}
}
