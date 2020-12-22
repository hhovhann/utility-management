package com.hhovhann.utilitymanagement.service;

import com.hhovhann.utilitymanagement.entity.Gas;
import com.hhovhann.utilitymanagement.entity.Measurement;
import com.hhovhann.utilitymanagement.entity.Water;
import com.hhovhann.utilitymanagement.repository.MeasurementRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
class MeasurementServiceImplTest {

    @BeforeEach
    public void setUp() {
        Measurement measurementOne = Measurement.builder()
                .id(1L)
                .gas(Gas.builder().gasMeter(654321L).build())
                .water(Water.builder().coldWaterMeter(112233L).hotWaterMeter(112233L).build())
                .build();

        Mockito.when(measurementRepository.findById(1L)).thenReturn(Optional.of(measurementOne));
    }

    @Autowired
    private MeasurementService measurementService;

    @MockBean
    private MeasurementRepository measurementRepository;

    @Test
    @DisplayName("Add valid measurements")
    public void whenValidMeasurement_thenShouldBeFind() {
        Optional<Measurement> found = measurementService.findMeasurement(1L);

        Assertions.assertEquals(found.get().getWater().getColdWaterMeter(), 112233L);
        Assertions.assertEquals(found.get().getWater().getHotWaterMeter(), 112233L);
        Assertions.assertEquals(found.get().getGas().getGasMeter(), 654321L);
    }
}