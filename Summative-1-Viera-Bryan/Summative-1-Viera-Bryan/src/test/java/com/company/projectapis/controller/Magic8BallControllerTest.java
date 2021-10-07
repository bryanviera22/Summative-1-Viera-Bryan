package com.company.projectapis.controller;

import com.company.projectapis.models.Magic8Ball;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteController.class)
public class Magic8BallControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<String> responseList = new ArrayList();

    @Before
    public void setUp(){
    }

    @Test
    public void shouldReturnRandomBallResponse() throws Exception{

        Magic8Ball inputMagic = new Magic8Ball("Will I go to school tomorrow?", "Yes", 4);
//        inputMagic.setQuestion("Will I go to school tomorrow?");
//        inputMagic.setAnswer("Yes");

        String inputJson = mapper.writeValueAsString(inputMagic);

        Magic8Ball outputMagic = new Magic8Ball("Will I go to school tomorrow?", "Yes", 4);
//        outputMagic.setQuestion("Will I go to school tomorrow?");
//        outputMagic.setAnswer("Yes");
//        outputMagic.setId(4);

        String outputJson = mapper.writeValueAsString(outputMagic);

        mockMvc.perform(
                post("/magic")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated());

    }


}
