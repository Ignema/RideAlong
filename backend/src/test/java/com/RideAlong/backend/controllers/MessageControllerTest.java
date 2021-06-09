package com.RideAlong.backend.controllers;

import com.RideAlong.backend.DAOs.MessageDAO;
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

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ParticipantController.class)
class MessageControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    MessageDAO messageDAO;

    @Test
    void getMessagesTest()throws Exception {
        mvc.perform(get("/message").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void getMessageByIdTest()throws Exception {
        mvc.perform(get("/message/{id}",1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addMessageTest()throws Exception {
        //String result = "Successfully created participant!";
        Message message= new Message();
        message.setContent("xxxxxxxx xxxxxxxx xxx");
        message.setDate(LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(message);

        mvc.perform(post("/message").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());

    }

    @Test
    void updateMessageTest()throws Exception {
        Message message= new Message();
        message.setContent("xxxxxxxx xxxxxxxx xxx");
        message.setDate(LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(message);

        mvc.perform(put("/message").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());

    }

    @Test
    void deleteMessageTest() throws Exception {
        mvc.perform(delete("/message/{id}",2))
                .andExpect(status().isOk());
    }


}