package com.github.perceptron8.datetime.jpa;

import java.sql.Date;
import java.time.DateTimeException;
import java.time.YearMonth;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link YearMonth} to {@link Date} and back again.
 * Throws {@link DateTimeException} if the former is not possible.
 */
@Converter(autoApply = true)
public class YearMonthToDateConverter implements AttributeConverter<YearMonth, Date> {
	@Override
	public Date convertToDatabaseColumn(YearMonth attribute) {
		return attribute == null ? null : Date.valueOf(attribute.atDay(1));
	}

	@Override
	public YearMonth convertToEntityAttribute(Date dbData) {
		return dbData == null ? null : YearMonth.from(dbData.toLocalDate());
	}
}
