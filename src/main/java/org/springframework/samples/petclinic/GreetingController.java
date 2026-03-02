package org.springframework.samples.petclinic;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {

	@GetMapping("/comp367")
	String greeting() {
		int hour = LocalTime.now().getHour();
		String message;

		if (hour < 12) {
			message = "Good morning, Shah Syed, Welcome to COMP367";
		}
		else {
			message = "Good afternoon, Shah Syed, Welcome to COMP367";
		}

		return message;
	}

}
