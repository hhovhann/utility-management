package com.hhovhann.utilitymanagement.controller;

import com.hhovhann.utilitymanagement.model.RequestModel;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MeasurementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void whenAddMeasurement_thenShouldReturnStatusOk() throws Exception {
        this.mockMvc.perform(post("/measurements")
                .contentType(MediaType.APPLICATION_JSON)
                .content(RequestModel.builder().userId(1L).coldWaterMeter(12345L).hotWaterMeter(12335L).gasMeter(12345L).toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }


    @Test
    @Order(2)
    public void whenRequestMeasurement_thenShouldReturnStatusOk() throws Exception {
        this.mockMvc.perform(get("/measurements/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @Order(3)
    public void whenRequestWrongMeasurement_thenShouldReturnStatusOk() throws Exception {
        this.mockMvc.perform(get("/measurements/1asd")).andDo(print()).andExpect(status().isBadRequest());
    }

}