package com.github.perceptron8.datetime.jpa;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;

import org.junit.Test;

import com.github.perceptron8.datetime.jpa.LocalTimeToTimeConverter;

public class LocalTimeToTimeConverterTest {
	private AttributeConverter<LocalTime, Time> converter = new LocalTimeToTimeConverter();

	private LocalTime entityAttribute = LocalTime.of(23, 59, 59);
	private Time databaseColumn = Time.valueOf(entityAttribute);
	
	@Test
	public void convertToDatabaseColumn() {
		assertEquals(null, converter.convertToDatabaseColumn(null));
		assertEquals(databaseColumn, converter.convertToDatabaseColumn(entityAttribute));
	}

	@Test
	public void convertToEntityAttribute() {
		assertEquals(null, converter.convertToEntityAttribute(null));
		assertEquals(entityAttribute, converter.convertToEntityAttribute(databaseColumn));
	}
}
