package com.github.perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

import javax.persistence.AttributeConverter;

import org.junit.Ignore;
import org.junit.Test;

public class YearMonthToDateConverterTest {
	private AttributeConverter<YearMonth, Date> converter = new YearMonthToDateConverter();
	
	private int[] years = { 1, 9999 };
	private Month[] months = Month.values();

	@Test
	public void backAndForth() {
		for (int year : years) {
			for (Month month : months) {
				YearMonth yearMonth = YearMonth.of(year, month);
				Date databaseColumn = converter.convertToDatabaseColumn(yearMonth);
				assertThat(converter.convertToEntityAttribute(databaseColumn), is(equalTo(yearMonth)));
			}
		}
	}

	@Test
	public void nulls() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
	}

	@Ignore("JDK-8068957")
	@Test(expected = IllegalArgumentException.class)
	public void illegalArgumentException() {
		converter.convertToDatabaseColumn(YearMonth.of(Year.MAX_VALUE, Month.JANUARY));
	}
}
