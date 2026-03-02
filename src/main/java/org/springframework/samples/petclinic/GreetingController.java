package org.springframework.samples.petclinic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/comp367")
    public String greeting() {

        int hour = 15;   // forces afternoon
        String message;

        if (hour < 12) {
            message = "Good morning, Shah Syed, Welcome to COMP367";
        } else {
            message = "Good afternoon, Shah Syed, Welcome to COMP367";
        }

        return message;
    }
}
