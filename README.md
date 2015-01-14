datetime-jpa
============

JPA 2.1 attribute converters for JSR-310 (Java 8) dates and times. See [JPA_SPEC-63](https://java.net/jira/browse/JPA_SPEC-63).

Following conversions are supported.

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
}
```

Most of the converters have set `Converter#autoApply()` to `true` to they're automatically applied to all entities in the same persistence unit.
