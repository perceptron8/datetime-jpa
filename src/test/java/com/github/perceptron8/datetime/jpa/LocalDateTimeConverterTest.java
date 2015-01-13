package com.github.perceptron8.datetime.jpa;


import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;

import org.junit.Ignore;
import org.junit.Test;

public class LocalDateTimeConverterTest {
	private AttributeConverter<LocalDateTime, Timestamp> converter = new LocalDateTimeConverter();
	
	private LocalDateTime attribute = LocalDateTime.of(1960, 1, 1, 23, 3, 20);
	private Timestamp dbData = Timestamp.valueOf(attribute);
	
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
	
	@Ignore("JI-9018210")
	@Test(expected = IllegalArgumentException.class)
	public void tooTinyToRepresent() {
		converter.convertToDatabaseColumn(LocalDateTime.MIN);
	}
	
	@Ignore("JI-9018210")
	@Test(expected = IllegalArgumentException.class)
	public void tooLargeToRepresent() {
		converter.convertToDatabaseColumn(LocalDateTime.MIN);
	}
}
