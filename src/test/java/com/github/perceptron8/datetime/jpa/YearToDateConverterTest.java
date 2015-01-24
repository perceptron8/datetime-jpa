package com.github.perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.time.Year;

import javax.persistence.AttributeConverter;

import org.junit.Ignore;
import org.junit.Test;

public class YearToDateConverterTest {
	private AttributeConverter<Year, Date> converter = new YearToDateConverter();

	@Test
	public void convertToDatabaseColumn() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		assertThat(converter.convertToDatabaseColumn(Year.of(1)), is(equalTo(Date.valueOf(Year.of(1).atDay(1)))));
		assertThat(converter.convertToDatabaseColumn(Year.of(9999)), is(equalTo(Date.valueOf(Year.of(9999).atDay(1)))));
	}

	@Test
	public void convertToEntityAttribute() {
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
		assertThat(converter.convertToEntityAttribute(Date.valueOf(Year.of(1).atDay(1))), is(equalTo(Year.of(1))));
		assertThat(converter.convertToEntityAttribute(Date.valueOf(Year.of(9999).atDay(1))), is(equalTo(Year.of(9999))));
	}

	@Ignore("JDK-8068957")
	@Test(expected = IllegalArgumentException.class)
	public void tooTinyToRepresent() {
		converter.convertToDatabaseColumn(Year.of(Year.MIN_VALUE));
	}

	@Ignore("JDK-8068957")
	@Test(expected = IllegalArgumentException.class)
	public void tooLargeToRepresent() {
		converter.convertToDatabaseColumn(Year.of(Year.MAX_VALUE));
	}
}
