package com.larry.junittry.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.larry.junittry.JunitTryApplication;
import com.larry.junittry.dao.SomethingsDAO;
import com.larry.junittry.dto.UpdateDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = JunitTryApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class SomethingsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testUpdate() throws Exception {
        UpdateDTO update = new UpdateDTO();
        update.setNewName("新名字");
        mockMvc.perform(post("/somethings/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(update)))
                .andExpect(status().isOk());
        Assert.assertEquals(update.getNewName(), SomethingsDAO.DATABASE.getName());
    }
}
