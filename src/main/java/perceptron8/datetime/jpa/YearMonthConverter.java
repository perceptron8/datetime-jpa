package perceptron8.datetime.jpa;

import java.sql.Date;
import java.time.DateTimeException;
import java.time.YearMonth;

import javax.persistence.AttributeConverter;

/**
 * Converts {@link YearMonth} to {@link Date} and back again.
 * Throws {@link DateTimeException} if the former is not possible.
 */
public class YearMonthConverter implements AttributeConverter<YearMonth, Date> {
	@Override
	public Date convertToDatabaseColumn(YearMonth attribute) {
		return attribute == null ? null : Date.valueOf(attribute.atDay(1));
	}

	@Override
	public YearMonth convertToEntityAttribute(Date dbData) {
		return dbData == null ? null : YearMonth.from(dbData.toLocalDate());
	}
}
