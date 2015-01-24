package com.github.perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.time.DateTimeException;
import java.time.DayOfWeek;

import javax.persistence.AttributeConverter;

import org.junit.Test;

import com.github.perceptron8.datetime.jpa.DayOfWeekToIntegerConverter;

public class DayOfWeekToIntegerConverterTest {
	private AttributeConverter<DayOfWeek, Integer> converter = new DayOfWeekToIntegerConverter();

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

	@Test(expected = DateTimeException.class)
	public void dateTimeException() {
		converter.convertToEntityAttribute(0);
	}
}
