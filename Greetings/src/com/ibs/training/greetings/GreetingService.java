package com.ibs.training.greetings;

import java.time.LocalTime;

public class GreetingService {

	public String getGreeting() {
		LocalTime time = LocalTime.now();
		
		if (time.getHour() < 12) {
			return "Good Mornig";
		}else if (time.getHour() < 14) {
			return "Good Afternoon";
		}else if (time.getHour() < 21) {
			return "Good Evening";
		}else {
			return "Good night";
		}
	}

}
