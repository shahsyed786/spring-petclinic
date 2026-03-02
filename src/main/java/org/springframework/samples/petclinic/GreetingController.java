package org.springframework.samples.petclinic;

import java.time.LocalTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/comp367")
    public String greeting() {

        int hour = LocalTime.now().getHour();

        if (hour < 12) {
            return "Good morning, Shah Syed, Welcome to COMP367";
        } else {
            return "Good afternoon, Shah Syed, Welcome to COMP367";
        }
    }
}
