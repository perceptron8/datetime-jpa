package com.github.perceptron8.datetime.jpa;

import java.sql.Date;
import java.time.Year;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link Year} to {@link Date} and back again.
 * Throws {@link IllegalArgumentException} if the former is not possible.
 * <p>
 * <strong>Important note:</strong> Only values between {@code 0001} and
 * {@code 9999} are currently supported (at least until
 * <a href="https://bugs.openjdk.java.net/browse/JDK-8068957">JDK-8068957</a> is resolved).
 * </p>
 */
@Converter(autoApply = false)
public class YearToDateConverter implements AttributeConverter<Year, Date> {
	@Override
	public Date convertToDatabaseColumn(Year attribute) {
		return attribute == null ? null : Date.valueOf(attribute.atDay(1));
	}

	@Override
	public Year convertToEntityAttribute(Date dbData) {
		return dbData == null ? null : Year.from(dbData.toLocalDate());
	}
}
