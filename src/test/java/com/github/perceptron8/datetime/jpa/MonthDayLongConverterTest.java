package com.github.perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.time.Month;
import java.time.MonthDay;

import javax.persistence.AttributeConverter;

import org.junit.Test;

import com.github.perceptron8.datetime.jpa.MonthDayLongConverter;

public class MonthDayLongConverterTest {
	private AttributeConverter<MonthDay, Long> converter = new MonthDayLongConverter();

	@Test
	public void backAndForth() {
		for (Month month : Month.values()) {
			for (int dayOfMonth = 1; dayOfMonth <= month.length(true); dayOfMonth++) {
				MonthDay monthDay = MonthDay.of(month, dayOfMonth);
				Long databaseColumn = converter.convertToDatabaseColumn(monthDay);
				assertThat(converter.convertToEntityAttribute(databaseColumn), is(equalTo(monthDay)));
			}
		}
	}

	@Test
	public void nulls() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
	}
}
