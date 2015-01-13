package com.github.perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;

import javax.persistence.AttributeConverter;

import org.junit.Test;

public class DayOfWeekConverterTest {
	private AttributeConverter<DayOfWeek, Integer> converter = new DayOfWeekConverter();

	@Test
	public void convertToDatabaseColumn() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
			assertThat(converter.convertToDatabaseColumn(dayOfWeek), is(equalTo(dayOfWeek.getValue())));
		}
	}

	@Test
	public void convertToEntityAttribute() {
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
		for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
			assertThat(converter.convertToEntityAttribute(dayOfWeek.getValue()), is(equalTo(dayOfWeek)));
		}
	}
}
