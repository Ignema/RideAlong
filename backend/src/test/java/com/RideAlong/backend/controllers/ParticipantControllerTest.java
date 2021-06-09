package com.RideAlong.backend.controllers;


import com.RideAlong.backend.DAOs.ParticipantDAO;
import com.RideAlong.backend.models.Participant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ParticipantController.class)
class ParticipantControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    ParticipantDAO participantDAO;

    @Test
    void getParticipantsTest()throws Exception {
         mvc.perform(get("/participant").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

    }

    @Test
    void getParticipantsByIdTest()throws Exception {
        mvc.perform(get("/participant/{id}",1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void signeUpTest()throws Exception {
        //String result = "Successfully created participant!";
        Participant participant = new Participant();
        participant.setEmail("X@gmail.com");
        participant.setName("X");
        participant.setPhone(05);
        participant.setPassword("azerty");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(participant);

        mvc.perform(post("/signup").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                /* .andExpect(MockMvcResultMatchers.jsonPath("$",
                        Matchers.is("Successfully created participant!")))*/;

    }

    @Test
    void updateParticipantTest()throws Exception {
        //String result = "Successfully created participant!";
        Participant participant = new Participant();
        participant.setEmail("X@gmail.com");
        participant.setName("X");
        participant.setPhone(05);
        participant.setPassword("azerty");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(participant);

        mvc.perform(put("/participant").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
               /* .andExpect(MockMvcResultMatchers.jsonPath("$",
                        Matchers.is("Successfully created participant!")))*/;

    }

    @Test
    void deleteParticipantTest() throws Exception {
        mvc.perform(delete("/participant/{id}",2))
        .andExpect(status().isOk());
    }


}