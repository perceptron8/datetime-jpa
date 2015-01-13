package com.github.perceptron8.datetime.jpa;


import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;

import org.junit.Ignore;
import org.junit.Test;

public class LocalDateConverterTest {
	private AttributeConverter<LocalDate, Date> converter = new LocalDateConverter();

	private LocalDate attribute = LocalDate.of(1960, 1, 1);
	private Date dbData = Date.valueOf(attribute);

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
