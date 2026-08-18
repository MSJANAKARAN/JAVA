package com.jana.problems;

import java.time.LocalDate;
import java.time.Period;

public class DateAfterNthDay {

	public static void main(String[] args) {
		// Oracle GBU final round.
		// Given a date, what is the the date after n days.

		long n = 50;
		LocalDate date = LocalDate.of(2000, 4, 5);
		findDate(date, n);
	}

	private static void findDate(LocalDate date, long n) {
		LocalDate res = date.plusDays(n);
		System.out.println(date);
		System.out.println(res);
	}

}
