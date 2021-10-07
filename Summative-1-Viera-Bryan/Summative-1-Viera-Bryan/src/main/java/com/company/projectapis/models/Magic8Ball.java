package com.company.projectapis.models;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;


public class Magic8Ball {


    @NotEmpty
    private String question;

    private String answer;
    private int id;

    public Magic8Ball(String question, String answer, int id) {

        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magic8Ball that = (Magic8Ball) o;
        return getId() == that.getId() && Objects.equals(getQuestion(), that.getQuestion()) && Objects.equals(getAnswer(), that.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion(), getAnswer(), getId());
    }
}
