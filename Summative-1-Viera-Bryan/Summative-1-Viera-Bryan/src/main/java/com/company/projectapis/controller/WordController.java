package com.company.projectapis.controller;

import com.company.projectapis.models.Word;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {

    private List<Word> wordList;

    private static int idCounter = 1;

    public WordController(){
        wordList = new ArrayList<>();

        wordList.add(new Word(idCounter++, "Negligible", "So small or unimportant to be worth considering"));
        wordList.add(new Word(idCounter++, "Conceited", "Excessively proud of oneself"));
        wordList.add(new Word(idCounter++,"trifling", "Unimportant or trivial"));
        wordList.add(new Word(idCounter++, "Keen", "Highly developed"));
        wordList.add(new Word(idCounter++, "Pertain", "Be appropiate, related, or applicable"));
        wordList.add(new Word(idCounter++, "Daunting", "Seeming difficult to deal with in anticipation"));
        wordList.add(new Word(idCounter++, "Relentless", "Oppressively constant"));
        wordList.add(new Word(idCounter++, "Dwindle", "Diminish gradually in size, amount, or strength"));
        wordList.add(new Word(idCounter++, "Hideous", "Ugly or disgusting to look at"));
        wordList.add(new Word(idCounter++, "Staggering", "Deeply shocking"));

    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus
    public Word getSingleRandomWord(){

        Random random = new Random();

        int randomIndex = random.nextInt(10);
        Word randomWord = wordList.get(randomIndex);

        return randomWord;

    }


}
