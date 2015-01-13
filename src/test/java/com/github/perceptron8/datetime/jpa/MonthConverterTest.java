package com.github.perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.time.Month;

import javax.persistence.AttributeConverter;

import org.junit.Test;

public class MonthConverterTest {
	private AttributeConverter<Month, Integer> converter = new MonthConverter();

	@Test
	public void convertToDatabaseColumn() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		for (Month month : Month.values()) {
			assertThat(converter.convertToDatabaseColumn(month), is(equalTo(month.getValue())));
		}
	}

	@Test
	public void convertToEntityAttribute() {
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
		for (Month month : Month.values()) {
			assertThat(converter.convertToEntityAttribute(month.getValue()), is(equalTo(month)));
		}
	}
}
