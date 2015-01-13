package com.github.perceptron8.datetime.jpa;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;

import org.junit.Ignore;
import org.junit.Test;

public class LocalDateConverterTest {
	private AttributeConverter<LocalDate, Date> converter = new LocalDateConverter();

	private LocalDate entityAttribute = LocalDate.of(2000, 12, 31);
	private Date databaseColumn = Date.valueOf(entityAttribute);

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

	@Ignore("JI-9018213")
	@Test(expected = IllegalArgumentException.class)
	public void tooTinyToRepresent() {
		converter.convertToDatabaseColumn(LocalDate.MIN);
	}

	@Ignore("JI-9018213")
	@Test(expected = IllegalArgumentException.class)
	public void tooLargeToRepresent() {
		converter.convertToDatabaseColumn(LocalDate.MAX);
	}
}
