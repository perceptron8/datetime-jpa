package perceptron8.datetime.jpa;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link LocalTime} to {@link Time} and back again.
 */
@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {
	@Override
	public Time convertToDatabaseColumn(LocalTime attribute) {
		return attribute == null ? null : Time.valueOf(attribute);
	}

	@Override
	public LocalTime convertToEntityAttribute(Time dbData) {
		return dbData == null ? null : dbData.toLocalTime();
	}
}
