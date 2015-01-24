package com.github.perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.time.Year;

import javax.persistence.AttributeConverter;

import org.junit.Test;

import com.github.perceptron8.datetime.jpa.YearToIntegerConverter;

public class YearToIntegerConverterTest {
	private AttributeConverter<Year, Integer> converter = new YearToIntegerConverter();

	@Test
	public void convertToDatabaseColumn() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		assertThat(converter.convertToDatabaseColumn(Year.of(0)), is(equalTo(0)));
		assertThat(converter.convertToDatabaseColumn(Year.of(1)), is(equalTo(1)));
		assertThat(converter.convertToDatabaseColumn(Year.of(2000)), is(equalTo(2000)));
		assertThat(converter.convertToDatabaseColumn(Year.of(Year.MIN_VALUE)), is(equalTo(Year.MIN_VALUE)));
		assertThat(converter.convertToDatabaseColumn(Year.of(Year.MAX_VALUE)), is(equalTo(Year.MAX_VALUE)));
	}

	@Test
	public void convertToEntityAttribute() {
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
		assertThat(converter.convertToEntityAttribute(0), is(equalTo(Year.of(0))));
		assertThat(converter.convertToEntityAttribute(1), is(equalTo(Year.of(1))));
		assertThat(converter.convertToEntityAttribute(2000), is(equalTo(Year.of(2000))));
		assertThat(converter.convertToEntityAttribute(Year.MIN_VALUE), is(equalTo(Year.of(Year.MIN_VALUE))));
		assertThat(converter.convertToEntityAttribute(Year.MAX_VALUE), is(equalTo(Year.of(Year.MAX_VALUE))));
	}
}
