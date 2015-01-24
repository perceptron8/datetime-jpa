datetime-jpa
============
JPA 2.1 attribute converters for JSR-310 temporal types (java.time.*).

Following conversions are supported:



| Java SE 8      | ANSI SQL       |
| -------------- | -------------- |
| DayOfWeek      | INTEGER        |
| LocalDate      | DATE           |
| LocalDateTime  | TIMESTAMP      |
| LocalTime      | TIME           |
| Month          | INTEGER        |
| MonthDay       | DATE, LONG¹    |
| Year           | DATE¹, INTEGER |
| YearMonth      | DATE, LONG¹    |

¹ - use `@Convert` to choose this one


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
    <class>com.github.perceptron8.datetime.jpa.LocalTimeToTimeConverter</class>
    <class>com.github.perceptron8.datetime.jpa.LocalDateToDateConverter</class>
    <class>com.github.perceptron8.datetime.jpa.LocalDateTimeToTimestampConverter</class>
    …
    <class>com.github.perceptron8.datetime.jpa.DayOfWeekToIntegerConverter</class>
    <class>com.github.perceptron8.datetime.jpa.MonthToIntegerConverter</class>
    <class>com.github.perceptron8.datetime.jpa.YearToDateConverter</class>
    <class>com.github.perceptron8.datetime.jpa.YearToIntegerConverter</class>
    …
    <class>com.github.perceptron8.datetime.jpa.MonthDayToDateConverter</class>
    <class>com.github.perceptron8.datetime.jpa.MonthDayToLongConverter</class>
    <class>com.github.perceptron8.datetime.jpa.YearMonthToDateConverter</class>
    <class>com.github.perceptron8.datetime.jpa.YearMonthToLongConverter</class>
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
    private MonthDay monthDay;
    private YearMonth yearMonth;
    …
}
```
