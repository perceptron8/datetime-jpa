datetime-jpa
============
JPA 2.1 attribute converters for JSR-310 temporal types (java.time.*).

Following conversions are supported:

| Java SE 8      | ANSI SQL   |
| -------------- | ---------- |
| DayOfWeek      | INTEGER    |
| LocalDate      | DATE       |
| LocalDateTime  | TIMESTAMP  |
| LocalTime      | TIME       |
| Month          | INTEGER    |
| MonthDay       | DATE       |
| MonthDay       | LONG       |
| Year           | INTEGER    |
| YearMonth      | DATE       |
| YearMonth      | LONG       |


Credits
-------
* [montanajava/jpaattributeconverters](https://bitbucket.org/montanajava/jpaattributeconverters) 
* [marschall/threeten-jpa](https://github.com/marschall/threeten-jpa)
* [JPA_SPEC-63](https://java.net/jira/browse/JPA_SPEC-63)


Usage
-----
```xml
<persistence-unit>
    …
    <class>perceptron8.datetime.jpa.LocalTimeConverter</class>
    <class>perceptron8.datetime.jpa.LocalDateConverter</class>
    <class>perceptron8.datetime.jpa.LocalDateTimeConverter</class>
    …
</persistence-unit>
```

```java
@Entity
public class SampleEntity {
    …
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime localDateTime;
    …
    private DayOfWeek dayOfWeek;
    private Month month;
    private Year year;
    …
    @Convert(converter = MonthDayConverter.class)
    private MonthDay monthDay;
    @Convert(converter = MonthDayLongConverter.class)
    private MonthDay monthDayLong;
    @Convert(converter = YearMonthConverter.class)
    private YearMonth yearMonth;
    @Convert(converter = YearMonthLongConverter.class)
    private YearMonth yearMonthLong;
    …
}
```
