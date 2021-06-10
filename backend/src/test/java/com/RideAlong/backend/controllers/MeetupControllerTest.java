package com.RideAlong.backend.controllers;

import com.RideAlong.backend.DAOs.MeetupDAO;
import com.RideAlong.backend.DAOs.MessageDAO;
import com.RideAlong.backend.models.Meetup;
import com.RideAlong.backend.models.Message;
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

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParticipantController.class)
class MeetupControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    MeetupDAO meetupDAO;

    @Test
    void getMeetupTest()throws Exception {
        mvc.perform(get("/meetup").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void getMeetupByIdTest()throws Exception {
        mvc.perform(get("/meetup/{id}",1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getUserMeetupTest()throws Exception {
        mvc.perform(get("/meetup/user/{id}",1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addMeetupTest()throws Exception {

        Meetup meetup = new Meetup();
        meetup.setDate(LocalDateTime.now());
        meetup.setMessages(new ArrayList<Message>());
        meetup.setLocation("rabat agdal");


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(meetup);

        mvc.perform(post("/meetup").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());

    }

    @Test
    void updateMeetupTest()throws Exception {

        Meetup meetup = new Meetup();
        meetup.setDate(LocalDateTime.now());
        meetup.setMessages(new ArrayList<Message>());
        meetup.setLocation("rabat agdal");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(meetup);

        mvc.perform(put("/message").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());


    }

    @Test
    void deleteMeetupTest() throws Exception {
        mvc.perform(delete("/meetup/{id}",2))
                .andExpect(status().isOk());
    }


}