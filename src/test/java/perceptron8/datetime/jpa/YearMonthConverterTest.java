package perceptron8.datetime.jpa;

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

public class YearMonthConverterTest {
	private AttributeConverter<YearMonth, Date> converter = new YearMonthConverter();

	@Test
	public void convertToDatabaseColumn() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		for (Month month : Month.values()) {
			YearMonth yearMonth = YearMonth.of(MonthDayConverter.DEAFULT_YEAR, month);
			Date databaseColumn = Date.valueOf(yearMonth.atDay(1));
			assertThat(converter.convertToDatabaseColumn(yearMonth), is(equalTo(databaseColumn)));
		}
	}

	@Test
	public void convertToEntityAttribute() {
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
		for (Month month : Month.values()) {
			YearMonth yearMonth = YearMonth.of(MonthDayConverter.DEAFULT_YEAR, month);
			Date databaseColumn = Date.valueOf(yearMonth.atDay(1));
			assertThat(converter.convertToEntityAttribute(databaseColumn), is(equalTo(yearMonth)));
		}
	}
	
	@Ignore("JI-9018213")
	@Test(expected = IllegalArgumentException.class)
	public void tooTinyToRepresent() {
		converter.convertToDatabaseColumn(YearMonth.of(Year.MIN_VALUE, Month.JANUARY));
	}

	@Ignore("JI-9018213")
	@Test(expected = IllegalArgumentException.class)
	public void tooLargeToRepresent() {
		converter.convertToDatabaseColumn(YearMonth.of(Year.MAX_VALUE, Month.JANUARY));
	}
}
