package com.github.perceptron8.datetime.jpa;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.time.Year;

import javax.persistence.AttributeConverter;

import org.junit.Test;

public class YearConverterTest {
	private AttributeConverter<Year, Integer> converter = new YearConverter();

	@Test
	public void convertToDatabaseColumn() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		assertThat(converter.convertToDatabaseColumn(Year.of(0)), is(equalTo(0)));
		assertThat(converter.convertToDatabaseColumn(Year.of(Year.MIN_VALUE)), is(equalTo(Year.MIN_VALUE)));
		assertThat(converter.convertToDatabaseColumn(Year.of(Year.MAX_VALUE)), is(equalTo(Year.MAX_VALUE)));
	}

	@Test
	public void convertToEntityAttribute() {
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
		assertThat(converter.convertToEntityAttribute(0), is(equalTo(Year.of(0))));
		assertThat(converter.convertToEntityAttribute(Year.MIN_VALUE), is(equalTo(Year.of(Year.MIN_VALUE))));
		assertThat(converter.convertToEntityAttribute(Year.MAX_VALUE), is(equalTo(Year.of(Year.MAX_VALUE))));
	}
}
