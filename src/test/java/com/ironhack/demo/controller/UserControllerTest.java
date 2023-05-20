package com.ironhack.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.demo.enums.ActivityStatus;
import com.ironhack.demo.models.Activity;
import com.ironhack.demo.repositories.ActivityRepository;
import com.ironhack.demo.services.ActivityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles({"test"})
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    //falsa llamada a la api (mockear la llamada)
    private MockMvc mockMvc;

    // Nos permite convertir objetos a JSON
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    ActivityRepository activityRepository;

    @BeforeEach
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Activity activit11 = new Activity("Calisthenics", new BigDecimal(14.99), ActivityStatus.AVAILABLE);
        Activity activity12 = new Activity("Chinese Pole", new BigDecimal(18.99), ActivityStatus.WAITING_LIST);

        activityRepository.saveAll(List.of(activit11, activity12));

    }

    @Test
        void shouldPostNewActivity_WhenPostMethodIsCalled() throws Exception {
        Activity activity13 = new Activity("Aero Yoga", new BigDecimal(13.99), ActivityStatus.AVAILABLE);
        String body = objectMapper.writeValueAsString(activity13);
        MvcResult result = mockMvc.perform(post("/add-activity")
                            .content(body)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Aero"));
        assertEquals(8, activityRepository.findAll().size());

        System.out.println(result.getResponse().getContentAsString());
        }

}