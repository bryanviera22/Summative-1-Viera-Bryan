package com.company.projectapis.controller;

import com.company.projectapis.models.Quote;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class QuoteController {

    private List<Quote> quoteList;
    private static int idCounter = 1;

    public QuoteController(){
        quoteList = new ArrayList<>();

        quoteList.add(new Quote(idCounter++, "Harper Lee", "You never really understand a person " +
                "until you consider things from his view point " ));
        quoteList.add(new Quote(idCounter++, "Maya Angelou", "If you're always trying to be normal" +
                "you will never know how amazing you can be"));
        quoteList.add(new Quote(idCounter++, "Mac Miller", "Life goes on, days get brighter") );
        quoteList.add(new Quote(idCounter++, "Mahatma Gandhi", "You must be the change you wish to see in the world"));
        quoteList.add(new Quote(idCounter++, "Maya Angelou", "You will face many defeats in life, but never let yourself be defeated"));
        quoteList.add(new Quote(idCounter++, "Nelson Mandela", "It always seems impossible until it's done"));
        quoteList.add(new Quote(idCounter++, "Walt Disney", "All our dreams can come true if we have the courage to pursue them"));
        quoteList.add(new Quote(idCounter++, "Kobe Bryant", "Great things come from hard work and perseverance. No excuses"));
        quoteList.add(new Quote(idCounter++, "Mother Teresa", "Spread love everywhere you go. Let no one ever come to you" +
                "without leaving happier"));
        quoteList.add(new Quote(idCounter++, "Confucius", "When anger arises, think of the consequences"));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus
    public Quote getSingleQuote() {

        Random random = new Random();

        int randomIndex = random.nextInt(10);
        Quote randomQuote = quoteList.get(randomIndex);

        return randomQuote;

    }


}
