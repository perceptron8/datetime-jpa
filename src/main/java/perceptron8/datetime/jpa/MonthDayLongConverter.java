package perceptron8.datetime.jpa;

import java.time.MonthDay;

import javax.persistence.AttributeConverter;

/**
 * Converts {@link MonthDay} to {@link Long} and back again.
 */
public class MonthDayLongConverter implements AttributeConverter<MonthDay, Long> {
	@Override
	public Long convertToDatabaseColumn(MonthDay attribute) {
		return attribute == null ? null : (long) attribute.getMonthValue() << 32 | (long) attribute.getDayOfMonth() << 0;
	}

	@Override
	public MonthDay convertToEntityAttribute(Long dbData) {
		return dbData == null ? null : MonthDay.of((int) (dbData >> 32), (int) (dbData >> 0));
	}
}
