datetime-jpa [![Build Status](https://travis-ci.org/perceptron8/datetime-jpa.svg?branch=master)](https://travis-ci.org/perceptron8/datetime-jpa) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.perceptron8/datetime-jpa/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.perceptron8/datetime-jpa)
============
JPA 2.1¹ attribute converters for JSR-310 temporal types (java.time.*).


Following conversions are supported:

| Java SE 8      | ANSI SQL       |
| -------------- | -------------- |
| DayOfWeek      | INTEGER        |
| LocalDate¹     | DATE           |
| LocalDateTime¹ | TIMESTAMP      |
| LocalTime¹     | TIME           |
| Month          | INTEGER        |
| MonthDay       | DATE, LONG²    |
| Year           | DATE², INTEGER |
| YearMonth      | DATE, LONG²    |

¹ - supported natively as of JPA 2.2<br/>
² - use `@Convert` to choose this one


Credits
-------
* [javaee/jpa-spec#63](https://github.com/javaee/jpa-spec/issues/63)
* [montanajava/jpaattributeconverters](https://bitbucket.org/montanajava/jpaattributeconverters) 
* [marschall/threeten-jpa](https://github.com/marschall/threeten-jpa)


Usage
-----

```xml
<dependency>
    <groupId>com.github.perceptron8</groupId>
    <artifactId>datetime-jpa</artifactId>
    <version>0.1.0</version>
</dependency>
```

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
