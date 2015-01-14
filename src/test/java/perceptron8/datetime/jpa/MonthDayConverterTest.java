package perceptron8.datetime.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.time.Month;
import java.time.MonthDay;

import javax.persistence.AttributeConverter;

import org.junit.Test;

public class MonthDayConverterTest {
	private AttributeConverter<MonthDay, Date> converter = new MonthDayConverter();

	@Test
	public void convertToDatabaseColumn() {
		assertThat(converter.convertToDatabaseColumn(null), is(nullValue()));
		for (Month month : Month.values()) {
			for (int dayOfMonth = 1; dayOfMonth <= month.length(true); dayOfMonth++) {
				MonthDay monthDay = MonthDay.of(month, dayOfMonth);
				Date databaseColumn = Date.valueOf(monthDay.atYear(MonthDayConverter.DEAFULT_YEAR));
				assertThat(converter.convertToDatabaseColumn(monthDay), is(equalTo(databaseColumn)));
			}
		}
	}

	@Test
	public void convertToEntityAttribute() {
		assertThat(converter.convertToEntityAttribute(null), is(nullValue()));
		for (Month month : Month.values()) {
			for (int dayOfMonth = 1; dayOfMonth <= month.length(true); dayOfMonth++) {
				MonthDay monthDay = MonthDay.of(month, dayOfMonth);
				Date databaseColumn = Date.valueOf(monthDay.atYear(MonthDayConverter.DEAFULT_YEAR));
				assertThat(converter.convertToEntityAttribute(databaseColumn), is(equalTo(monthDay)));
			}
		}
	}
}
