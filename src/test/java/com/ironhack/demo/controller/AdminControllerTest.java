package com.ironhack.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.demo.dto.ActivityDTO;
import com.ironhack.demo.dto.UserDTO;
import com.ironhack.demo.enums.ActivityStatus;
import com.ironhack.demo.models.Activity;
import com.ironhack.demo.models.User;
import com.ironhack.demo.repositories.ActivityRepository;
import com.ironhack.demo.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles ({"test"})
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
    @Autowired
    UserRepository userRepository;

    // Tests para rutas de tipo GET y PUT en la clase User

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Activity activity6 = new Activity("Handstand",new BigDecimal(16.99), ActivityStatus.AVAILABLE);
        Activity activity7 = new Activity("Vinyasa Yoga",new BigDecimal(13.99), ActivityStatus.WAITING_LIST);

        activityRepository.saveAll(List.of(activity6,activity7));

        User user10 = new User("Maria","emaildemaria@gmail.com",5319655L,null);

        userRepository.saveAll(List.of(user10));

    }

    @Test
    void shouldAddNewActivity_WhenPostMethodIsCalled() throws Exception {
        Activity activity8 = new Activity("Ashtanga Yoga",new BigDecimal(13.99), ActivityStatus.AVAILABLE);
        String body = objectMapper.writeValueAsString(activity8);
        MvcResult result = mockMvc.perform(post("/add-activity")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Yoga"));
        assertEquals(8,activityRepository.findAll().size());

        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void shouldReturnAllActivities_WhenGetMethodIsCalled() throws Exception {
        MvcResult result = mockMvc.perform(get("/manage-activity"))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Handstand"));
    }

    ActivityDTO activityDTO = new ActivityDTO("HIT",new BigDecimal(11.99),ActivityStatus.NOT_AVAILABLE);

    @Test
    void shouldUpdateActivity_WhenPatchMethodIsCalled() throws Exception {

        mockMvc.perform(patch("/update-activity-status/" + 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(activityDTO)))
                .andExpect(status().isOk());

    }
    @Test
    void shouldDeleteActivity_WhenDeleteMethodIsCalled() throws Exception {

        mockMvc.perform(delete("/delete-activityyy/"+ 1))
                .andExpect(status().isNoContent());
    }
    // Tests para rutas de tipo GET y PUT en la clase User
    @Test
    void shouldReturnAllUsers_WhenGetMethodIsCalled() throws Exception {
        mockMvc.perform(get("/check-user"))
                .andExpect(status().isOk());

        //assertTrue(result.getResponse().getContentAsString().contains("Maria"));

    }
//REVISAR ESTE TEST
    @Test
        void shouldUpdateUser_WhenPutMethodIsCalled() {

        UserDTO userDTO = new UserDTO();
        try {
            mockMvc.perform(put("/update-user/{id}", 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(userDTO)))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            System.err.println("Error al procesar el objeto JSON: " + e.getMessage());}

    }

    //REVISAR ESTE TEST
    @Test
    void shouldDeleteUser_WhenDeleteMethodIsCalled() throws Exception {
        Long userId = 1L;
        mockMvc.perform(delete("/delete-user/{id}",id))
                .andExpect(status().isNoContent());
    }
}
