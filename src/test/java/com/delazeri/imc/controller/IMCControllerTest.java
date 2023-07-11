package com.delazeri.imc.controller;

import com.delazeri.imc.models.IMCRequest;
import com.delazeri.imc.models.IMCResponse;
import com.delazeri.imc.models.enums.IMCStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class IMCControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCalculateIMC() throws Exception {
        double height = 1.75;
        double weight = 75.0;
        IMCRequest imcRequest = new IMCRequest(height, weight);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(imcRequest);

        double expectedImc = 24.49;

        IMCResponse imcResponse = new IMCResponse(height, weight, expectedImc, IMCStatus.NORMAL);

        mockMvc.perform(post("/api/imc")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(imcResponse)));
    }
}
