package com.eightfeatures;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javafx.util.converter.LocalDateStringConverter;

public class DateTimeApiTest {

	public static void main(String[] args) {
		 dateImmutabilityExp();
//		localDateTime();
	}

	public static void localDateTime() {
		LocalDateTime dateTime = LocalDateTime.now().plusDays(1).plusHours(1).plusMinutes(20);
		System.out.println(dateTime);
	}

	public static void dateImmutabilityExp() {
		ZoneId zoneId = ZoneId.of("America/New_York");
		System.out.println("Zone Id : "+zoneId.toString());
		LocalDate localDate= LocalDate.of(2019, 01, 30);
		System.out.println("LocalDate : "+localDate);
		LocalTime localTime= LocalTime.of(20, 24);
		System.out.println("LocalTime : "+localTime);
		ZonedDateTime zonedDateTime=ZonedDateTime.of(localDate, localTime,zoneId);
		System.out.println("ZonedLocalTime : "+zonedDateTime);
		
		LocalTime localTime2= LocalTime.from(zonedDateTime);

		System.out.println(localTime2);
	}

}
