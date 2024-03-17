package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.context.annotation.Bean;

// BEGIN

import java.time.LocalTime;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN


    @Bean
    public Daytime getDayTime() {
        LocalTime dayStart = LocalTime.of(6,0);
        LocalTime nightStart = LocalTime.of(22, 0);
        LocalTime now = LocalTime.now();
        if (now.isAfter(dayStart) && now.isBefore(nightStart)) {
            return new Day();
        } else {
            return new Night();
        }

    }


    // END
}


