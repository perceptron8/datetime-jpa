package perceptron8.datetime.jpa;

import java.sql.Date;
import java.time.MonthDay;

import javax.persistence.AttributeConverter;

/**
 * Converts {@link MonthDay} to {@link Date} and back again.
 */
public class MonthDayConverter implements AttributeConverter<MonthDay, Date> {
	public static final int DEAFULT_YEAR = 1972;
	
	@Override
	public Date convertToDatabaseColumn(MonthDay attribute) {
		return attribute == null ? null : Date.valueOf(attribute.atYear(DEAFULT_YEAR));
	}

	@Override
	public MonthDay convertToEntityAttribute(Date dbData) {
		return dbData == null ? null : MonthDay.from(dbData.toLocalDate());
	}
}
