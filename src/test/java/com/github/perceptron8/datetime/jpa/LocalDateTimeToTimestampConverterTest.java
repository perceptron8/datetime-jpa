package com.github.perceptron8.datetime.jpa;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;

import org.junit.Ignore;
import org.junit.Test;

import com.github.perceptron8.datetime.jpa.LocalDateTimeToTimestampConverter;

public class LocalDateTimeToTimestampConverterTest {
	private AttributeConverter<LocalDateTime, Timestamp> converter = new LocalDateTimeToTimestampConverter();
	
	private LocalDateTime entityAttribute = LocalDateTime.of(2000, 12, 31, 23, 59, 59);
	private Timestamp databaseColumn = Timestamp.valueOf(entityAttribute);
	
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
	
	@Ignore("JDK-8068959")
	@Test(expected = IllegalArgumentException.class)
	public void tooTinyToRepresent() {
		converter.convertToDatabaseColumn(LocalDateTime.MIN);
	}
	
	@Ignore("JDK-8068959")
	@Test(expected = IllegalArgumentException.class)
	public void tooLargeToRepresent() {
		converter.convertToDatabaseColumn(LocalDateTime.MIN);
	}
}
