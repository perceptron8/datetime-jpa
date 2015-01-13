package com.github.perceptron8.datetime.jpa;


import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;

import org.junit.Test;

public class LocalTimeConverterTest {
	private AttributeConverter<LocalTime, Time> converter = new LocalTimeConverter();

	private LocalTime attribute = LocalTime.of(23, 3, 20);
	private Time dbData = Time.valueOf(attribute);
	
	@Test
	public void convertToDatabaseColumn() {
		assertEquals(null, converter.convertToDatabaseColumn(null));
		assertEquals(dbData, converter.convertToDatabaseColumn(attribute));
	}

	@Test
	public void convertToEntityAttribute() {
		assertEquals(null, converter.convertToEntityAttribute(null));
		assertEquals(attribute, converter.convertToEntityAttribute(dbData));
	}
}
