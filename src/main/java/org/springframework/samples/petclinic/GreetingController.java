package org.springframework.samples.petclinic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {

	@GetMapping("/comp367")
	String greeting() {

		int hour = 15; // force afternoon

		if (hour < 12) {
			return "Good morning, Shah Syed, Welcome to COMP367";
		}
		else {
			return "Good  morning, Shah Syed, Welcome to COMP367";
		}

	}

}
