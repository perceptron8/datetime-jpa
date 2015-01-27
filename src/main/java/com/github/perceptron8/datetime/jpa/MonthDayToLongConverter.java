package com.github.perceptron8.datetime.jpa;

import java.time.DateTimeException;
import java.time.MonthDay;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link MonthDay} to {@link Long} and back again.
 * Throws {@link DateTimeException} if the latter is not possible.
 */
@Converter(autoApply = false)
public class MonthDayToLongConverter implements AttributeConverter<MonthDay, Long> {
	@Override
	public Long convertToDatabaseColumn(MonthDay attribute) {
		return attribute == null ? null : (long) attribute.getMonthValue() << 32 | (long) attribute.getDayOfMonth() << 0;
	}

	@Override
	public MonthDay convertToEntityAttribute(Long dbData) {
		return dbData == null ? null : MonthDay.of((int) (dbData >> 32), (int) (dbData >> 0));
	}
}
