package com.company.projectapis.controller;

import com.company.projectapis.models.Magic8Ball;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

@RestController
public class Magic8BallController {

    private List<String> responseList = new ArrayList();

   //private static int idCounter = 1;

    public Magic8BallController(){

        responseList.add("My reply is no");
        responseList.add("Don't count on it");
        responseList.add("Yes");
        responseList.add("Most likely");
        responseList.add("Ask again later");
        responseList.add("Cannot predict now");

    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public Magic8Ball getRandomResponse(@RequestBody @Valid String question){
        Random random = new Random();

        int randomIndex = random.nextInt(6);
        Magic8Ball randomResponse = new Magic8Ball(question, responseList.get(randomIndex), randomIndex);
        return randomResponse;

    }

}
