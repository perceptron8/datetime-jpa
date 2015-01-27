package com.github.perceptron8.datetime.jpa;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link LocalDateTime}* to {@link Timestamp} and back again.
 * Throws {@link IllegalArgumentException} if the former is not possible.
 * <p>
 * <strong>Important note:</strong> Only values between {@code 0001-01-01T00:00:00}
 * and {@code 9999-12-31:23:59:59} are supported (at least until
 * <a href="https://bugs.openjdk.java.net/browse/JDK-8068959">JDK-8068959</a> is resolved).
 * </p>
 */
@Converter(autoApply = true)
public class LocalDateTimeToTimestampConverter implements AttributeConverter<LocalDateTime, Timestamp> {
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		return attribute == null ? null : Timestamp.valueOf(attribute);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		return dbData == null ? null : dbData.toLocalDateTime();
	}
}
