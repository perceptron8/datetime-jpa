package com.github.perceptron8.datetime.jpa;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link LocalDate} to {@link Date} and back again.
 * Throws {@link IllegalArgumentException} if the former is not possible.
 * <p>
 * <strong>Important note:</strong> Only values between {@code 0001-01-01} and
 * {@code 9999-12-31} are currently supported (at least until
 * <a href="https://bugs.openjdk.java.net/browse/JDK-8068957">JDK-8068957</a> is resolved).
 * </p>
 */
@Converter(autoApply = true)
public class LocalDateToDateConverter implements AttributeConverter<LocalDate, Date> {
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return attribute == null ? null : Date.valueOf(attribute);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		return dbData == null ? null : dbData.toLocalDate();
	}
}
