package com.devarifkhan.spring_core.rest;

import com.devarifkhan.spring_core.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    // define a private field for the dependency
    private Coach coach;

    //define a constructor for dependency injection
    @Autowired
    public Controller(@Qualifier("cricketCoach") Coach theCoach
    ) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        coach = theCoach;
    }

//    @Autowired
//    public void setCoach(Coach theCoach){
//        coach=theCoach;
//    }

    // expose a new endpoint for "workout"
    @GetMapping("/dailyworkout")
    public String getWorkout() {
        return coach.getDailyWorkout();
    }


}