package com.github.perceptron8.datetime.jpa;

import java.sql.Date;
import java.time.DateTimeException;
import java.time.YearMonth;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link YearMonth} to {@link Date} and back again.
 * Throws {@link DateTimeException} if the former is not possible.
 * <p>
 * <strong>Important note:</strong> only values between {@code 0001-01} and
 * {@code 9999-12} are currently supported (at least until
 * <a href="https://bugs.openjdk.java.net/browse/JDK-8068957">JDK-8068957</a> is resolved).
 * </p>
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
