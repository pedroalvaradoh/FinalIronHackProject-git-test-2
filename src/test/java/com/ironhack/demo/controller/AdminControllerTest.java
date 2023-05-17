package com.ironhack.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.demo.enums.ActivityStatus;
import com.ironhack.demo.models.Activity;
import com.ironhack.demo.models.Admin;
import com.ironhack.demo.repositories.ActivityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AdminControllerTest {



    // Nos da la instancia de la aplicacion
    @Autowired
    private WebApplicationContext webApplicationContext;
    //falsa llamada a la api (mockear la llamada)

    private MockMvc mockMvc;

    // Nos permite convertir objetos a JSON
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    ActivityRepository activityRepository;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Activity activity6 = new Activity("Handstand",new BigDecimal(16.99), ActivityStatus.AVAILABLE);
        Activity activity7 = new Activity("Vinyasa Yoga",new BigDecimal(13.99), ActivityStatus.WAITING_LIST);

        activityRepository.saveAll(List.of(activity6,activity7));
    }

    @Test
    public void shouldAddNewActivity_WhenPostMethodIsCalled() throws Exception {
        Activity activity8 = new Activity("Ashtanga Yoga",new BigDecimal(13.99), ActivityStatus.AVAILABLE);
        String body = objectMapper.writeValueAsString(activity8);
        MvcResult result = mockMvc.perform(post("/add-activity")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Yoga"));

        System.out.println(result.getResponse().getContentAsString());

    }

}
