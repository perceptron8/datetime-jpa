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
| Year           | INTEGER    |

Credits:
* [montanajava/jpaattributeconverters](https://bitbucket.org/montanajava/jpaattributeconverters) 
* [marschall/threeten-jpa](https://github.com/marschall/threeten-jpa)


Usage
-----
```xml
<persistence-unit>
    …
    <class>com.github.marschall.threeten.jpa.LocalTimeConverter</class>
    <class>com.github.marschall.threeten.jpa.LocalDateConverter</class>
    <class>com.github.marschall.threeten.jpa.LocalDateTimeConverter</class>
    …
</persistence-unit>
```

```java
@Entity
public class SampleEntity {
  private LocalDate localDate;
  private LocalTime localTime;
  private LocalDateTime localDateTime;
}
```

All the converters have set `Converter#autoApply()` to `true` to they're automatically applied to all entities in the same persistence unit.
