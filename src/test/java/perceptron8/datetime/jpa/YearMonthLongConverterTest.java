package perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

import javax.persistence.AttributeConverter;

import org.junit.Ignore;
import org.junit.Test;

public class YearMonthLongConverterTest {
	public static final int TEST_YEAR = MonthDayConverter.DEFAULT_YEAR;
	private AttributeConverter<YearMonth, Long> converter = new YearMonthLongConverter();
	
	@Test
	public void leap() {
		assertThat(Year.isLeap(TEST_YEAR), is(true));
	}

	@Test
	public void backAndForth() {
		for (Month month : Month.values()) {
			YearMonth yearMonth = YearMonth.of(TEST_YEAR, month);
			Long databaseColumn = converter.convertToDatabaseColumn(yearMonth);
			assertThat(converter.convertToEntityAttribute(databaseColumn), is(equalTo(yearMonth)));
		}
	}

	@Test
	public void nulls() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
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
