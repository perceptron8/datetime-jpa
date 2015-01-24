package com.github.perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

import javax.persistence.AttributeConverter;

import org.junit.Test;

public class YearMonthToLongConverterTest {
	private AttributeConverter<YearMonth, Long> converter = new YearMonthToLongConverter();
	
	private int[] years = { Year.MIN_VALUE, -1, 0, 1, Year.MAX_VALUE };
	private Month[] months = Month.values();
	
	@Test
	public void backAndForth() {
		for (int year : years) {
			for (Month month : months) {
				YearMonth yearMonth = YearMonth.of(year, month);
				Long databaseColumn = converter.convertToDatabaseColumn(yearMonth);
				assertThat(converter.convertToEntityAttribute(databaseColumn), is(equalTo(yearMonth)));
			}
		}
	}

	@Test
	public void nulls() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
	}
}
